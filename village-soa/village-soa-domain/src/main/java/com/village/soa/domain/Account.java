package com.village.soa.domain;


import lombok.Getter;
import lombok.Setter;

/**
 * Created by chenwei on 2016/11/26.
 */
public class Account {

    @Setter @Getter private long accountId;

    @Setter @Getter private String phone;

    @Setter @Getter private String accountNickName;
}
