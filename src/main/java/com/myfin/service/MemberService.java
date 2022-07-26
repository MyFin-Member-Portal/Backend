package com.myfin.service;


import java.util.Date;

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
    void addMembership(int userId, int mlId, long startTime, long endTime);

    /**
     * delete the member from the membership
     * 
     * @param userId the user id
     */
    void removeMembership(int userId);
    
}
