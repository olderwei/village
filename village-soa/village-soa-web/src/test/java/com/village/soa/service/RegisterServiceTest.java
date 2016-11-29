package com.village.soa.service;

import com.alibaba.fastjson.JSON;
import com.village.soa.service.domain.param.VillagerParam;
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
public class RegisterServiceTest {

    @Resource
    private RegisterService registerService;

    @Test
    public void registerVillager() {
        VillagerParam villagerParam = new VillagerParam();
        villagerParam.setPhone("18610855413");
        villagerParam.setPassword("123456");
        System.out.println(JSON.toJSONString(registerService.registerVillager(villagerParam)));
    }
}
