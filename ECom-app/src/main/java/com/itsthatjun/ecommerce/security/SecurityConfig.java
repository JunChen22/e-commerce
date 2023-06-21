package com.itsthatjun.ecommerce.security;

import com.itsthatjun.ecommerce.security.handler.CustomAccessDeniedHandler;
import com.itsthatjun.ecommerce.security.handler.CustomAuthenticationEntryPoint;
import com.itsthatjun.ecommerce.security.jwt.JwtAuthenticationFilter;
import com.itsthatjun.ecommerce.security.jwt.JwtTokenUtil;
import com.itsthatjun.ecommerce.service.UMS.implementation.MemberServiceImpl;
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
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final MemberServiceImpl memberService;
    private final JwtTokenUtil jwtTokenUtil;
    private final CustomAuthenticationEntryPoint authenticationEntryPoint;
    private final CustomAccessDeniedHandler accessDeniedHandler;

    @Autowired
    public SecurityConfig(MemberServiceImpl memberService, JwtTokenUtil jwtTokenUtil, CustomAuthenticationEntryPoint authenticationEntryPoint, CustomAccessDeniedHandler accessDeniedHandler) {
        this.memberService = memberService;
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
                .antMatchers("/", "/actuator", "index", "/css/*", "/js/*","/swagger-resources/**","/v2/api-docs/**").permitAll()
                .antMatchers("/brand/**","/product/**","/user/**","/article/**").permitAll()
                .antMatchers("/reviews/getAllProductReview/**").permitAll()
                //.antMatchers("/**").permitAll()  // TODO: for testing purposes. All endpoints are open. Remove when needed.
                .antMatchers("/order/success**", "/order/cancel**").permitAll() // TODO: remove this when using a front that store the jwt token
                .anyRequest()
                .authenticated();

        // TODO: remove comment when security needed
        // authenticate the JWT token before Spring Security if you have a token.
        httpSecurity.addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        // TODO: handler is not being used
        httpSecurity.exceptionHandling().accessDeniedHandler(accessDeniedHandler).authenticationEntryPoint(authenticationEntryPoint);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(memberService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationTokenFilter(){
        return new JwtAuthenticationFilter(memberService, jwtTokenUtil);
    }
}
