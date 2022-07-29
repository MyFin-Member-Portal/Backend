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
        try{
            int userId = userAssetsRequest.getUserId();
            String resultJson = userAssetsService.getUserAssetService(userId);
            return Response.success(resultJson);
        }catch (Exception e){
            e.printStackTrace();
            return Response.fail("Get assets Fail");
        }
    }

    @PostMapping("/createAssets")
    public Result<Object> createUserAssetInfo(@RequestBody UserAssetsRequest userAssetsRequest){
        try {
            int resultUserId = userAssetsService.createUserAssetService(userAssetsRequest.getUserId());
            return Response.success(resultUserId);
        }catch (Exception e){
            e.printStackTrace();
            return Response.fail("create assets fail");
        }
    }

//    @PostMapping("/updateAssets")
//    public Result<Object> updateUserFamilyInfo(@RequestBody UserAssetsRequest userAssetsRequest) {
//        try {
//            userAssetsService.updateUserAssetsService(
//                    userAssetsRequest.getUserId(),
//                    userAssetsRequest.getTarFinBeh(),
//                    userAssetsRequest.getInvestment(),
//                    userAssetsRequest.getNetAssets(),
//                    userAssetsRequest.getAssetList(),
////                    userAssetsRequest.getTarAssets(),
//                    userAssetsRequest.getCashSaving(),
//                    userAssetsRequest.getTarCashBalance(),
//                    userAssetsRequest.getTarIncBracket(),
//                    userAssetsRequest.getHomeOwner(),
//                    userAssetsRequest.getLiabilities(),
//                    userAssetsRequest.getLiabilitiesBalOwn(),
//                    userAssetsRequest.getTarLifeStyle()
//            );
//            return Response.success("update success");
//        }catch (Exception e){
//            e.printStackTrace();
//            return Response.fail("update assets fail");
//        }
//    }

}
