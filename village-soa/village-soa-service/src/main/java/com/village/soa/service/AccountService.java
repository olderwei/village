package com.village.soa.service;

import com.village.soa.domain.Account;
import com.village.soa.service.domain.result.BaseResult;

/**
 * Created by chenwei on 2016/11/26.
 */
public interface AccountService {

    public BaseResult addAccount(Account account);
}
