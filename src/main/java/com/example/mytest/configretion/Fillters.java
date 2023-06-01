package com.example.mytest.configretion;

import com.alibaba.fastjson.JSONObject;
import com.example.mytest.resulters.Resulte;
import io.jsonwebtoken.Jwt;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
@Component
public class Fillters implements Filter {
    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest) servletRequest;
        HttpServletResponse res=(HttpServletResponse) servletResponse;
        System.out.println("开始过滤");
        String url=req.getRequestURI().toString();
        System.out.println(url);
        if(url.contains("login")){
            System.out.println("123");
            filterChain.doFilter(req,res);
            return;
        }
        String token=req.getHeader("token");
        if(token==null){
            res.getWriter().write(JSONObject.toJSONString(Resulte.noken()));
            return;
        }
        try{
            String str= (String) redisTemplate.opsForValue().get("login-token"+token);
        }catch (Exception e){
            res.getWriter().write(JSONObject.toJSONString(Resulte.noken()));
        }
        filterChain.doFilter(req,res);
    }
}
