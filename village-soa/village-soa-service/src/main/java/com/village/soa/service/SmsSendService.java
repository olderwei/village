package com.village.soa.service;

import com.village.soa.service.domain.result.BaseResult;

/**
 * Created by chenwei on 2016/11/29.
 */
public interface SmsSendService {

    /**
     * 发送短信
     *
     * @param phone
     * @return
     */
    public BaseResult sendSms(String phone);

    /**
     * 验证短信校验码
     */
    public BaseResult checkDynamicPassword(String phone, String dynamicPassword);
}
