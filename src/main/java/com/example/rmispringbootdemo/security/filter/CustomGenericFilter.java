package com.example.rmispringbootdemo.security.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class CustomGenericFilter extends GenericFilter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        System.out.println("ServletPath : " + httpServletRequest.getServletPath());
        System.out.println("PathInfo : " + httpServletRequest.getPathInfo());

        filterChain.doFilter(servletRequest,servletResponse);

    }
}
