package com.myfin.controller;

import com.myfin.base.Response;
import com.myfin.base.Result;
import com.myfin.controller.reqeust.UserInfoUpdateRequest;
import com.myfin.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSON;

import javax.annotation.Resource;


/**
 * @author Zihang Gao, Yuzhuo Ma
 */
@Slf4j
@RestController
@RequestMapping("/myfin/user/profile")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/getUserBasicProfile")
    public Result<Object> getUserBasicInfo(@RequestBody UserInfoUpdateRequest userInfoUpdateRequest){
        int user_id = userInfoUpdateRequest.getUserId();
        Object currentUser = userService.findUserById(user_id);
        if (currentUser == null){
            return Response.fail("no such user");
        }
        String userJsonResult = JSON.toJSONString(currentUser);
        return Response.success(userJsonResult);
    }


    @PutMapping("/updateUserBasicProfile")
    public Result<Object> updateUserBasicInfo(@RequestBody UserInfoUpdateRequest userInfoUpdateRequest){

        String currentPhoneNumber = userInfoUpdateRequest.getUserPhone();
        String currentAddress = userInfoUpdateRequest.getUserAddress();
        String currentGender = userInfoUpdateRequest.getUserGender();
        String currentNationality = userInfoUpdateRequest.getUserNationality();
        String currentHeritage = userInfoUpdateRequest.getUserHeritage();
        String currentLanguage = userInfoUpdateRequest.getUserLanguage();
        String currentName = userInfoUpdateRequest.getUserName();
        String currentEmail = userInfoUpdateRequest.getUserEmail();
        int currentUserId = userInfoUpdateRequest.getUserId();

        int resultUserId = userService.updateUserProfile(currentPhoneNumber,
                currentAddress,
                currentGender,
                currentNationality,
                currentHeritage,
                currentLanguage,
                currentName,
                currentEmail,
                currentUserId);


        return Response.success(resultUserId);
    }

}








