package com.myfin.controller;

import com.myfin.base.Response;
import com.myfin.base.Result;
import com.myfin.controller.reqeust.MemberRequest;
import com.myfin.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;


/**
 * @author Zihang Gao
 */
@Slf4j
@RestController
@RequestMapping("/myfin/member")
public class MemberController {
    
    @Resource
    MemberService memberService;
    
    @PostMapping("/add")
    public Result<Object> addNewMember(@RequestBody MemberRequest memberRequest) {

        memberService.addMembership(
                memberRequest.getUserId(),
                memberRequest.getMemberLevelId(),
                memberRequest.getStartTime() ,
                memberRequest.getEndTime());

        return Response.success("");
    }

    @PostMapping("remove")
    public Result<Object> removeMember(@RequestBody MemberRequest memberRequest){
        memberService.removeMembership(memberRequest.getUserId());
        return Response.success("");
    }

    @PostMapping("upgrade")
    public Result<Object> upgrade(@RequestBody MemberRequest memberRequest){
        memberService.updateMemberLevel(memberRequest.getUserId(), memberRequest.getMemberLevelId());
        return Response.success("");
    }

    @PostMapping("renewal")
    public Result<Object> renewal(@RequestBody MemberRequest memberRequest){
        memberService.updateEndTime(memberRequest.getUserId(), memberRequest.getEndTime());
        return Response.success("");
    }

    @PostMapping("isMember")
    public Result<Boolean> isMember(@RequestBody MemberRequest memberRequest){
        return Response.success(memberService.isMember(memberRequest.getUserId()));
    }
}
