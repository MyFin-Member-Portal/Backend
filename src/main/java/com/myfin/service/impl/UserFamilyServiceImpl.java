package com.myfin.service.impl;

import com.alibaba.fastjson.JSON;
import com.myfin.mapper.UserFamilyMapper;
import com.myfin.service.UserFamilyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
/**
 * @author  Yuhzhuo Ma
 */

@Slf4j
@Service
public class UserFamilyServiceImpl implements UserFamilyService {
    @Resource
    private UserFamilyMapper userFamilyMapper;

    @Override
    public String getUserFamilyInfoService(int userId) {
        log.info("***********************"+userFamilyMapper.getUserFamilyInfo(userId));
        return JSON.toJSONString(userFamilyMapper.getUserFamilyInfo(userId));
    }

    @Override
    public void updateUserFamilyInfoService(int userId, String maritalStatus, String depNum, String petsNum, String supNonDepNum, String exceptMedBill) {
        userFamilyMapper.updateUserFamilyInfo(userId,
                                maritalStatus, depNum, petsNum, supNonDepNum, exceptMedBill);
    }

    @Override
    public int createUserFamilyInfoService(int userId) {

        return userFamilyMapper.createUserFamilyInfo(userId);
    }
}
