package com.myfin.controller;

import com.myfin.base.Response;
import com.myfin.base.Result;
import com.myfin.controller.reqeust.LoginRequest;
import com.myfin.entity.Account;
import com.myfin.entity.User;
import com.myfin.service.LoginService;
import com.myfin.util.Md5Encryption;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

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
        User user = loginService.findUserByEmail(email);
        // if not find in database
        if (user == null){
            return Response.fail("no such user");
        }

        // get password from frontend page, make password to md5 password
        String password = loginRequest.getPassword();
        String md5Password = Md5Encryption.encode(password);

        System.out.println("--------------------"+md5Password);

        // query password from database account
        Account account = loginService.findAccountByUserId(user.getUser_id()) ;
        String userPassword = account.getAccount_password();

        // if not match password
        if (!userPassword.equals(md5Password)){
            return Response.fail("password is wrong");
        }

        request.getSession().setAttribute("user", user.getUser_id());
        return Response.success(user);
    }
    
    @PostMapping("/register")
    public Result<Object> register(@RequestBody LoginRequest loginRequest){
        log.info(loginRequest.toString());
        int userId = loginService.addUser(loginRequest.getUserName(), loginRequest.getEmail(), loginRequest.getPassword());
        return Response.success(userId);
    }
    
}
