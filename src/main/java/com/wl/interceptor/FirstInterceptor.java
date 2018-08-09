package com.wl.interceptor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Vincent on 2018-08-08.
 */
public class FirstInterceptor extends HandlerInterceptorAdapter {

    private static Logger logger = LogManager.getLogger(FirstInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        String httpUrl = request.getServletPath();
        logger.info("请求httpUrl:{}",httpUrl);
        return true;

    }
}
