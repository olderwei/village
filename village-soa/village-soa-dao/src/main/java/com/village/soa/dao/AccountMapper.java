package com.village.soa.dao;

import com.village.soa.domain.Account;
import org.springframework.stereotype.Repository;

/**
 * Created by chenwei on 2016/11/26.
 */
@Repository
public interface AccountMapper {

    public long saveAccount(Account account);
}
