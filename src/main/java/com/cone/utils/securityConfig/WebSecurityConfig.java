package com.cone.utils.securityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.cone.auth.service.impl.CustomUserServiceImpl;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	@Bean
    UserDetailsService customUserService() {
        return new CustomUserServiceImpl();
    }
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService());
    }

}
