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

    @GetMapping("/getUserBasicProfile")
    public Result<Object> getUserBasicInfo(@RequestBody UserInfoUpdateRequest userInfoUpdateRequest){
        int user_id = userInfoUpdateRequest.getUserId();
        User currentUser = userService.findUserById(user_id);
        if (currentUser == null){
            return Response.fail("no such user");
        }
        return Response.success("Name: "+currentUser.getUser_name()+
                        " Email: "+currentUser.getUser_email()+
                        " PhoneNumber: "+currentUser.getUser_phone()+
                        " Address: "+currentUser.getUser_address()+
                        " Gender: "+currentUser.getUser_gender()+
                        " Nationality: "+currentUser.getUser_nationality()+
                        " Heritage: "+currentUser.getUser_heritage()+
                        " Language: "+currentUser.getUser_language());
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
}








