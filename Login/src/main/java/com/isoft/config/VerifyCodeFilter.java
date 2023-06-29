package com.isoft.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.isoft.entity.RespBean;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class VerifyCodeFilter extends GenericFilter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        if("POST".equals(req.getMethod()) && "/toLogin".equals(req.getServletPath())){
            //登录请求
            String code = req.getParameter("code");
            String verify_code = (String) req.getSession().getAttribute("verify_code");
            if (code == null || "".equals(code) || !verify_code.toLowerCase().equals(code.toLowerCase())){
                //验证码不正确
                req.setAttribute("captchaError", "true");
                resp.setContentType("image/jpeg");
                resp.setHeader("Pragma", "No-cache");
                resp.setHeader("Cache-Control", "no-cache");
                resp.setDateHeader("Expires", 0);
                resp.setContentType("application/json;charset=utf-8");
                PrintWriter out = resp.getWriter();
                out.write(new ObjectMapper().writeValueAsString(RespBean.error("验证码填写错误")));
                out.flush();
                out.close();
                return;
            }else {
                filterChain.doFilter(req, resp);
            }
        }else {
            filterChain.doFilter(req,resp);
        }
    }
}
