package com.myfin.service;

import com.myfin.entity.User;
import com.myfin.entity.UserChild;

import java.util.List;

public interface UserService {
    User findUserById(int userId);




    int updateUserProfile(String phoneNumber, String Address, String Gender,
                          String Nationality, String Heritage, String Language,
                          String Name, String Email, int userId);

    int getCurrentChildId(int userId);

    int addUserChildService(int userId, int userChildId, int userChildAge, String userChildEdu);

    List<UserChild> getUserChildService(int userId);

}
