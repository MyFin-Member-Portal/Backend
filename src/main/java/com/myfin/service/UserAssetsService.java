package com.myfin.service;

import com.myfin.entity.UserAsset;

import java.util.List;


public interface UserAssetsService {
    /**
     * get the user assets related info
     * @param userId
     * @return
     */
    UserAsset getUserAssetService(int userId);


    /**
     * create the user asset with null values;
     * @param userId
     * @return
     */
    void createUserAssetService(int userId);



    void updateUserAssetsService(int userId, List<String> investment, String netAssets, List<String> assetName, List<String> assetValue, String cashSaving, String homeOwner, String liabilities, String liabilitiesBalOwn, String tarIncBracket, List<String> tarAssetName, List<String> tarAssetValue, String tarCashBalance, String tarFinBeh, String tarLifeStyle);
}
