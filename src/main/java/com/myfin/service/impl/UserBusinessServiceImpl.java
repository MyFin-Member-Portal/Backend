package com.myfin.service.impl;

import com.myfin.mapper.UserBusinessMapper;
import com.myfin.service.UserBusinessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Zihang Gao
 */
@Slf4j
@Service
public class UserBusinessServiceImpl implements UserBusinessService {
    
    @Resource
    private UserBusinessMapper userBusinessMapper;
    
    @Override
    public Object findAllBusinessByUserId(int userId) {
        return userBusinessMapper.findAllBusiness(userId);
    }

    @Override
    public void addBusiness(int userId, String businessName, String businessProfitLoss, String businessBalanceSheet) {
        userBusinessMapper.addBusiness(userId, businessName, businessProfitLoss, businessBalanceSheet);
    }
}
