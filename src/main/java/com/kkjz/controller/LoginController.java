package com.kkjz.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.kkjz.pojo.User;
import com.kkjz.service.impl.UserListServiceImpl;
import com.kkjz.utils.myUtil;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author kkjz
 * @create 2022-09-03 16:48
 */

@Controller
public class LoginController {

    @Autowired
    UserListServiceImpl userListService;

    @Resource
    Producer producer;


    @RequestMapping("loginservice.sf")
    public String loginService(@RequestParam("userName") String userName, @RequestParam("passWord") String passWord,
                               HttpServletRequest request) {
        // MD5转换
        String MD5 = myUtil.getMD5(passWord);

        User user = userListService.userLogin(userName, MD5);
        if (user == null) {
            // 用户或者密码错误
            request.setAttribute("PHO", true);
        } else {
            HttpSession session = request.getSession();

            //将用户ID放到session里面
            session.setAttribute("userID", user.getUserID());
            session.setAttribute("userName", userName);
            session.setAttribute("userHand", user.getUserHand());
            session.setAttribute("userRMB", user.getUserRMB());


            return "redirect:index.sf";

        }
        return "loginnew";
    }

    // 切换用户
    @RequestMapping("exect.sf")
    public String changeUser(HttpServletRequest request) {

        // 将session中的信息置空
        HttpSession session = request.getSession();

        session.setAttribute("userID", null);
        session.setAttribute("userName", null);
        session.setAttribute("userHand", null);
        session.setAttribute("userRMB", null);

        return "redirect:index.sf";
    }

    //kaptcha验证码
    @RequestMapping(value = "kaptcha.sf", method = RequestMethod.GET)
    public void kapatchaVertify(HttpServletRequest request, HttpServletResponse response) {
        /**
         * Cache-Control指定请求和响应遵循的缓存机制
         * no-store:用于防止重要的信息被无意的发布。在请求消息中发送将使得请求和响应消息都不使用缓存。
         * no-cache:指示请求或响应消息不能缓存
         */
        response.setHeader("Cache-Control", "no-store,no-cache");

        // 设置输出流内容格式为图片格式.image/jpeg,图片格式用于生成图片随机码
        response.setContentType("image/jpeg");

        // 生成文字验证码
        String text = producer.createText();
        System.out.println("验证码为" + text);

        // 生成图片验证码
        BufferedImage image = producer.createImage(text);

        // 保存验证码到session中
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, text);
        ServletOutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            ImageIO.write(image, "jpg", outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        IOUtils.closeQuietly(outputStream);
    }



}