package com.myfin.service.impl;

import com.alibaba.fastjson.JSON;
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
    public String getUserAssetService(int userId) {
        return JSON.toJSONString(userAssetsMapper.getUserAssets(userId));
    }

    @Override
    public int createUserAssetService(int userId) {
        return userAssetsMapper.createUserAsset(userId);
    }

    @Override
    public void updateUserAssetsService(int userId, String tarFinBeh, List<String> investment, String netAssets, List<Map<String, String>> assetList, List<Map<String, String>> tarAssets, String cashSaving, String tarCashBalance, String tarIncBracket, String homeOwner, String liabilities, String liabilitiesBalOwn, String tarLifeStyle) {
        userAssetsMapper.updateUserAssets(
                userId,
                tarFinBeh,
                investment.toString(),
                netAssets,
                assetList.toString(),
                tarAssets.toString(),
                cashSaving,
                tarCashBalance,
                tarIncBracket,
                homeOwner,
                liabilities,
                liabilitiesBalOwn,
                tarLifeStyle
        );
    }


}
