package com.myfin.controller;

import com.myfin.base.Response;
import com.myfin.base.Result;
import com.myfin.controller.reqeust.UserChildInfoRequest;
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
@RequestMapping("/myfin")
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

        String currentPhoneNumber = userInfoUpdateRequest.getUserPhoneNumber();
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

    @PostMapping("/setUserChildProfile")
    public Result<Object> createUserChild(@RequestBody UserChildInfoRequest userChildInfoRequest){
        int userChildId = userService.addUserChildService(userChildInfoRequest.getUserId(),
                userChildInfoRequest.getUserChildAge(),
                userChildInfoRequest.getUserChildEdu());

//        return new user child ID
        return Response.success(userChildId);
    }

    @PostMapping("/getAllUserChildProfile")
    public Result<Object> getUserChild(@RequestBody UserChildInfoRequest userChildInfoRequest){
        int user_id = userChildInfoRequest.getUserId();
        Object currentUser = userService.findUserById(user_id);
        if (currentUser == null){
            return Response.fail("no such user");
        }
        Object currentUserChildList =  userService.getUserChildService(userChildInfoRequest.getUserId());
        String jsonUserChildInfo = JSON.toJSONString(currentUserChildList);
        return Response.success(jsonUserChildInfo);
    }
//  for future
    public Object getSpecificUserChild(int userId, int userChildId){
        return userService.getSpecificUserChildService(userId, userChildId);
    }


    @PutMapping("/updateUserChildProfile")
    public Result<Object> updateUserChild(@RequestBody UserChildInfoRequest userChildInfoRequest){
        try {
            int userId = userService.updateTotalUserChildService(userChildInfoRequest.getUserChildList());
            return Response.success(userId);
        }catch (Exception e){
            return Response.fail("Update fail");
        }
    }

//    @DeleteMapping("/deleteUserChildProfile")
//    public Result<Object> deleteUserChild(@RequestBody UserChildInfoRequest userChildInfoRequest) {
//
//        return Response.success(userId);
//    }

}








