package com.myfin.service.impl;

import com.alibaba.fastjson.JSON;
import com.myfin.mapper.UserAssetsMapper;
import com.myfin.service.UserAssetsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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


}
