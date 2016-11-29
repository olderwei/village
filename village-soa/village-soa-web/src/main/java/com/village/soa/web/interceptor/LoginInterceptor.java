package com.village.soa.web.interceptor;

import com.alibaba.fastjson.JSON;
import com.village.soa.service.domain.result.BaseResult;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import redis.clients.jedis.ShardedJedisPool;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by chenwei on 2016/11/26.
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    private static Logger LOGGER = LoggerFactory.getLogger(LoginInterceptor.class);

    @Resource
    private ShardedJedisPool shardedJedisPool;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getParameter("token");
        if (StringUtils.isBlank(token) || StringUtils.isBlank(shardedJedisPool.getResource().get(token))) {
            BaseResult baseResult = new BaseResult();
            baseResult.setSuccess(false);
            baseResult.setResultCode(1);
            baseResult.setErrorMsg("未登录");

            PrintWriter out = null;
            response.setContentType("application/json;charset=UTF-8");
            try {
                out = response.getWriter();
                out.print(JSON.toJSONString(baseResult));
            } catch (Exception e) {
                LOGGER.error("!Error: 验证登录异常, token is {}", token, e);
            } finally {
                if(out != null) {
                    out.flush();
                    out.close();
                }
                return false;
            }
        }
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
