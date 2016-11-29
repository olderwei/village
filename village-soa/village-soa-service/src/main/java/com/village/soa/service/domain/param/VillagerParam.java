package com.village.soa.service.domain.param;

import com.village.soa.common.util.Md5Util;
import com.village.soa.domain.Villager;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by chenwei on 2016/11/28.
 */
public class VillagerParam {

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

    public Villager toVillager() {
        Villager villager = new Villager();
        villager.setUsername(this.username);
        villager.setPhone(this.phone);
        villager.setPassword(Md5Util.md5(this.password));
        villager.setNickName(this.nickName);
        villager.setHeadImage(this.headImage);
        return villager;
    }
}
