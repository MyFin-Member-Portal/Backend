package com.myfin.service.impl;

import com.myfin.mapper.MemberLevelMapper;
import com.myfin.mapper.MembershipMapper;
import com.myfin.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

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
}
