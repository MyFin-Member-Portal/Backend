package com.myfin.controller.userProfileController;


import com.myfin.base.Response;
import com.myfin.base.Result;
import com.myfin.controller.reqeust.UserFamilyInfoUpdateRequest;
import com.myfin.service.UserFamilyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
/**
 * @author  Yuhzhuo Ma
 */
@Slf4j
@RestController
@RequestMapping("/myfin/user/profile/family")
public class UserFamilyController {

    @Resource
    private UserFamilyService userFamilyService;

    @PostMapping("/getInfo")
    public Result<Object> getUserFamilyInfo(@RequestBody UserFamilyInfoUpdateRequest userFamilyInfoUpdateRequest){
        Object userFamily;
        try {
            int userId = userFamilyInfoUpdateRequest.getUserId();
            userFamily = userFamilyService.getUserFamilyInfoService(userId);
            return Response.success(userFamily);
        }catch (Exception e){
            e.printStackTrace();
            return Response.fail("Get Fail");
        }
    }

    @PostMapping("/updateInfo")
    public Result<Object> updateUserFamilyInfo(@RequestBody UserFamilyInfoUpdateRequest userFamilyInfoUpdateRequest){
        try{
            userFamilyService.updateUserFamilyInfoService(
                    userFamilyInfoUpdateRequest.getUserId(),
                    userFamilyInfoUpdateRequest.getMartialStatus(),
                    userFamilyInfoUpdateRequest.getDepNum(),
                    userFamilyInfoUpdateRequest.getPetsNum(),
                    userFamilyInfoUpdateRequest.getSupNonDepNum(),
                    userFamilyInfoUpdateRequest.getExpectMedBill()
            );
            return Response.success("Update success");
        }catch (Exception e){
            e.printStackTrace();
            return Response.fail("Update Fail");
        }
    }

    @PostMapping("/createInfo")
    public Result<Object> createUserFamilyInfo(@RequestBody UserFamilyInfoUpdateRequest userFamilyInfoUpdateRequest){
        try{
            int userId = userFamilyInfoUpdateRequest.getUserId();
            userFamilyService.createUserFamilyInfoService(userId);
            return Response.success(userId);
        }catch (Exception e){
            e.printStackTrace();
            return Response.fail("create Fail");
        }
    }

    @PostMapping("/updateFamilyAndChild")
    public Result<Object> updateFamilyAndChild(@RequestBody UserFamilyInfoUpdateRequest userFamilyInfoUpdateRequest){
        try{
            int userId = userFamilyInfoUpdateRequest.getUserId();
            userFamilyService.updateUserFamilyInfoService(
                    userId,
                    userFamilyInfoUpdateRequest.getMartialStatus(),
                    userFamilyInfoUpdateRequest.getDepNum(),
                    userFamilyInfoUpdateRequest.getPetsNum(),
                    userFamilyInfoUpdateRequest.getSupNonDepNum(),
                    userFamilyInfoUpdateRequest.getExpectMedBill()
            );
            log.info("Update user family info done");
            int returnUserId = userFamilyService.updateTotalUserChildService(userId,
                    userFamilyInfoUpdateRequest.getUserChildList());
            log.info("Update user child info done");

            return Response.success(returnUserId);
        }catch (Exception e){
            e.printStackTrace();
            return Response.fail("Update Fail");
        }
    }


}
