package com.myfin.service.impl;
import com.myfin.entity.UserChild;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myfin.mapper.UserChildMapper;
import com.myfin.service.UserChildService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.binding.BindingException;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSON;
import javax.annotation.Resource;
import java.util.List;
/**
 * @author  Yuhzhuo Ma
 */

@Slf4j
@Service
public class UserChildServiceImpl implements UserChildService {
    @Resource
    private UserChildMapper userChildMapper;
    @Override
    public int getCurrentChildId(int userId){
        try {
            userChildMapper.findMaxUserChildId(userId);
        }catch (BindingException be){
            return 0;
        }
        return userChildMapper.findMaxUserChildId(userId);
    }

    @Override
    public int addUserChildService(int userId, int userChildAge, String userChildEdu) {
        userChildMapper.addUserChild(userId, userChildAge, userChildEdu );
        return userId;
    }

    @Override
    public UserChild getSpecificUserChildService(int userId, int userChildId) {
        List<UserChild> childList = this.getUserChildServiceList(userId);
        for (UserChild child:childList){
            if (userChildId == child.getUserChildId()){
                return child;
            }
        }
        return null;
    }



    @Override
    public List<UserChild> getUserChildService(int userId) {
        return userChildMapper.getUserChild(userId);
    }



    @Override
    public int updateTotalUserChildService(Object childList) {
        ObjectMapper mapper = new ObjectMapper();

        List<UserChild> childListObj = mapper.convertValue(childList,new TypeReference<List<UserChild>>(){ });

        int user_id = childListObj.get(0).getUserId();
//      get one user's multiple child

        for (UserChild userChild : childListObj) {
            this.updateUserChild(user_id, userChild);
        }
        return user_id;
    }

    @Override
    public int deleteSpecificUserChildService(int userId, int userChildId) {
        userChildMapper.deleteSpecificUserChild(userId, userChildId);
        return userChildId;
    }


    public void updateUserChild(int userId, UserChild child){
        userChildMapper.updateUserChildProfile(userId, child.getUserChildId(),
                child.getUserChildAge(), child.getUserChildEdu());
    }

    public List<Integer> getUserChildId(int userId){
        log.info("---------"+userChildMapper.getUserChildId(userId));

        return userChildMapper.getUserChildId(userId);
    }
    public List<UserChild> getUserChildServiceList(int userId) {

        return userChildMapper.getUserChild(userId);
    }
}
