package com.myfin.controller;

import com.myfin.base.Response;
import com.myfin.base.Result;
import com.myfin.controller.reqeust.UserFinancialRequest;
import com.myfin.service.UserFinancialService;
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
@RequestMapping("/myfin/user/profile/finicial")
public class UserFinancialInfoController {
    @Resource
    private UserFinancialService userFinancialService;

    @PostMapping("/getInfo")
    public Result<Object> getUserFinicialInfo(@RequestBody UserFinancialRequest userFinancialRequest){
        try{
            int userId = userFinancialRequest.getUserId();
            String resultJson = userFinancialService.getUserFinicialInfoService(userId);
            return Response.success(resultJson);
        }catch (Exception e){
            e.printStackTrace();
            return Response.fail("Get Fail");
        }
    }

}
