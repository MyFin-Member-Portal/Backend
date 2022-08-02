package com.myfin.mapper;


import com.myfin.entity.UserBusiness;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.sql.Blob;
import java.util.HashMap;
import java.util.List;

/**
 * @author Zihang Gao
 */
@Mapper
@Repository
public interface UserBusinessMapper {

    /**
     * find all business for a user
     * 
     * @param userId the user id
     * @return the result of business information
     */
    List<UserBusiness> findAllBusiness(int userId);

    /**
     * add a business for user
     * 
     * @param userId    the user id
     * @param businessName   the name of business
     * @param businessProfitLoss    the profit and loss information of bussiness
     * @param businessBalanceSheet  the balance sheet of the business
     */
    void addBusiness(int userId, String businessName, String businessProfitLoss, String businessBalanceSheet);

    /**
     * delete a business for a user
     * 
     * @param userId the user id 
     * @param businessId the business id 
     */
    void deleteBusiness(int userId, int businessId);

    
    /**
     * delete a business for a user
     *
     * @param userId the user id 
     * @param businessId the business id 
     * @param businessName   the name of business
     * @param businessProfitLoss    the profit and loss information of bussiness
     * @param businessBalanceSheet  the balance sheet of the business             
     */
    void updateBusiness(int userId, int businessId, String businessName, String businessProfitLoss, String businessBalanceSheet);


    /**
     * delete a business for a user
     *
     * @param userId the user id 
     * @param businessList the list of businesses
     */
    void updateAllBusiness(int userId, List<HashMap<String, Object>> businessList);

    /**
     * upload the file
     * @param file the file need to be uploaded
     */
    void addFile(Blob file, int userId, int businessId);
}
