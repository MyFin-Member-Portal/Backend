package com.myfin.service;

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
    Object findAllBusinessByUserId(int userId);

    /**
     * add a business for a user
     * @param userId the user id
     */
    void addBusiness(int userId, String businessName, String businessProfitLoss, String businessBalanceSheet);
    
}
