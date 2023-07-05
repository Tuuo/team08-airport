package com.isoft.config;


import com.isoft.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.web.filter.OncePerRequestFilter;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;


@Configuration
@EnableWebSecurity //开启MVC security安全支持
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Autowired
    VerifyCodeFilter verifyCodeFilter;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    MyAuthenticationFailureHandler myAuthenticationFailureHandler;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //自定义用户访问控制
        http.authorizeHttpRequests().antMatchers("/","/layui/css/**","/css/**","/layui/**","/js/**","/img/**","/qinjiang/css/**","/qinjiang/js/**","/verifyCode","/favicon.ico")//开启Ant等个路径匹配
                .permitAll()
                .antMatchers("/register").permitAll().antMatchers("/toLogin").permitAll()//无条件对请求放行
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3")
                .anyRequest().authenticated();//匹配任何请求,匹配已经登录认证的用户
        //自定义用户登录控制
        //没有权限默认到登录页面
        http.formLogin().loginPage("/toLogin").loginProcessingUrl("/toLogin").permitAll().usernameParameter("username")
                .passwordParameter("password").defaultSuccessUrl("/")//.failureHandler(authenticationFailureHandler)
                .failureHandler(myAuthenticationFailureHandler).permitAll();

        //自定义用户登出
        http.logout();
//
//        //记住我
////        http.rememberMe().rememberMeParameter("remember").tokenValiditySeconds(200)
////                .tokenRepository(tokenRepository());

        http.csrf().disable(); //关闭csrf功能，登陆失败可能出现的原因
        http.addFilterBefore(verifyCodeFilter, UsernamePasswordAuthenticationFilter.class);
    }


    //持久化Token存储
    @Bean
    public JdbcTokenRepositoryImpl tokenRepository() {
        JdbcTokenRepositoryImpl jr = new JdbcTokenRepositoryImpl();
        jr.setDataSource(dataSource);
        return jr;
    }
}
