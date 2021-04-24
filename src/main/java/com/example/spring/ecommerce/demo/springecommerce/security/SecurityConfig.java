package com.example.spring.ecommerce.demo.springecommerce.security;

import com.example.spring.ecommerce.demo.springecommerce.Service.impl.AdminServiceImpl;
import com.example.spring.ecommerce.demo.springecommerce.security.handler.CustomAccessDeniedHandler;
import com.example.spring.ecommerce.demo.springecommerce.security.handler.CustomAuthenticationEntryPoint;
import com.example.spring.ecommerce.demo.springecommerce.security.jwt.JwtAuthenticationFilter;
import com.example.spring.ecommerce.demo.springecommerce.security.jwt.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

    private final AdminServiceImpl adminService;
    private final JwtTokenUtil jwtTokenUtil;
    private final CustomAuthenticationEntryPoint authenticationEntryPoint;
    private final CustomAccessDeniedHandler accessDeniedHandler;

    @Autowired
    public SecurityConfig(AdminServiceImpl adminService, JwtTokenUtil jwtTokenUtil, CustomAuthenticationEntryPoint authenticationEntryPoint, CustomAccessDeniedHandler accessDeniedHandler) {
        this.adminService = adminService;
        this.jwtTokenUtil = jwtTokenUtil;
        this.authenticationEntryPoint = authenticationEntryPoint;
        this.accessDeniedHandler = accessDeniedHandler;
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .csrf().disable()
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/", "index", "/css/*", "/js/*","/swagger-resources/**","/v2/api-docs/**").permitAll()
                .antMatchers("/**").permitAll() // for testing purpose
                .antMatchers("/admin/**").permitAll()
                .anyRequest()
                .authenticated();
        httpSecurity.addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        httpSecurity.exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler)
                .authenticationEntryPoint(authenticationEntryPoint);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(adminService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationTokenFilter(){
        return new JwtAuthenticationFilter(adminService, jwtTokenUtil);
    }
}
