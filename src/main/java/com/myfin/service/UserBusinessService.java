package com.myfin.service;

import com.myfin.entity.UserBusiness;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Zihang Gao
 */
public interface UserBusinessService {

    /**
     * find all business from that user
     * 
     * @param userId the user id
     * @return the business information
     */
    List<UserBusiness> findAllBusinessByUserId(int userId);

    /**
     * add a business for a user
     * @param userId the user id
     */
    int addBusiness(int userId, String businessName, String businessProfitLoss, String businessBalanceSheet);

    /**
     * update the business for a user
     * 
     * @param userId the user id
     * @param businessId the business id
     * @param businessName  the business name
     * @param businessProfitLoss    the business profit and loss
     * @param businessBalanceSheet the business balance sheet
     */
    void updateBusiness(int userId, int businessId, String businessName, String businessProfitLoss, String businessBalanceSheet);

    /**
     * delete a business for a user
     * 
     * @param userId the user id
     * @param businessId the 
     */
    void deleteBusiness(int userId, int businessId);

    /**
     * delete a business for a user
     *
     * @param userId the user id 
     * @param businessList the list of businesses
     */
    void updateAllBusiness(int userId, List<Map<String, Object>> businessList);

    /**
     * upload the file 
     * @param String file need to be uploaded
     */
    void uploadFile(String filePath, int userId, int businessId);

    /**
     * download the business balance file
     * 
     * @param userId the user id
     * @param businessId the business id 
     * @return the balance sheet file
     */
    String downloadFile(int userId, int businessId) throws SQLException;
}
