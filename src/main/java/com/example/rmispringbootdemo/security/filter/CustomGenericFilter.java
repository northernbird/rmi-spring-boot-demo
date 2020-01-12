package com.example.rmispringbootdemo.security.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomGenericFilter extends GenericFilter {

    Logger logger = LoggerFactory.getLogger(CustomGenericFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse)servletResponse;

        logger.info("ServletPath:  {}", httpServletRequest.getServletPath());
        logger.info("PathInfo:  {}", httpServletRequest.getPathInfo());

        if (httpServletRequest.getServletPath().startsWith("/api/servletpath")) {

            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.getWriter().write("Hello CustomGenericFilter World");

        } else {

            filterChain.doFilter(servletRequest,servletResponse);

        }

    }
}
