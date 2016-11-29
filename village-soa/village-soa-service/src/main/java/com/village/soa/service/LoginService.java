package com.village.soa.service;

import com.village.soa.service.domain.result.BaseResult;

/**
 * Created by chenwei on 2016/11/29.
 */
public interface LoginService {

    /**
     * 根据用户名和密码登录
     * @param phone
     * @param password
     * @return
     */
    public BaseResult loginByUsernameAndPassword(String phone, String password);

    /**
     * 根据手机号和动态密码登录
     * @param phone
     * @param dynamicPassword
     * @return
     */
    public BaseResult loginByPhoneAndDynamicPassword(String phone, String dynamicPassword);
}
