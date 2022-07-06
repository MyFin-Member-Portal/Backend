package com.myfin.service.impl;

import com.myfin.entity.UserBusiness;
import com.myfin.mapper.UserBusinessMapper;
import com.myfin.service.UserBusinessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Zihang Gao
 */
@Slf4j
@Service
public class UserBusinessServiceImpl implements UserBusinessService {
    
    @Resource
    private UserBusinessMapper userBusinessMapper;
    
    @Override
    public List<UserBusiness> findAllBusinessByUserId(int userId) {
        return userBusinessMapper.findAllBusiness(userId);
    }

    @Override
    public void addBusiness(int userId, String businessName, String businessProfitLoss, String businessBalanceSheet) {
        userBusinessMapper.addBusiness(userId, businessName, businessProfitLoss, businessBalanceSheet);
    }

    @Override
    public void updateBusiness(int userId, int businessId, String businessName, String businessProfitLoss, String businessBalanceSheet) {
        userBusinessMapper.updateBusiness(userId, businessId, businessName, businessProfitLoss, businessBalanceSheet);
    }

    @Override
    public void deleteBusiness(int userId, int businessId) {
        userBusinessMapper.deleteBusiness(userId, businessId);
    }

    @Override
    public void updateAllBusiness(int userId, List<Map<String, Object>> businessList) {
        for(Map<String, Object> business: businessList){
            this.updateBusiness(userId,
                    (int) business.get("businessId"),
                    (String) business.get("businessName"),
                    (String) business.get("businessProfitLoss"),
                    (String) business.get("businessBalanceSheet"));
        }
    }
}

