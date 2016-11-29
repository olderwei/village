package com.village.soa.service.impl;

import com.alibaba.fastjson.JSON;
import com.village.soa.common.util.RegularVerification;
import com.village.soa.domain.Villager;
import com.village.soa.manager.VillagerManager;
import com.village.soa.service.RegisterService;
import com.village.soa.service.domain.param.VillagerParam;
import com.village.soa.service.domain.result.BaseResult;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by chenwei on 2016/11/29.
 */
@Service("registerService")
public class RegisterServiceImpl implements RegisterService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegisterServiceImpl.class);

    @Resource
    private VillagerManager villagerManager;

    @Override
    public BaseResult registerVillager(VillagerParam villagerParam) {
        BaseResult baseResult = checkParam(villagerParam);
        //参数验证不通过
        if (!baseResult.isSuccess()) {
            return baseResult;
        }
        //验证手机号是否注册
        Villager villager = villagerManager.findVillagerByPhone(villagerParam.getPhone());
        if (villager != null) {
            baseResult.setSuccess(false);
            baseResult.setResultCode(1006);
            baseResult.setErrorMsg("该手机号已注册");
            return baseResult;
        }

        boolean ret;
        try {
            ret = villagerManager.saveVillager(villagerParam.toVillager());
            if (ret) {
                baseResult.setSuccess(true);
                baseResult.setResultCode(0);
                baseResult.setErrorMsg("成功");
            }
        } catch (Exception e) {
            LOGGER.error("!Error: Register villager error, param = {}", JSON.toJSONString(villagerParam), e);
        }
        return baseResult;
    }

    /**
     * 验证参数
     * @param villagerParam
     * @return
     */
    private BaseResult checkParam(VillagerParam villagerParam) {
        BaseResult baseResult = new BaseResult();
        baseResult.setSuccess(true);
        if (StringUtils.isBlank(villagerParam.getPhone())) {
            baseResult.setSuccess(false);
            baseResult.setResultCode(1002);
            baseResult.setErrorMsg("手机号不能为空");
            return baseResult;
        }
        if (StringUtils.isNoneBlank(villagerParam.getPhone()) && !RegularVerification.isMobile(villagerParam.getPhone())) {
            baseResult.setSuccess(false);
            baseResult.setResultCode(1003);
            baseResult.setErrorMsg("请输入正确的手机号");
            return baseResult;
        }
        if (StringUtils.isBlank(villagerParam.getPassword())) {
            baseResult.setSuccess(false);
            baseResult.setResultCode(1004);
            baseResult.setErrorMsg("密码不能为空");
            return baseResult;
        }
        if (StringUtils.isNoneBlank(villagerParam.getPassword()) && !RegularVerification.isPasswordCorrect(villagerParam.getPassword())) {
            baseResult.setSuccess(false);
            baseResult.setResultCode(1005);
            baseResult.setErrorMsg("请输入正确格式的密码");
            return baseResult;
        }
        return baseResult;
    }
}
