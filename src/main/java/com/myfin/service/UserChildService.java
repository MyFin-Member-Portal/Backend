package com.myfin.service;

import com.myfin.entity.UserChild;
import java.util.List;
public interface UserChildService {

    //    not use curently
    int getCurrentChildId(int userId);

    int addUserChildService(int userId, int userChildAge, String userChildEdu);

    UserChild getSpecificUserChildService(int userId, int userChildId);

    List<UserChild> getUserChildService(int userId);

    int updateTotalUserChildService(Object childList);
}
