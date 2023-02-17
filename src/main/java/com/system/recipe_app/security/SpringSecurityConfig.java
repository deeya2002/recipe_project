package com.system.recipe_app.security;

import com.system.recipe_app.Service.impl.CustomUserDetailService;
import com.system.recipe_app.config.PasswordEncoderUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity


public class SpringSecurityConfig {
    private final CustomUserDetailService customUserDetailService;

    public SpringSecurityConfig( CustomUserDetailService customUserDetailService){

        this.customUserDetailService = customUserDetailService;
    }
    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(customUserDetailService);
        authenticationProvider.setPasswordEncoder(PasswordEncoderUtil.getInstance());
        return authenticationProvider;
    }


    @Bean
    protected SecurityFilterChain filterChain (HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf().disable()
                .authorizeHttpRequests()
//                .requestMatchers("/login","/register")
                .requestMatchers("/login","/user/register","/user/save")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/dashboard",true)
                .usernameParameter("email")
                .permitAll()
                .and()
                .httpBasic();

        return  httpSecurity.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){
        return (web) -> web.ignoring().requestMatchers("/css/**","images/**");
    }
}