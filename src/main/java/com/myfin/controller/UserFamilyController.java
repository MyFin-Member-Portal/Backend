package com.myfin.controller;


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
        try {
            int userId = userFamilyInfoUpdateRequest.getUserId();
            String resultJson= userFamilyService.getUserFamilyInfoService(userId);
            return Response.success(resultJson);
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
                    userFamilyInfoUpdateRequest.getMaritalStatus(),
                    userFamilyInfoUpdateRequest.getDepNum(),
                    userFamilyInfoUpdateRequest.getPetsNum(),
                    userFamilyInfoUpdateRequest.getSupNonDepNum(),
                    userFamilyInfoUpdateRequest.getExceptMedBill()
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
            int resultUserId = userFamilyService.createUserFamilyInfoService(userFamilyInfoUpdateRequest.getUserId());
            return Response.success(resultUserId);
        }catch (Exception e){
            e.printStackTrace();
            return Response.fail("create Fail");
        }
    }


}
