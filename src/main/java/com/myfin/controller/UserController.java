package com.myfin.controller;

import com.myfin.base.Response;
import com.myfin.base.Result;
import com.myfin.controller.reqeust.UserInfoUpdateRequest;
import com.myfin.entity.User;
import com.myfin.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/getUserBasicInfo")
    public Result<Object> getUserBasicInfo(@RequestBody UserInfoUpdateRequest userInfoUpdateRequest){
        int user_id = userInfoUpdateRequest.getUserId();
        User currentUser = userService.findUserById(user_id);
        if (currentUser == null){
            return Response.fail("no such user");
        }
        return Response.success("Name:"+currentUser.getUser_name()+"Email"+currentUser.getUser_email());
    }


    @PostMapping("/updateUserFamilyInfo")
    public Result<Object> updateUser(@RequestBody UserInfoUpdateRequest userInfoUpdateRequest){

        String currentPhoneNumber = userInfoUpdateRequest.getUserPhoneNumber();
        String currentAddress = userInfoUpdateRequest.getUserAddress();

        String currentGender = userInfoUpdateRequest.getUserGender();
        String currentNationality = userInfoUpdateRequest.getUserNationality();
        String currentHeritage = userInfoUpdateRequest.getUserHeritage();

        String currentLanguage = userInfoUpdateRequest.getUserLanguage();

        String currentName = userInfoUpdateRequest.getUserName();

        String currentEmail = userInfoUpdateRequest.getUserEmail();


        return Response.success("Update success");
    }
}








