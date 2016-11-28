package com.village.soa.manager.impl;

import com.village.soa.dao.AccountMapper;
import com.village.soa.domain.Account;
import com.village.soa.manager.AccountManager;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;

/**
 * Created by chenwei on 2016/11/26.
 */
@Component("accountManager")
public class AccountManagerImpl implements AccountManager {

    @Resource
    private AccountMapper accountMapper;

    @Resource
    private TransactionTemplate transactionTemplate;

    @Override
    public boolean addAccount(Account account) {
        accountMapper.saveAccount(account);
        return true;
    }
}
