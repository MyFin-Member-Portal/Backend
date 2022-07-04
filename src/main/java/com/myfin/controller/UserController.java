package com.myfin.controller;

import com.myfin.base.Response;
import com.myfin.base.Result;
import com.myfin.controller.reqeust.UserChildInfoRequest;
import com.myfin.controller.reqeust.UserInfoUpdateRequest;
import com.myfin.entity.User;
import com.myfin.entity.UserChild;
import com.myfin.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSON;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Zihang Gao, Yuzhuo Ma
 */
@Slf4j
@RestController
@RequestMapping("/myfin")

public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("/getUserBasicProfile")
    public Result<Object> getUserBasicInfo(@RequestBody UserInfoUpdateRequest userInfoUpdateRequest){
        int user_id = userInfoUpdateRequest.getUserId();
        User currentUser = userService.findUserById(user_id);
        if (currentUser == null){
            return Response.fail("no such user");
        }
        String userJsonResult = JSON.toJSONString(currentUser);
        return Response.success(userJsonResult);
    }


    @PutMapping("/updateUserBasicProfile")
    public Result<Object> updateUser(@RequestBody UserInfoUpdateRequest userInfoUpdateRequest){

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
        //here get current max user child ID first, then increment
        int userMaxChildID = -1;
        userMaxChildID = userService.getCurrentChildId(userChildInfoRequest.getUserId());
        log.info("----------"+userMaxChildID);
        int userChildId = userService.addUserChildService(userChildInfoRequest.getUserId(),
                userMaxChildID,
                userChildInfoRequest.getUserChildAge(),
                userChildInfoRequest.getUserChildEdu());

//        return new user child ID
        return Response.success(userChildId);
    }

    @GetMapping("/getUserChildProfile")
    public Result<Object> getUserChild(@RequestBody UserChildInfoRequest UserChildInfoRequest){
        int user_id = UserChildInfoRequest.getUserId();
        User currentUser = userService.findUserById(user_id);
        if (currentUser == null){
            return Response.fail("no such user");
        }
        List<UserChild> currentUserChildList =  userService.getUserChildService(UserChildInfoRequest.getUserId());
        String jsonUserChildInfo = JSON.toJSONString(currentUserChildList);
        return Response.success(jsonUserChildInfo);
    }
}








