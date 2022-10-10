package com.kkjz.interception;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author kkjz
 * @create 2022-09-02 11:54
 * 拦截用户信息 给session加入默认的用户信息
 */

@Component
public class UserIntecepotor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        try {
            String userName = (String) request.getSession().getAttribute("userName");
            if(userName!=null){
                return true;
            }
        }catch (Exception e){
            request.getSession().setAttribute("userID", null);
            request.getSession().setAttribute("userName", null);
            request.getSession().setAttribute("userHand", null);
        }
        return true;
    }

}
