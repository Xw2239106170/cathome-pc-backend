package com.cathome.filter;

import com.alibaba.fastjson.JSONObject;
import com.cathome.pojo.Result;
import com.cathome.utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.IOException;

/**
 * 登录过滤器
 */
@Slf4j
//@WebFilter("/*")
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest; //强制转换方便后续获取url等操作
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        //1.判断是否是登陆，是登陆直接放行
        String url = req.getRequestURL().toString();
        if(url.contains("login")){
            log.info("是访问login接口，直接放行");
            filterChain.doFilter(servletRequest, servletResponse);
            return; //避免执行下面操作
        }

        //2.获取响应头中的token
        String jwt = req.getHeader("token");
        //判断jwt是否为空,
        if(!StringUtils.hasLength(jwt)){ //是空则是未登录
            log.info("token令牌为空，用户为未登录");
            Result err = Result.error("还未登陆哦~");
            //将未登录的数据，绑定在响应中，返回给前端
            resp.getWriter().write(JSONObject.toJSONString(err));
            return;
        }

        //3.判断jwt是否有效
        try { //token令牌有效
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) { //无效
            log.info("token令牌为空，用户为未登录");
            Result err = Result.error("还未登陆哦~");
            //将未登录的数据，绑定在响应中，返回给前端
            resp.getWriter().write(JSONObject.toJSONString(err));
//            throw new RuntimeException(e);
            e.printStackTrace();
        }

        //4.运行
        log.info("核验成功，运行！");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
