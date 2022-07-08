package com.myfin.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myfin.entity.User;
import com.myfin.entity.UserChild;
import com.myfin.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.binding.BindingException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.myfin.service.UserService;

import java.util.List;



/**
 * @author Zihang Gao, Yuhzhuo Ma
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User findUserById(int userId) {
        return userMapper.findUserById(userId);
    }


    @Override
    public int updateUserProfile(String phoneNumber, String Address, String Gender,
                                 String Nationality, String Heritage, String Language,
                                 String Name, String Email, int userId) {
        userMapper.updateUserProfile(
                phoneNumber, Address, Gender, Nationality, Heritage, Language, Name, Email, userId
        );
        return userId;
    }

    @Override
    public int getCurrentChildId(int userId){
        try {
            userMapper.findMaxUserChildId(userId);
        }catch (BindingException be){
            return 0;
        }
        return userMapper.findMaxUserChildId(userId);
    }

    @Override
    public int addUserChildService(int userId, int userChildAge, String userChildEdu) {
        userMapper.addUserChild(userId, userChildAge, userChildEdu );
        return userId;
    }

    @Override
    public UserChild getSpecificUserChildService(int userId, int userChildId) {
        List<UserChild> childList = this.getUserChildService(userId);
        for (UserChild child:childList){
            if (userChildId == child.getUserChildId()){
                return child;
            }
        }
        return null;
    }

    @Override
    public List<UserChild> getUserChildService(int userId) {
        return userMapper.getUserChild(userId);
    }

    @Override
    public int updateTotalUserChildService(Object childList) {
        ObjectMapper mapper = new ObjectMapper();

        List<UserChild> childListObj = mapper.convertValue(childList,new TypeReference<List<UserChild>>(){ });

        int user_id = childListObj.get(0).getUserId();
//      get one user's multiple child
        List<Integer> childIdList = this.getUserChildId(user_id);

        for (int i = 0; i<childIdList.size(); i++){
            this.updateUserChild(childIdList.get(i),childListObj.get(i));
        }
        return user_id;
    }

    public void updateUserChild(int childId, UserChild child){
        userMapper.updateUserChildProfile(child.getUserId(), childId,
        child.getUserChildAge(), child.getUserChildEdu());
    }

    public List<Integer> getUserChildId(int userId){
        return userMapper.getUserChildId(userId);

    }




}
