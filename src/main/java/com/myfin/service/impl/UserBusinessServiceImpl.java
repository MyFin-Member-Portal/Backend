package com.myfin.service.impl;

import com.myfin.entity.UserBusiness;
import com.myfin.mapper.UserBusinessMapper;
import com.myfin.service.UserBusinessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
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
    public int addBusiness(int userId, String businessName, String businessProfitLoss, String businessBalanceSheet) {
        userBusinessMapper.addBusiness(userId, businessName, businessProfitLoss, businessBalanceSheet);
        return userBusinessMapper.findMaxId();
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

    @Override
    public void uploadFile(MultipartFile file, int userId, int businessId) {
        Blob blob = null;
        try {
            blob = new SerialBlob(file.getBytes());
            userBusinessMapper.addFile(blob, userId, businessId);
        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }
}

