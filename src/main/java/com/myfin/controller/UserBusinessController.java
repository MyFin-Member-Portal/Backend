package com.myfin.controller;

import com.myfin.base.Response;
import com.myfin.base.Result;
import com.myfin.controller.reqeust.UserBusinessRequest;
import com.myfin.service.UserBusinessService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @author Zihang Gao
 */
@RestController
@RequestMapping("/myfin/user/profile/business")
public class UserBusinessController {
    @Resource
    UserBusinessService userBusinessService;
    
    @PostMapping("/add")
    public Result<Object> addBusiness(@RequestBody UserBusinessRequest request){
        try {
            userBusinessService.addBusiness(request.getUserId(),
                    request.getBusinessName(),
                    request.getBusinessProfitLoss(),
                    request.getBusinessBalanceSheet());  
        } catch (Exception e){
            e.printStackTrace();
            return Response.fail(e.getMessage());
        }
        return Response.success(null);
    }
    
}
