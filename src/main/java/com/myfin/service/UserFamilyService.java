package com.myfin.service;


public interface UserFamilyService {

    /**
     * get the user family info by user id
     * @param userId the user id
     * @return an entity of userFamily entity
     */
    String getUserFamilyInfoService(int userId);


    /**
     * update the user family information
     * @param userId
     * @param maritalStatus
     * @param depNum
     * @param petsNum
     * @param supNonDepNum
     * @param exceptMedBill
     */
    void updateUserFamilyInfoService(int userId, String maritalStatus, String depNum, String petsNum, String supNonDepNum, String exceptMedBill);


    /**
     * create a user famoily information
     * @param userId
     * @return
     */
    int createUserFamilyInfoService(int userId);
}
