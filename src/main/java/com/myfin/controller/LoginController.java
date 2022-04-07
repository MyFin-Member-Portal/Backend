package com.myfin.controller;

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
    public String login(){
        return "Success";
    }
    
}
