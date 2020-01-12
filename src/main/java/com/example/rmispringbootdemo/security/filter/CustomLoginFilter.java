package com.example.rmispringbootdemo.security.filter;

import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomLoginFilter extends AbstractAuthenticationProcessingFilter {

    /*
     * TODO Why do we need to give url ? How can we use it ???
     * N.F.I....
     */
    public CustomLoginFilter(String url, AuthenticationManager authenticationManager) {
        super(new AntPathRequestMatcher(url, HttpMethod.GET.name()));
    }

    /*
     * TODO How can I implement authentication process correctly ??
     * N.F.I....
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        return null;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        /*
         * TODO How can I implement authentication process correctly ??
         * N.F.I....
         */
//        Authentication authResult;
//        try {
//            authResult = attemptAuthentication(request, response);
//            if (authResult == null) {
//                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//                response.getWriter().write("INVALID BODY");
//                return;
//            }
//        } catch (AuthenticationException failed) {
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            return;
//        }
//
//        try {
//            SecurityContextHolder.getContext().setAuthentication(authResult);
//        } catch (Exception e) {
//            logger.error(e.getMessage(), e);
//            if (e.getCause() instanceof AccessDeniedException) {
//                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//                return;
//            }
//        }
        chain.doFilter(request, response);// return to others spring security filters
    }
}
