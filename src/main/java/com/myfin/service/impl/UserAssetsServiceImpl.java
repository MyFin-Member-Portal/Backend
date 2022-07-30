package com.myfin.service.impl;

import com.myfin.entity.UserAsset;
import com.myfin.mapper.UserAssetsMapper;
import com.myfin.service.UserAssetsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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
        String result = userAssetsMapper.getUserAssets(userId);
        log.info(result+"******************");

        return null;
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

//    private String merge


}
