package com.primegenerator.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Kelvin
 *
 */
@Configuration
@EnableWebSecurity
public class WebConfig extends WebSecurityConfigurerAdapter {

    private static final String[] PUBLIC_MATCHERS = {
            "/",
            "/h2-console/**",
            "/v2/api-docs/**",
            "/swagger-ui.html/**",
            "/configuration/**",
            "/swagger-resources/**",
            "/webjars/**",
            "/api/v1/prime"
    };


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(PUBLIC_MATCHERS).permitAll()
                .anyRequest().authenticated()
                .and().httpBasic()
        .and().headers().frameOptions().disable();
    }

}
