package com.village.soa.manager;

import com.village.soa.domain.Villager;

/**
 * Created by chenwei on 2016/11/28.
 */
public interface VillagerManager {

    /**
     * 增加欢乐村民
     * @param villager
     * @return
     */
    public boolean saveVillager(Villager villager);

    /**
     * 根据手机号及密码查询欢乐村民
     * @param phone
     * @return
     */
    public Villager findVillagerByPhoneOrUsernameAndPassword(String phone, String password);

    /**
     * 根据手机号查询欢乐村民
     * @param phone
     * @return
     */
    public Villager findVillagerByPhone(String phone);

}
