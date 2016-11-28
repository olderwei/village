package com.village.soa.service;

import com.village.soa.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by chenwei on 2016/11/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
public class AccountServiceTest {

    @Resource
    private AccountService accountService;

    @Test
    public void addAccount() {
        Account account = new Account();
        account.setAccountNickName("张三");
        account.setPhone("18610855413");
        accountService.addAccount(account);
    }
}
