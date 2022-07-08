package com.myfin.controller;

import com.myfin.base.Response;
import com.myfin.base.Result;
import com.myfin.controller.reqeust.LoginRequest;
import com.myfin.service.LoginService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Zihang Gao, Yuzhuo Ma
 */
@Slf4j
@RestController
@RequestMapping("/myfin")
public class LoginController {
    @Resource
    private LoginService loginService;

    @ApiOperation(value = "login API",notes = "login API note")
    @PostMapping("/login")
    public Result<Object> login(HttpServletRequest request, @RequestBody LoginRequest loginRequest){

        //get email from frontend page, then query from database
        String email = loginRequest.getEmail();
        int userId = loginService.findUserByEmail(email);
        
        // if not find in database
        if(userId == 0){
            return Response.fail("no such user");
        }

        // get password from frontend page, make password to md5 password
        String md5Password = loginService.getMd5Password(loginRequest.getPassword());

        // query password from database account
        String userPassword = loginService.getAccountPassword(userId);

        // if not match password
        if (!userPassword.equals(md5Password)){
            return Response.fail("password is wrong");
        }
        request.getSession().setAttribute("user", userId);
        return Response.success(userId);
    }
    
    @PostMapping("/register")
    public Result<Object> register(@RequestBody LoginRequest loginRequest){
        // assign a value to handle error 
        int userId = -1;
        try {
            userId = loginService.addUser(loginRequest.getUserName(), loginRequest.getEmail(), loginRequest.getPassword());
        } catch (DuplicateKeyException e){
            return Response.duplicateKey();
        }
        return Response.success(userId);
    }
    
}
