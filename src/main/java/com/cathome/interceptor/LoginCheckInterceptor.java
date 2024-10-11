package com.cathome.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.cathome.pojo.Result;
import com.cathome.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 配置拦截器业务
 */
@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpServletRequest req =  request; //强制转换方便后续获取url等操作
        HttpServletResponse resp = response;

        //1.判断是否是登陆，是登陆直接放行
        String url = req.getRequestURL().toString();
        if(url.contains("login")){
            log.info("是访问login接口，直接放行");
            return true; //避免执行下面操作
        }

        //2.获取响应头中的token
        String jwt = req.getHeader("token");
        //判断jwt是否为空,
        if(!StringUtils.hasLength(jwt)){ //是空则是未登录
            log.info("token令牌为空，用户为未登录");
            Result err = Result.error("还未登陆哦~");
            //将未登录的数据，绑定在响应中，返回给前端
            resp.getWriter().write(JSONObject.toJSONString(err));
            return false;
        }

        //3.判断jwt是否有效
        try { //token令牌有效
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) { //无效
            e.printStackTrace();
            log.info("token令牌为空，用户为未登录");
            Result err = Result.error("还未登陆哦~");
            //将未登录的数据，绑定在响应中，返回给前端
            resp.getWriter().write(JSONObject.toJSONString(err));
            return false;
        }

        //4.运行
        log.info("核验成功，运行！");
        return true; //true放行 false不放行
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("获取目标资源后");
//        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("视图渲染完毕");
//        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
