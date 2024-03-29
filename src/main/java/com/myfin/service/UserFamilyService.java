package com.myfin.service;


import com.myfin.entity.UserFamily;

public interface UserFamilyService {

    /**
     * get the user family info by user id
     * @param userId the user id
     * @return string of info in json format
     */
    UserFamily getUserFamilyInfoService(int userId);


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
    void createUserFamilyInfoService(int userId);

    int updateTotalUserChildService(int userId, Object childList);
}
