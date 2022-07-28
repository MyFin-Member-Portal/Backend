package com.myfin.service;


import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * @author Zihang Gao
 */
public interface MemberService {
    /**
     *  add a user into membership
     *  
     * @param userId the user id 
     * @param mlId the member level id
     * @param startTime the start time of membership
     * @param endTime the end time of membership
     */
    void addMembership(int userId, int mlId, long startTime, long endTime) throws SQLIntegrityConstraintViolationException;

    /**
     * delete the member from the membership
     * 
     * @param userId the user id
     */
    void removeMembership(int userId);

    /**
     * update the user to another member level
     * 
     * @param userId user id
     * @param mlId member level id
     */
    void updateMemberLevel(int userId, int mlId);


    /**
     * update the user to another member level
     *
     * @param userId user id
     * @param endTime the end time 
     */
    void updateEndTime(int userId, long endTime);

    /**
     * justify if is member
     * 
     * @param userId the user id
     * @return a true or false
     */
    Boolean isMember(int userId);
}
