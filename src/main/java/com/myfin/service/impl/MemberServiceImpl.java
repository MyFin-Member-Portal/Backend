package com.myfin.service.impl;

import com.myfin.mapper.MemberLevelMapper;
import com.myfin.mapper.MembershipMapper;
import com.myfin.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author Zihang Gao
 */
@Slf4j
@Service
public class MemberServiceImpl implements MemberService {

    @Resource
    MembershipMapper membershipMapper;
    
    @Resource
    MemberLevelMapper memberLevelMapper;
    
    @Override
    public void addMembership(int userId, int mlId, long startTime, long endTime) {
        Date startTimeDate = new Date(startTime);
        Date endTimeDate = new Date(endTime);
        membershipMapper.addMember(userId, mlId, startTimeDate, endTimeDate);
    }

    @Override
    public void removeMembership(int userId) {
        membershipMapper.removeMember(userId);
    }

    @Override
    public void updateMemberLevel(int userId, int mlId) {
        membershipMapper.updateMember(userId, mlId);
    }

    @Override
    public void updateEndTime(int userId, long endTime) {
        Date endTimeFormat = new Date(endTime);
        membershipMapper.updateEndTime(userId, endTimeFormat);
    }

    @Override
    public Boolean isMember(int userId) {
        HashMap<String, LocalDateTime> timeList = membershipMapper.findAllTime(userId);
        if(timeList == null){
            return false;
        }
        LocalDateTime startTime = timeList.get("member_st_time");
        LocalDateTime endTime = timeList.get("member_end_time");
        return startTime.isBefore(endTime);
    }
}
