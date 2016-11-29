package com.village.soa.service;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by chenwei on 2016/11/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
public class LoginServiceTest {

    @Resource
    private LoginService loginService;

    @Test
    public void loginByUsernameAndPassword() {
        System.out.println(JSON.toJSONString(loginService.loginByUsernameAndPassword("18610855413", "123456")));
    }
}
