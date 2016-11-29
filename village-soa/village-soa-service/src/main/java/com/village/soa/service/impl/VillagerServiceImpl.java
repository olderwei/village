package com.village.soa.service.impl;

import com.alibaba.fastjson.JSON;
import com.village.soa.domain.Villager;
import com.village.soa.manager.VillagerManager;
import com.village.soa.service.VillagerService;
import com.village.soa.service.domain.param.VillagerParam;
import com.village.soa.service.domain.result.BaseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by chenwei on 2016/11/28.
 */

@Service("villagerService")
public class VillagerServiceImpl implements VillagerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(VillagerServiceImpl.class);

    @Resource
    private VillagerManager villagerManager;

    @Override
    public BaseResult saveVillager(VillagerParam villagerParam) {
        BaseResult baseResult = new BaseResult();

        return baseResult;
    }

    @Override
    public BaseResult findVillagerByPhoneOrUsernameAndPassword(VillagerParam villagerParam) {
        BaseResult baseResult = new BaseResult();

        return baseResult;
    }
}
