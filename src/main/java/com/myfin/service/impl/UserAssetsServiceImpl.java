package com.myfin.service.impl;
import com.myfin.entity.UserAsset;
import com.myfin.mapper.UserAssetsMapper;
import com.myfin.service.UserAssetsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author  Yuhzhuo Ma
 */

@Slf4j
@Service
public class UserAssetsServiceImpl implements UserAssetsService {

    @Resource
    private UserAssetsMapper userAssetsMapper;

    @Override
    public UserAsset getUserAssetService(int userId) {
        UserAsset result = userAssetsMapper.getUserAssets(userId);
        this.fillUpUserAssetObj(result, userId);
        return result;
    }

    @Override
    public void createUserAssetService(int userId) {
        userAssetsMapper.createUserAsset(userId);
    }

    @Override
    public void updateUserAssetsService(int userId, List<String> investment, String netAssets, List<String> assetName, List<String> assetValue, String cashSaving, String homeOwner, String liabilities, String liabilitiesBalOwn, String tarIncBracket, List<String> tarAssetName, List<String> tarAssetValue, String tarCashBalance, String tarFinBeh, String tarLifeStyle) {
        String investmentString = investment.toString();
        String assetNameString = assetName.toString();
        String assetValueString = assetValue.toString();

        String tarAssetNameString = tarAssetName.toString();
        String tarAssetValueString = tarAssetValue.toString();
        userAssetsMapper.updateUserAssets(
                userId,
                investmentString,
                netAssets,
                assetNameString,
                assetValueString,
                cashSaving,
                homeOwner,
                liabilities,
                liabilitiesBalOwn,
                tarIncBracket,
                tarAssetNameString,
                tarAssetValueString,
                tarCashBalance,
                tarFinBeh,
                tarLifeStyle
        );
    }



    private void fillUpUserAssetObj(UserAsset userAssetObj, int userId){

//        userAssetObj.setAssetName();

        Map<String, Object> returnValue = userAssetsMapper.getUserAssetListInfo(userId);
        userAssetObj.setInvestment(Collections.singletonList((String) returnValue.get("investment")));

        userAssetObj.setAssetName(Collections.singletonList((String) returnValue.get("assetName")));
        userAssetObj.setAssetValue(Collections.singletonList((String) returnValue.get("assetValue")));

        userAssetObj.setTarAssetName(Collections.singletonList((String) returnValue.get("tarAssetName")));

        userAssetObj.setTarAssetValue(Collections.singletonList((String) returnValue.get("tarAssetValue")));



    }


}
