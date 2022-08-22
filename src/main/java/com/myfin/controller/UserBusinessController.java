package com.myfin.controller;

import com.myfin.base.Response;
import com.myfin.base.Result;
import com.myfin.controller.reqeust.UserBusinessRequest;
import com.myfin.service.UserBusinessService;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.*;
import java.nio.file.Files;
import java.sql.SQLException;


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
        int businessId = -1;
        try {
            businessId = userBusinessService.addBusiness(request.getUserId(),
                    request.getBusinessName(),
                    request.getBusinessProfitLoss(),
                    null);  
        } catch (Exception e){
            e.printStackTrace();
            return Response.fail(e.getMessage());
        }
        return Response.success(businessId);
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

    @PostMapping(value = "upload")
    public Result<Object> upload(@RequestParam("file")MultipartFile file, @RequestParam("userId") int userId, @RequestParam("businessId") int businessId) throws IOException {
        String fileName = file.getOriginalFilename();
        File dest = new File(new File("./files/business-sheet").getAbsolutePath()+ "/" + userId  + "/" + fileName);
        
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            userBusinessService.uploadFile(dest.getPath(), userId, businessId);
            return Response.success(null);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.fail(null);
        }
    }
    
    @PostMapping(value = "download", produces = "text/csv")
    public ResponseEntity<InputStreamResource> downloadFile(@RequestBody UserBusinessRequest request) throws IOException, SQLException {
        String filePath = userBusinessService.downloadFile(request.getUserId(), request.getBusinessId());
        FileSystemResource file = new FileSystemResource(filePath);
        
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header("Content-disposition", "attachment; filename=1.csv")
                .body(new InputStreamResource(file.getInputStream()));
    }

    @PostMapping(value = "deleteFile")
    public Result<String> deleteFile(@RequestBody UserBusinessRequest request) throws SQLException {
        String filePath = userBusinessService.downloadFile(request.getUserId(), request.getBusinessId());
        File file =new File(filePath);
        try {
            file.delete();
            userBusinessService.uploadFile(null, request.getUserId(), request.getBusinessId());
            return Response.success("Detele success"); 
        } catch (Exception e){
            e.printStackTrace();
            return Response.fail("Delete fail");
        }
        
    }
    
}
