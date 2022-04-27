package com.myfin.controller;

import com.myfin.base.Response;
import com.myfin.base.Result;
import com.myfin.controller.reqeust.LoginRequest;
import com.myfin.entity.User;
import com.myfin.service.LoginService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Zihang Gao
 */
@Slf4j
@RestController
@RequestMapping("/myfin")
public class LoginController {
    @Resource
    private LoginService loginService;

    @ApiOperation(value = "login API",notes = "login API note")
    @PostMapping("/login")
    public Result<Object> login(@RequestBody LoginRequest loginRequest){
        User user = loginService.findUserById(loginRequest.getUserId());
        return Response.success(user);
    }
    
    @PostMapping("/register")
    public Result<Object> register(@RequestBody LoginRequest loginRequest){
        log.info(loginRequest.toString());
        int userId = loginService.addUser(loginRequest.getUserName(), loginRequest.getEmail(), loginRequest.getPassword());
        return Response.success(userId);
    }
    
}
