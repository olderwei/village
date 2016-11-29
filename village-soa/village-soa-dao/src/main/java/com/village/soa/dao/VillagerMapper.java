package com.village.soa.dao;

import com.village.soa.domain.Villager;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by chenwei on 2016/11/28.
 */
@Repository
public interface VillagerMapper {

    /**
     * 增加欢乐村民
     * @param villager
     * @return
     */
    public int saveVillager(Villager villager);

    /**
     * 根据手机号及密码查询欢乐村民
     * @param map
     * @return
     */
    public Villager findVillagerByPhoneOrUsernameAndPassword(Map<String, String> map);

    /**
     * 根据手机号查询欢乐村民
     * @param map
     * @return
     */
    public Villager findVillagerByPhone(Map<String, String> map);
}
