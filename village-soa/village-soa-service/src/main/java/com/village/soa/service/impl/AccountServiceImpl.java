package com.village.soa.service.impl;

import com.village.soa.domain.Account;
import com.village.soa.manager.AccountManager;
import com.village.soa.service.AccountService;
import com.village.soa.service.domain.result.BaseResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by chenwei on 2016/11/26.
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountManager accountManager;

    @Override
    public BaseResult addAccount(Account account) {
        BaseResult baseResult = new BaseResult();
        accountManager.addAccount(account);

        return baseResult;
    }
}
