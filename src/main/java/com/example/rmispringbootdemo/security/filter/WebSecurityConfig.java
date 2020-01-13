package com.example.rmispringbootdemo.security.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(new CustomAuthFilter("/api/customlogin", authenticationManager()), UsernamePasswordAuthenticationFilter.class)
                .addFilterAfter(new CustomGenericFilter(), CustomAuthFilter.class)
                .authorizeRequests()
                .antMatchers("/api/servletpath")
                .permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/api/customlogin")
                .authenticated();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("u").password("{noop}p").authorities("ROLE_APP_USER");
    }

}
