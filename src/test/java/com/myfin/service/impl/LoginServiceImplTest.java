package com.myfin.service.impl; 

import org.junit.Assert;
import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/** 
* LoginServiceImpl Tester. 
* 
* @author Zihang Gao
* @since <pre>5月 4, 2022</pre> 
* @version 1.0 
*/
public class LoginServiceImplTest {
    
    @Before
    public void before() throws Exception { 
        
    } 
    
    @After
    public void after() throws Exception { 
    } 
    
    /** 
    * 
    * Method: findUserByEmail(String userEmail) 
    * 
    */ 
    @Test
    public void testFindUserByEmail() throws Exception {
        System.out.println("123");
    } 
    
    /** 
    * 
    * Method: findUserById(int userId) 
    * 
    */ 
    @Test
    public void testFindUserById() throws Exception { 
    //TODO: Test goes here... 
    } 
    
    /** 
    * 
    * Method: findAccountByUserId(int userId) 
    * 
    */ 
    @Test
    public void testFindAccountByUserId() throws Exception { 
    //TODO: Test goes here... 
    } 
    
    /** 
    * 
    * Method: addUser(String userName, String email, String password) 
    * 
    */ 
    @Test
    public void testAddUser() throws Exception { 
    //TODO: Test goes here... 
    } 
    

} 
