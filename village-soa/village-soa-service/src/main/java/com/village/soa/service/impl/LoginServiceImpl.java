package com.village.soa.service.impl;

import com.village.soa.common.constant.RedisKey;
import com.village.soa.common.util.Md5Util;
import com.village.soa.domain.Villager;
import com.village.soa.manager.VillagerManager;
import com.village.soa.service.LoginService;
import com.village.soa.service.SmsSendService;
import com.village.soa.service.domain.result.BaseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import redis.clients.jedis.ShardedJedisPool;

import javax.annotation.Resource;

/**
 * Created by chenwei on 2016/11/29.
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Resource
    private SmsSendService smsSendService;

    @Resource
    private VillagerManager villagerManager;

    @Resource
    private ShardedJedisPool shardedJedisPool;

    @Override
    public BaseResult loginByUsernameAndPassword(String phone, String password) {
        BaseResult baseResult = new BaseResult();
        try {
            Villager villager = villagerManager.findVillagerByPhoneOrUsernameAndPassword(phone, Md5Util.md5(password));
            if (villager != null) {
                String token = getToken(phone);
                //缓存登录token
                shardedJedisPool.getResource().setex(token, 60*60*60*10, phone);

                baseResult.getResult().put("token", token);
                baseResult.setSuccess(true);
                baseResult.setResultCode(0);
                baseResult.setErrorMsg("成功");
            } else {
                baseResult.setSuccess(false);
                baseResult.setResultCode(1000);
                baseResult.setErrorMsg("用户未注册或密码错误");
            }
        } catch (Exception e) {
            baseResult.setSuccess(false);
            baseResult.setResultCode(9);
            baseResult.setErrorMsg("系统错误");
            LOGGER.error("!Error: Find villager by phone and password error, phone = {}", phone, e);
        }
        return baseResult;
    }

    @Override
    public BaseResult loginByPhoneAndDynamicPassword(String phone, String dynamicPassword) {
        BaseResult baseResult = new BaseResult();
        try {
            if (smsSendService.checkDynamicPassword(phone, dynamicPassword).isSuccess()) {
                Villager villager = villagerManager.findVillagerByPhone(phone);
                if (villager == null) {
                    villager = new Villager();
                    villager.setPhone(phone);
                    villagerManager.saveVillager(villager);
                }

                String token = getToken(phone);
                //缓存登录token
                shardedJedisPool.getResource().setex(token, 60*60*60*10, phone);

                baseResult.getResult().put("token", token);
                baseResult.setSuccess(true);
                baseResult.setResultCode(0);
                baseResult.setErrorMsg("成功");
            } else {
                baseResult.setSuccess(false);
                baseResult.setResultCode(1001);
                baseResult.setErrorMsg("登录动态验证码错误");
                LOGGER.error("!Error: Check dynamic password error, phone = {}, dynamicPassword = {}", phone, dynamicPassword);
            }
        } catch (Exception e) {
            baseResult.setSuccess(false);
            baseResult.setResultCode(9);
            baseResult.setErrorMsg("系统错误");
            LOGGER.error("!Error: Find villager by phone and password error, phone = {}", phone, e);
        }
        return baseResult;
    }

    private String getToken(String phone) {
        return Md5Util.md5(phone);
    }
}
