package com.kkjz.controller;

import com.kkjz.pojo.Favourite;
import com.kkjz.pojo.Message;
import com.kkjz.pojo.User;
import com.kkjz.pojo.Video;
import com.kkjz.service.FavouriteService;
import com.kkjz.service.UserListService;
import com.kkjz.service.VideoService;
import com.kkjz.service.MessageService;
import com.kkjz.service.impl.MessageServiceImpl;
import com.kkjz.utils.myUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author kkjz
 * @create 2022-08-25 16:15
 */
@Controller
public class MainController {

    @Autowired
    VideoService videoServiceImpl;
    @Autowired
    MessageService messageServiceImpl;
    @Autowired
    UserListService userListServiceImpl;
    @Autowired
    FavouriteService favouriteServiceImpl;

    // 装载首页滑动图的函数
    private void _picLoad(String videoID, String desc, List<Map> slidePic) {
        Video video = videoServiceImpl.videoByID(videoID);
        Map map = new HashMap();
        map.put("href", "video.sf/av" + videoID);
        map.put("picture", video.getVideoImage());
        map.put("desc", desc);
        slidePic.add(map);
    }


    // 将数据库里面所有的视频查询出来 发送到首页面
    @RequestMapping("index.sf")
    public ModelAndView logoone(HttpServletRequest request, HttpServletResponse response) {

        Map model = new HashMap();
        List<Video> list = videoServiceImpl.videoBycategoryWithlimit('1', 8);// 1 为动画
        model.put("list", list);
        List<Video> list2 = videoServiceImpl.videoBycategoryWithlimit('2', 8);// 2 为MAD
        model.put("list2", list2);
        List<Video> list3 = videoServiceImpl.videoBycategoryWithlimit('3', 8);// 3 为动漫
        model.put("list3", list3);
        List<Video> list4 = videoServiceImpl.videoBycategoryWithlimit('0', 6);// 不按种类 随机查6条数据出来
        model.put("list4", list4);


        //载入配置文件
        Properties p = new Properties();
        String v1,v2,v3,v4;
        String d1,d2,d3,d4;
        v1=v2=v3=v4="";
        d1=d2=d3=d4="";
        try {
            // 通过字符流读取
            InputStream in =this.getClass().getClassLoader().getResourceAsStream("slidePic.properties");
            p.load(new InputStreamReader(in, "UTF-8"));

            v1=p.getProperty("videoID.first");
            v2=p.getProperty("videoID.second");
            v3=p.getProperty("videoID.third");
            v4=p.getProperty("videoID.fourth");

            d1=p.getProperty("desc.first");
            d2=p.getProperty("desc.second");
            d3=p.getProperty("desc.third");
            d4=p.getProperty("desc.fourth");


            // 设置首页滑条显示的大头图和介绍 videoID，desc,slidePic

        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Map> slidePic = new ArrayList<Map>();

        // 设置首页滑条显示的大头图和介绍 videoID，desc,slidePic
        _picLoad(v1,d1,slidePic);
        _picLoad(v2,d2,slidePic);
        _picLoad(v3,d3,slidePic);
        _picLoad(v4,d4,slidePic);


        model.put("slidePic", slidePic);


        return new ModelAndView("index", model);
    }

    @RequestMapping("login.sf")
    public String login(HttpServletRequest request) {
        request.setAttribute("PHO", false);
        return "loginnew";
    }

    // 个人信息界面
    @RequestMapping("User_full_information.sf")
    public String UserInfo(HttpServletRequest request) {
        request.setAttribute("upSuccess", false);
        return "User_full_information";
    }

    // 投稿界面跳转
    @RequestMapping("videoFileTop.sf")
    public String videoUpload() {
        return "videoFileTop";
    }

    // 注册界面跳转
    @RequestMapping("zhuce.sf")
    public String toZhuce(HttpServletRequest request) {
        request.setAttribute("message", null);
        return "zhuce";
    }

    // 修改密码界面跳转
    @RequestMapping("Update_login_password.sf")
    public String toSetPassword(HttpServletRequest request) {
        request.setAttribute("message", null);
        return "Update_login_password";
    }

    // 收藏页面
    @RequestMapping(value = {"favourite.sf/{favouritePage}", "favourite.sf"})
    public ModelAndView toFavourite(@PathVariable(value = "favouritePage", required = false) String favouritePage,
                                    HttpServletRequest request) {
        if (favouritePage == null)
            favouritePage = "1";

        HttpSession session = request.getSession();
        String userID = (String) session.getAttribute("userID");
        // 字符串转int
        int page = Integer.parseInt(favouritePage);
        // 获取总页数：
        int count = favouriteServiceImpl.getCountByID(userID, null);
        int allPage = (count / 5);
        if (count % 5 != 0)
            allPage++;

        //判断页数是否过多或过少
        if (page > allPage) page = allPage;
        if (page < 1) page = 1;

//        System.out.println("page :"+page+" allPage:" +allPage);

        List<Favourite> favouriteList = favouriteServiceImpl.getFavouriteList(userID, page);
        Map model = new HashMap();
        model.put("favouriteList", favouriteList);
        model.put("page", page);
        model.put("allPage", allPage);


        return new ModelAndView("favourite", model);
    }


    // 投稿管理
    @RequestMapping(value = {"videoManege.sf/{videoManegePage}", "videoManege.sf"})
    public ModelAndView videoManege(@PathVariable(value = "videoManegePage", required = false) String videoManegePage,
                                    HttpServletRequest request) {
        if (videoManegePage == null)
            videoManegePage = "1";

        HttpSession session = request.getSession();
        String userID = (String) session.getAttribute("userID");
        // 字符串转int
        int page = Integer.parseInt(videoManegePage);
        // 获取总页数：
        int count = videoServiceImpl.getAllCountByUserID(userID);
        int allPage = (count / 5);
        if(count%5>0)
            allPage++;
        //判断页数是否过多或过少
        if (page > allPage) page = allPage;
        if (page < 1) page = 1;

//        System.out.println("page :"+page+" allPage:" +allPage);

        List<Video> videoList = videoServiceImpl.getVideoByPage(userID, page);
        Map model = new HashMap();
        model.put("videoList", videoList);
        model.put("page", page);
        model.put("allPage", allPage);


        return new ModelAndView("videoManege", model);
    }


    // 视频页面
    @RequestMapping(value = "/video.sf/{videoav}",method = RequestMethod.GET)
    public ModelAndView video(@PathVariable(value = "videoav") String videoav, HttpServletRequest request) {
        // page默认值
        String messagePage = "1";

        // 提取出videoId
        String videoID = videoav.substring(2);

        Map model = new HashMap();

        // 查询视频和作者信息
        Video video = videoServiceImpl.videoByID(videoID);
        User user = userListServiceImpl.getUser(video.getUserID());

        /****************** 评论页数 ************************/
        // 字符串转int
        int page = Integer.parseInt(messagePage);
        // 获取总页数：
        int count = messageServiceImpl.getAllCountByVideoID(videoID);
        int allPage = (count / 5);
        if(count>0)
            allPage++;

        // 处理描述为空的情况
        String describe = video.getvideoDescribe();
        if (describe == null)
            describe = "";

        // 处理String的字符给前端显示
        describe = describe.replaceAll("\n", "<br>");
        describe = describe.replaceAll("\r", "");

        request.setAttribute("shipingID", videoID);
        model.put("title", video.getVideoName());
        model.put("videoUper", user.getUserName());
        model.put("videoURL", video.getVideoAddress());
        model.put("describe", describe);
        model.put("page", page);
        model.put("allPage", allPage);

        return new ModelAndView("Video", model);
    }


    // 个人信息页面
    @RequestMapping("Information.sf")
    public ModelAndView informationSet(HttpServletRequest request) {
        Map model = new HashMap();

        User user = userListServiceImpl.getUser((String) request.getSession().getAttribute("userID"));

        // 删除敏感信息
        user.setPassWord("");
        model.put("user", user);

        return new ModelAndView("Information", model);
    }

    // 注册
    @RequestMapping("register.sf")
    public String register(User user, HttpServletRequest request, String verifyCode) {

        HttpSession session = request.getSession();
        // 验证码是否正确
        if (!(verifyCode.equals(session.getAttribute("KAPTCHA_SESSION_KEY")))) {
            request.setAttribute("message", "验证码不正确！");
            return "redirect:zhuce";
        }

        // 判断用户名是否存在
        if (userListServiceImpl.findUseID(user.getUserName()) != null) {
            request.setAttribute("message", "该用户名已存在");
            return "redirect:zhuce";
        }

        //把密码变成MD5
        String MD5 = myUtil.getMD5(user.getPassWord());


        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        user.setUserID(uuid);
        user.setPassWord(MD5);
        user.setUserState("正常");
        user.setUserRMB("0");
        user.setUserHand("/static/userHand_Top/upload/MyHand.png");

        // 写入sql
        if (userListServiceImpl.register(user) > 0) {
            request.setAttribute("message", "注册成功!");
            return "zhuce";
        }

        request.setAttribute("message", "未知错误");
        return "zhuce";


    }

    // 用户密码更改
    @RequestMapping("setPassword.sf")
    public String setPassword(String passWord, String newpassWord, String newpassWord2,
                              HttpServletRequest request) {


        // 转化为MD5
        String MD5password = myUtil.getMD5(passWord);
        User user = userListServiceImpl.getUser((String) request.getSession().getAttribute("userID"));

        // 判断原密码
        if (!(user.getPassWord().equals(MD5password))) {
            request.setAttribute("message", "原密码错误");
            return "Update_login_password";
        }

        // 判断新密码
        String reg = ".{6,20}";
        if (!(newpassWord.matches(reg))) {
            request.setAttribute("message", "密码大小限制为6-20个字符");
            return "Update_login_password";
        }

        if (!(newpassWord.equals(newpassWord2))) {
            request.setAttribute("message", "两次密码输入不一致");
            return "Update_login_password";
        }


        // 生成MD5
        MD5password = myUtil.getMD5(newpassWord2);
        user.setPassWord(MD5password);

        // 传入sql
        if (userListServiceImpl.updateUserbyUser(user) > 0) {
            request.setAttribute("message", "密码修改成功");
            return "Update_login_password";
        }

        request.setAttribute("message", "未知错误");
        return "Update_login_password";

    }


}
