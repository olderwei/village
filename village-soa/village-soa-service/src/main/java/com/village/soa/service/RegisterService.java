package com.village.soa.service;

import com.village.soa.service.domain.param.VillagerParam;
import com.village.soa.service.domain.result.BaseResult;

/**
 * Created by chenwei on 2016/11/29.
 */
public interface RegisterService {

    /**
     * 欢乐村民注册
     * @param villagerParam
     * @return
     */
    public BaseResult registerVillager(VillagerParam villagerParam);
}
