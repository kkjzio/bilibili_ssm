package com.kkjz.interception;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author kkjz
 * @create 2022-08-25 14:46
 */

// HandlerInterceptorAdapter 在5中过时了

@Component
public class AuthInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        //判断用户是否登录 访问了不该访问的页面
        String userName = (String) request.getSession().getAttribute("userName");
        if (userName != null) {
            return true;
        }


        //访问的用户没有登录...
        //跳转页面

        String addr = "";

        if (request.getQueryString() != null) {
            //这个是带参数的!
            addr = request.getRequestURI() + "?" + request.getQueryString();
        } else {
            //这个是不带参数的
            addr = request.getRequestURI();
        }
        System.out.println(addr);
        String jiequ = addr.substring(9);
        // jiequ  这个地址是用户想访问的地址
        request.getSession().setAttribute("jiequ", jiequ);
        System.out.println("被拦截网址： "+request.getRequestURI());

        response.sendRedirect("login.sf");
        return false;

    }

}