package com.myfin.controller;

import com.myfin.base.Response;
import com.myfin.base.Result;
import com.myfin.controller.reqeust.UserBusinessRequest;
import com.myfin.controller.response.UserBusinessResponse;
import com.myfin.service.UserBusinessService;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


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
                    null);  
        } catch (Exception e){
            e.printStackTrace();
            return Response.fail(e.getMessage());
        }
        return Response.success(null);
    }

    @PostMapping("/findAll")
    public Result<Object> findAllBusiness(@RequestBody UserBusinessRequest request){
        Object businesses;
        try {
            businesses =  userBusinessService.findAllBusinessByUserId(request.getUserId());
        } catch (Exception e){
            e.printStackTrace();
            return Response.fail(e.getMessage());
        }
        return Response.success(businesses);
    }

    @PostMapping("/update")
    public Result<Object> updateBusiness(@RequestBody UserBusinessRequest request){
        try {
            userBusinessService.updateBusiness(request.getUserId(),
                    request.getBusinessId(),
                    request.getBusinessName(),
                    request.getBusinessProfitLoss(),
                    null);
        } catch (Exception e){
            e.printStackTrace();
            return Response.fail(e.getMessage());
        }
        return Response.success(null);
    }

    @PostMapping("/delete")
    public Result<Object> deleteBusiness(@RequestBody UserBusinessRequest request){
        try {
            userBusinessService.deleteBusiness(request.getUserId(), request.getBusinessId());
        } catch (Exception e){
            e.printStackTrace();
            return Response.fail(e.getMessage());
        }
        return Response.success(null);
    }

    @PostMapping("/updateAll")
    public Result<Object> updateAllBusiness(@RequestBody UserBusinessRequest request){
        try {
            userBusinessService.updateAllBusiness(request.getUserId(), request.getBusinessList());
        } catch (Exception e){
            e.printStackTrace();
            return Response.fail(e.getMessage());
        }
        return Response.success(null);
    }

    @PostMapping(value = "upload/{userId}/{businessId}")
    public Result<Object> upload(@RequestParam("file")MultipartFile file, @PathVariable int userId, @PathVariable int businessId) throws IOException {
        try {
            userBusinessService.uploadFile(file, userId, businessId);
        } catch (Exception e){
            e.printStackTrace();
            return Response.fail(e.getMessage());
        }
        return Response.success(null);
    }
    
}
