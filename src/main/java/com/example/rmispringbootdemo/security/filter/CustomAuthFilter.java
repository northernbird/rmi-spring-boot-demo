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

public class CustomAuthFilter extends AbstractAuthenticationProcessingFilter {

    /*
     * TODO Why do we need to give url ? How can the url be used ?
     * Same question is for org.springframework.security.authentication.AuthenticationManager as well.
     */
    public CustomAuthFilter(String url, AuthenticationManager authenticationManager) {
        super(new AntPathRequestMatcher(url, HttpMethod.GET.name()));
    }

    /*
     * TODO How can I implement authentication process correctly ??
     *  Question 1 : org.springframework.security.core.Authentication is interface. If we want to implement for our own,
     *               How can we do that ? Is there any guidance to do it ?
     *  Question 2 : Should we implement our authentication logic here? If so what should we do if authenticate is
     *               failed? Just returning null is fine?
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        return null;
    }

    /*
     * TODO How can I implement authentication process correctly ??
     * If the `attemptAuthentication` method returns Authentication, should we set SecurityContextHolder?
     * (e.g. SecurityContextHolder.getContext().setAuthentication(authentication); )
     */
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(req, res);// return to others spring security filters
    }
}
