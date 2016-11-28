package com.village.soa.web.controller;

import com.village.soa.domain.Account;
import com.village.soa.service.AccountService;
import com.village.soa.service.domain.result.BaseResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.ShardedJedisPool;

import javax.annotation.Resource;

/**
 * Created by chenwei on 2016/11/26.
 */
@Controller
@RequestMapping(value = "/api/account")
public class AccountController {

    @Resource
    private AccountService accountService;

    @Resource
    private ShardedJedisPool shardedJedisPool;

    @ResponseBody
    @RequestMapping(value = "/addAccount", method = RequestMethod.POST)
    public BaseResult addAccount(@RequestBody Account account){
        shardedJedisPool.getResource().set("key1", "1");
        shardedJedisPool.getResource().setex("key2", 10, "1");
        System.out.println("Hello World");
        return accountService.addAccount(account);
    }
}
