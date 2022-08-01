package com.myfin.service;

import com.myfin.entity.UserAsset;

import java.util.List;
import java.util.Map;


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


    void updateUserAssetsService(int userId, List<String> investment, String netAssets, List<Map<String, String>> assetList, String cashSaving, String homeOwner, String liabilities, String liabilitiesBalOwn, String tarIncBracket, List<Map<String, String>> tarAssetList, String tarCashBalance, String tarFinBeh, String tarLifeStyle);
}
