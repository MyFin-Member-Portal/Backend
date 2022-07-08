package com.myfin.controller;


import com.alibaba.fastjson.JSON;
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



    @PostMapping("/setUserChildProfile")
    public Result<Object> createUserChild(@RequestBody UserChildInfoRequest userChildInfoRequest){
        int userChildId = userChildService.addUserChildService(userChildInfoRequest.getUserId(),
                userChildInfoRequest.getUserChildAge(),
                userChildInfoRequest.getUserChildEdu());

//        return new user child ID
        return Response.success(userChildId);
    }

    @PostMapping("/getAllUserChildProfile")
    public Result<Object> getUserChild(@RequestBody UserChildInfoRequest userChildInfoRequest){
        Object currentUserChildList =  userChildService.getUserChildService(userChildInfoRequest.getUserId());
        String jsonUserChildInfo = JSON.toJSONString(currentUserChildList);
        return Response.success(jsonUserChildInfo);
    }
    //  for future
    public Object getSpecificUserChild(int userId, int userChildId){
        return userChildService.getSpecificUserChildService(userId, userChildId);
    }


    @PutMapping("/updateUserChildProfile")
    public Result<Object> updateUserChild(@RequestBody UserChildInfoRequest userChildInfoRequest){
        try {
            int userId = userChildService.updateTotalUserChildService(userChildInfoRequest.getUserChildList());

            return Response.success(userId);
        }catch (Exception e){
            e.printStackTrace();
            return Response.fail("Update fail");
        }
    }

//    @DeleteMapping("/deleteUserChildProfile")
//    public Result<Object> deleteUserChild(@RequestBody UserChildInfoRequest userChildInfoRequest) {
//
//        return Response.success(userId);
//    }

}
