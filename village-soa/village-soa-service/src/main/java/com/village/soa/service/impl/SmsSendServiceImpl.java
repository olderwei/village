package com.village.soa.service.impl;

import com.village.soa.service.SmsSendService;
import com.village.soa.service.domain.result.BaseResult;
import org.springframework.stereotype.Service;

/**
 * Created by chenwei on 2016/11/29.
 */
@Service("smsSendService")
public class SmsSendServiceImpl implements SmsSendService {

    @Override
    public BaseResult sendSms(String phone) {
        BaseResult baseResult = new BaseResult();

        baseResult.setSuccess(true);
        baseResult.setResultCode(0);
        baseResult.setErrorMsg("成功");

        return baseResult;
    }

    @Override
    public BaseResult checkDynamicPassword(String phone, String dynamicPassword) {
        BaseResult baseResult = new BaseResult();

        baseResult.setSuccess(true);
        baseResult.setResultCode(0);
        baseResult.setErrorMsg("成功");

        return baseResult;
    }
}
