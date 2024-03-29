package com.myfin.controller.userProfileController;


import com.myfin.base.Response;
import com.myfin.base.Result;
import com.myfin.controller.reqeust.UserAssetsRequest;
import com.myfin.service.UserAssetsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.lang.reflect.Executable;

/**
 * @author  Yuhzhuo Ma
 */

@Slf4j
@RestController
@RequestMapping("/myfin/user/profile/assets")
public class UserAssetsController {
    @Resource
    private UserAssetsService userAssetsService;

    @PostMapping("/getAssets")
    public Result<Object> getUserAssetInfo(@RequestBody UserAssetsRequest userAssetsRequest){
        Object UserAsset;
        try{
            int userId = userAssetsRequest.getUserId();
            UserAsset = userAssetsService.getUserAssetService(userId);
            return Response.success(UserAsset);
        }catch (Exception e){
            e.printStackTrace();
            return Response.fail("Get user assets Fail");
        }

    }

    @PostMapping("/createAssets")
    public Result<Object> createUserAssetInfo(@RequestBody UserAssetsRequest userAssetsRequest){
        try {
            userAssetsService.createUserAssetService(userAssetsRequest.getUserId());
            return Response.success("create success");
        }catch (Exception e){
            e.printStackTrace();
            return Response.fail("create assets fail");
        }
    }

    @PostMapping("/updateAssets")
    public Result<Object> updateUserFamilyInfo(@RequestBody UserAssetsRequest userAssetsRequest) {
        try {
            userAssetsService.updateUserAssetsService(
                    userAssetsRequest.getUserId(),
                    userAssetsRequest.getInvestment(),
                    userAssetsRequest.getNetAssets(),
                    userAssetsRequest.getAssetName(),
                    userAssetsRequest.getAssetValue(),
                    userAssetsRequest.getCashSaving(),
                    userAssetsRequest.getHomeOwner(),
                    userAssetsRequest.getLiabilities(),
                    userAssetsRequest.getLiabilitiesBalOwn(),
                    userAssetsRequest.getTarIncBracket(),
                    userAssetsRequest.getTarAssetName(),
                    userAssetsRequest.getTarAssetValue(),
                    userAssetsRequest.getTarCashBalance(),
                    userAssetsRequest.getTarFinBeh(),
                    userAssetsRequest.getTarLifeStyle()
            );
            return Response.success("update success");
        }catch (Exception e){
            e.printStackTrace();
            return Response.fail("update assets fail");
        }
    }

}
