package com.myfin.controller;

import com.alibaba.fastjson.JSONObject;
import com.myfin.MyFinApplication;
import com.myfin.controller.reqeust.LoginRequest;
import com.myfin.controller.reqeust.UserInfoUpdateRequest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MyFinApplication.class})
@AutoConfigureMockMvc
class LoginControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private LoginRequest request;
    
    @BeforeEach
    void setUp() {
        request = new LoginRequest();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void login() throws Exception {
        // build request body
        this.request.setEmail("test123123@gmail.com");
        this.request.setPassword("test");

        // send the request
        MvcResult mvcResult=mockMvc.perform(MockMvcRequestBuilders.post("/myfin//login")
                        .contentType(MediaType.APPLICATION_JSON).content(JSONObject.toJSONString(this.request))).
                andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
    }

    @Test
    void register() throws Exception {
        // build request body
        this.request.setEmail("123456@gamil.com");
        this.request.setPassword("123456");
        this.request.setUserName("123456");

        // send the request
        MvcResult mvcResult=mockMvc.perform(MockMvcRequestBuilders.post("/myfin/register")
                        .contentType(MediaType.APPLICATION_JSON).content(JSONObject.toJSONString(this.request))).andReturn();
        
        // Expect data of user 1 is false
        assertEquals("A101", JSONObject.parseObject(mvcResult.getResponse().getContentAsString()).get("code"));
    }
}