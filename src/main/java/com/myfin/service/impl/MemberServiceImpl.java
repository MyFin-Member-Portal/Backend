package com.myfin.service.impl;

import com.myfin.mapper.MemberLevelMapper;
import com.myfin.mapper.MembershipMapper;
import com.myfin.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
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
    public void addMembership(int userId, int mlId, long startTime, long endTime) throws SQLIntegrityConstraintViolationException{
        
        // add 000 and the end of time to make it support the formatting change
        long newStartTime = new Long(startTime + "000");
        long newEndTime = new Long(endTime + "000");
        
        Date startTimeDate = new Date(newStartTime);
        Date endTimeDate = new Date(newEndTime);
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
        long newEndTime = new Long(endTime + "000");
        
        Date endTimeFormat = new Date(newEndTime);
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

    @Override
    public HashMap<String, Object> findAll(int userId) {
        HashMap<String, Object> resultMap = membershipMapper.findAll(userId);
        
        log.info(resultMap.toString());

        LocalDateTime startDateLocal = (LocalDateTime) resultMap.get("member_st_time");
        LocalDateTime endDateLocal = (LocalDateTime) resultMap.get("member_end_time");
        
        resultMap.put("member_st_time", startDateLocal.toInstant(ZoneOffset.of("+10")).toEpochMilli());
        resultMap.put("member_end_time", endDateLocal.toInstant(ZoneOffset.of("+10")).toEpochMilli());
        
        return resultMap;
    }
}
