package com.myfin.controller;

import com.myfin.base.Response;
import com.myfin.base.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zihang Gao
 */

@RestController
@RequestMapping("/myfin")
public class LoginController {
    @GetMapping("/login")
    public Result<Object> login(){
        return Response.success(null);
    }
    
}
