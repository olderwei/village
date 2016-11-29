package com.village.soa.service;

import com.village.soa.service.domain.param.VillagerParam;
import com.village.soa.service.domain.result.BaseResult;

/**
 * Created by chenwei on 2016/11/28.
 */
public interface VillagerService {

    /**
     * 增加欢乐村民
     * @param villagerParam
     * @return
     */
    public BaseResult saveVillager(VillagerParam villagerParam);

    /**
     * 根据手机号查询欢乐村民
     * @param villagerParam
     * @return
     */
    public BaseResult findVillagerByPhoneOrUsernameAndPassword(VillagerParam villagerParam);

}
