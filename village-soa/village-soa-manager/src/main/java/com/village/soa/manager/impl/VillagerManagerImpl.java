package com.village.soa.manager.impl;

import com.sun.javafx.collections.MappingChange;
import com.village.soa.dao.VillagerMapper;
import com.village.soa.domain.Villager;
import com.village.soa.manager.VillagerManager;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenwei on 2016/11/28.
 */
@Component("villagerManager")
public class VillagerManagerImpl implements VillagerManager {

    @Resource
    private VillagerMapper villagerMapper;

    @Override
    public boolean saveVillager(Villager villager) {
        int ret = villagerMapper.saveVillager(villager);
        return 1 == ret ? true : false;
    }

    @Override
    public Villager findVillagerByPhoneOrUsernameAndPassword(String phone, String password) {
        Map<String , String> map = new HashMap<String , String>();
        map.put("phone", phone);
        map.put("password", password);
        return villagerMapper.findVillagerByPhoneOrUsernameAndPassword(map);
    }

    @Override
    public Villager findVillagerByPhone(String phone) {
        Map<String , String> map = new HashMap<String , String>();
        map.put("phone", phone);
        return villagerMapper.findVillagerByPhone(map);
    }
}
