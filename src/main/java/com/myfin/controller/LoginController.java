package com.myfin.controller;

import com.myfin.base.Response;
import com.myfin.base.Result;
import com.myfin.controller.reqeust.LoginRequest;
import com.myfin.service.LoginService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Zihang Gao
 */

@RestController
@RequestMapping("/myfin")
public class LoginController {
    @Resource
    LoginService loginService;
    
    @PostMapping("/login")
    public Result<Object> login(@RequestBody LoginRequest loginRequest){
        Object obj = loginService.findUserById(loginRequest.getUserId());
        
        return Response.success(obj);
    }
    
}
