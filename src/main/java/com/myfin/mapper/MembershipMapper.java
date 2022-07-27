package com.myfin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author Zihang Gao
 */
@Mapper
@Repository
public interface MembershipMapper {
    /**
     * add a user to membership
     * 
     * @param userId the user id
     * @param mlId the member level id
     * @param startTime the membership start time
     * @param endTime the membership end time      
     */
    void addMember(int userId, int mlId, Date startTime, Date endTime);

    /**
     * remove a user from membership
     * 
     * @param userId the user id
     */
    void removeMember(int userId);

    /**
     * update a member to a new member level
     * 
     * @param userId the user id
     * @param mlId the member level id       
     */
    void updateMember(int userId, int mlId);

    /**
     * update the end time of membership for a user
     * 
     * @param userId the user id
     * @param endTime the end time of membership
     */
    void updateEndTime(int userId, Date endTime);

    /**
     * count if the member exist on the table
     * 
     * @param userId the user id
     * @return the amount of the user, 1 will be exist and 0 will be not.
     */
    int countUserId(int userId);

    /**
     * find all time 
     * @param userId the user id
     * @return the time list
     */
    HashMap<String, LocalDateTime> findAllTime(int userId);
}
