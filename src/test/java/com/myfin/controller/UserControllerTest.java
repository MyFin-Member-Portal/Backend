package com.myfin.controller;

import com.alibaba.fastjson.JSONObject;
import com.myfin.MyFinApplication;
import com.myfin.controller.reqeust.UserInfoUpdateRequest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JsonbTester;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.UnsupportedEncodingException;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MyFinApplication.class})
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    private UserInfoUpdateRequest request;
    
    @BeforeEach
    void setUp() {
       this.request = new UserInfoUpdateRequest();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getUserBasicInfo() throws Exception {
        // build request body
        this.request.setUserId(1);

        // send the request
        MvcResult mvcResult=mockMvc.perform(MockMvcRequestBuilders.post("/myfin/user/profile/getUserBasicProfile")
                        .contentType(MediaType.APPLICATION_JSON).content(JSONObject.toJSONString(this.request))).
                andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        // Expect data of user 1 is false
        assertEquals("200", JSONObject.parseObject(mvcResult.getResponse().getContentAsString()).get("code"));

        log.info("Response status: {}",mvcResult.getResponse().getStatus());
        log.info("Response body{}",mvcResult.getResponse().getContentAsString());
    }

    @Test
    void updateUserBasicInfo() {
    }

    @Test
    void isAdmin() throws Exception {
        // build request body
        this.request.setUserId(1);
        
        // send the request
        MvcResult mvcResult=mockMvc.perform(MockMvcRequestBuilders.post("/myfin/user/isAdmin")
                        .contentType(MediaType.APPLICATION_JSON).content(JSONObject.toJSONString(this.request))).
                andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        
        // Expect data of user 1 is false
        assertEquals(false, JSONObject.parseObject(mvcResult.getResponse().getContentAsString()).get("data"));
        
        log.info("Response status: {}",mvcResult.getResponse().getStatus());
        log.info("Response body{}",mvcResult.getResponse().getContentAsString());
    }
}