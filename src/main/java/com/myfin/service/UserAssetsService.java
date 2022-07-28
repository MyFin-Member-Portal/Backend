package com.myfin.service;

public interface UserAssetsService {
    /**
     * get the user assets related info
     * @param userId
     * @return
     */
    String getUserAssetService(int userId);


    /**
     * create the user asset with null values;
     * @param userId
     * @return
     */
    int createUserAssetService(int userId);
}
