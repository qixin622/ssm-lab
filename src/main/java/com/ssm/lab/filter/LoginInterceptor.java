package com.ssm.lab.filter;

import com.ssm.lab.bean.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        String url = httpServletRequest.getRequestURI();
        if(url.toLowerCase().indexOf("login")>=0){
            return true;
        }

        if (url.toLowerCase().indexOf("manage") > 0) {
            HttpSession session = httpServletRequest.getSession();
            User user = (User) session.getAttribute("user");
            if (user != null) {
                String role = user.getRole();
                //普通用户无法操作任何管理模块
                if (role.equals("0")) {
                    httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/index");
                    return false;
                }
                return true;
            } else {
                httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/to_login");
                return false;
            }
        }
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
