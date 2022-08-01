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
    public void updateUserAssetsService(int userId, List<String> investment, String netAssets, List<Map<String, String>> assetList, String cashSaving, String homeOwner, String liabilities, String liabilitiesBalOwn, String tarIncBracket, List<Map<String, String>> tarAssetList, String tarCashBalance, String tarFinBeh, String tarLifeStyle) {
        String investmentString = investment.toString();
        String assetListString = assetList.toString();
        String tarAssetListString = tarAssetList.toString();
        userAssetsMapper.updateUserAssets(
                userId,
                investmentString,
                netAssets,
                assetListString,
                cashSaving,
                homeOwner,
                liabilities,
                liabilitiesBalOwn,
                tarIncBracket,
                tarAssetListString,
                tarCashBalance,
                tarFinBeh,
                tarLifeStyle
        );

    }

    private void fillUpUserAssetObj(UserAsset userAssetObj, int userId){

        userAssetObj.setInvestment(Collections.singletonList(userAssetsMapper.getUserAssetsInvestment(userId)));



        String AssetListString = (String) userAssetsMapper.getUserAssetsAssetList(userId).get(0).get("assetList");
        String TarAssetListString = (String) userAssetsMapper.getUserAssetsTarAssetList(userId).get(0).get("tarAssetList");


        userAssetObj.setAssetList(Collections.singletonList(AssetListString));
        userAssetObj.setTarAssetList(Collections.singletonList(TarAssetListString));

//        String JsonAssetListString = userAssetsMapper.getUserAssetsAssetList(userId).get(0).get("assetList").replaceAll("=",":");
//
//        log.info("************"+JsonAssetListString);
////        JsonAssetListString = JsonAssetListString.replace("{","[");
////        JsonAssetListString = JsonAssetListString.replace("}","]");
//
//
//        userAssetObj.setAssetList(userAssetsMapper.getUserAssetsAssetList(userId));


//        for (String s : JsonAssetList) {
//            log.info("************"+s);
////            Asset result = JSON.parseObject(s, Asset.class);
////            log.info("************"+result);
//        }

    }


}
