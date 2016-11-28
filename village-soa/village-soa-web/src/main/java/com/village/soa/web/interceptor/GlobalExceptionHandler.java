package com.village.soa.web.interceptor;

import com.village.soa.service.domain.result.BaseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 * Created by chenwei on 2016/11/26.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler
    @ResponseBody
    public BaseResult exceptionHandler(Exception e) {
        BaseResult baseResult = new BaseResult();
        baseResult.setSuccess(false);
        baseResult.setErrorMsg("系统错误");
        baseResult.setResultCode(9);
        LOGGER.error("GlobalExceptionHandler error  = {} ", e);
        return baseResult;
    }
}
