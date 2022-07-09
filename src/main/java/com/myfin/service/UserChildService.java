package com.myfin.service;

import com.myfin.entity.UserChild;
public interface UserChildService {

    //    not use curently
    int getCurrentChildId(int userId);

    int addUserChildService(int userId, int userChildAge, String userChildEdu);

    UserChild getSpecificUserChildService(int userId, int userChildId);

    String getUserChildService(int userId);

    int updateTotalUserChildService(Object childList);

    int deleteSpecificUserChildService(int userId, int userChildId);
}
