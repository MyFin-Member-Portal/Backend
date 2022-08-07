package com.myfin.service.impl;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myfin.entity.UserChild;
import com.myfin.entity.UserFamily;
import com.myfin.mapper.UserFamilyMapper;
import com.myfin.service.UserFamilyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author  Yuhzhuo Ma
 */

@Slf4j
@Service
public class UserFamilyServiceImpl implements UserFamilyService {
    @Resource
    private UserFamilyMapper userFamilyMapper;

    @Override
    public UserFamily getUserFamilyInfoService(int userId) {
        return userFamilyMapper.getUserFamilyInfo(userId);
    }

    @Override
    public void updateUserFamilyInfoService(int userId, String maritalStatus, String depNum, String petsNum, String supNonDepNum, String exceptMedBill) {
        userFamilyMapper.updateUserFamilyInfo(userId,
                                maritalStatus, depNum, petsNum, supNonDepNum, exceptMedBill);
    }

    @Override
    public void createUserFamilyInfoService(int userId) {

        userFamilyMapper.createUserFamilyInfo(userId);
    }

    @Override
    public int updateTotalUserChildService(int userId, Object childList) {
        ObjectMapper mapper = new ObjectMapper();

        List<UserChild> childListObj = mapper.convertValue(childList,new TypeReference<List<UserChild>>(){ });

//      get one user's multiple child

        for (UserChild userChild : childListObj) {
            this.updateUserChild(userId, userChild);
        }
        return userId;
    }

    public void updateUserChild(int userId, UserChild child){
        userFamilyMapper.updateUserChildProfile(userId, child.getUserChildId(),
                child.getUserChildAge(), child.getUserChildEdu());
    }
}
