package com.myfin.controller;


import com.myfin.base.Response;
import com.myfin.base.Result;
import com.myfin.controller.reqeust.UserChildInfoRequest;
import com.myfin.service.UserChildService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Yuzhuo Ma
 */

@Slf4j
@RestController
@RequestMapping("/myfin/user/profile/child")
public class UserChildController {

    @Resource
    private UserChildService userChildService;



    @PostMapping("/setProfile")
    public Result<Object> createUserChild(@RequestBody UserChildInfoRequest userChildInfoRequest){
        int userChildId = userChildService.addUserChildService(userChildInfoRequest.getUserId(),
                userChildInfoRequest.getUserChildAge(),
                userChildInfoRequest.getUserChildEdu());

//        return new user child ID
        return Response.success(userChildId);
    }

    @PostMapping("/getProfile")
    public Result<Object> getUserChild(@RequestBody UserChildInfoRequest userChildInfoRequest){
        String jsonUserChildInfo =  userChildService.getUserChildService(userChildInfoRequest.getUserId());
        return Response.success(jsonUserChildInfo);
    }

    //  for future
    public Object getSpecificUserChild(int userId, int userChildId){
        return userChildService.getSpecificUserChildService(userId, userChildId);
    }


    @PutMapping("/updateProfile")
    public Result<Object> updateUserChild(@RequestBody UserChildInfoRequest userChildInfoRequest){
        try {
            int userId = userChildService.updateTotalUserChildService(userChildInfoRequest.getUserChildList());

            return Response.success(userId);
        }catch (Exception e){
            e.printStackTrace();
            return Response.fail("Update fail");
        }
    }

    @PostMapping("/deleteProfile")
    public Result<Object> deleteUserChild(@RequestBody UserChildInfoRequest userChildInfoRequest) {
        try {
            int inputChildId = userChildInfoRequest.getUserChildId();
            int childId = userChildService.deleteSpecificUserChildService(userChildInfoRequest.getUserId(), inputChildId);
            return Response.success(childId);
        }catch (Exception e){
            e.printStackTrace();
            return Response.fail("Delete fail");
        }
    }
}