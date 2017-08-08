package com.jiaxliu;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * =====================================================
 *
 * @Created with Intellij IDEA 2017.2
 * @PROJECT lessonone
 * @PACKAGE com.jiaxliu
 * @Author jiaxliu [ jiaxliu@outlook.com ]
 * @GitHub https://github.com/jiaxliu
 * @Date Aug 8/5/2017 16:45
 * <p>
 * <p>
 * =====================================================
 */

public class SessionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object o) throws Exception{
        //登录不做拦截
      /**  if(request.getRequestURI().equals("/user/sign-in")||request.getRequestURI().equals("/user/sign-in-view")){
            return true;
        }
        else */if (request.getRequestURI().equals("/user/sign-up")){
            response.sendRedirect("/user/sign-up-view");
            return true;
        }
        else if (request.getRequestURI().equals("/index")){
            response.sendRedirect("/user/index");
            return true;
        }
        else if (request.getRequestURI().equals("/user/list")){
            response.sendRedirect("/user/list-view");
            return true;
        }

/**
        //验证session是否存在
         Object obj = request.getSession().getAttribute("_session_user");
        if(obj==null){
                response.sendRedirect("/user/sign-in-view");
            return false;
        }*/

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request,HttpServletResponse response, Object o, Exception e){

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception{}

}

