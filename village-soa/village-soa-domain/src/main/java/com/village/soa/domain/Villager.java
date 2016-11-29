package com.village.soa.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by chenwei on 2016/11/28.
 */
public class Villager {

    //自增ID
    @Setter @Getter private long id;

    //用户名
    @Setter @Getter private String username;

    //手机号
    @Setter @Getter private String phone;

    //密码
    @Setter @Getter private String password;

    //昵称
    @Setter @Getter private String nickName;

    //头像
    @Setter @Getter private String headImage;

    //性别 1:男 2:女
    @Setter @Getter private int sex;

    //是否欢乐村民 1:是 2:不是
    @Setter @Getter private String villagePeople;

    //是否欢乐村长 1:是 2:不是
    @Setter @Getter private String villageHead;

    //是否欢乐商户 1:是 2:不是
    @Setter @Getter private String villageMerchant;

    //创建时间
    @Setter @Getter private Date create_time;

    //更新时间
    @Setter @Getter private Date update_time;

    //可用性
    @Setter @Getter private int status;

}
