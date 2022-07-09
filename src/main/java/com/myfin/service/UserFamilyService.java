package com.myfin.service;

import com.myfin.entity.UserFamily;

public interface UserFamilyService {

    /**
     * get the user family info by user id
     * @param userId the user id
     * @return an entity of userFamily entity
     */
    String getUserFamilyInfoService(int userId);

    void updateUserFamilyInfoService(int userId, String maritalStatus, String depNum, String petsNum, String supNonDepNum, String exceptMedBill);

    int createUserFamilyInfoService(int userId);
}
