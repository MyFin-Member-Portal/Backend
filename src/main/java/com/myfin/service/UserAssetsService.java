package com.myfin.service;

import java.util.List;
import java.util.Map;

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


    void updateUserAssetsService(int userId, String tarFinBeh, List<String> investment, String netAssets, List<Map<String, String>> assetList, List<Map<String, String>> tarAssets, String cashSaving, String tarCashBalance, String tarIncBracket, String homeOwner, String liabilities, String liabilitiesBalOwn, String tarLifeStyle);
}
