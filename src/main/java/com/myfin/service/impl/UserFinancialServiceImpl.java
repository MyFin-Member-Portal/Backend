package com.myfin.service.impl;

import com.alibaba.fastjson.JSON;
import com.myfin.mapper.UserFinancialMapper;
import com.myfin.service.UserFinancialService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author  Yuhzhuo Ma
 */

@Slf4j
@Service
public class UserFinancialServiceImpl implements UserFinancialService {
    @Resource
    private UserFinancialMapper userFinancialMapper;

    @Override
    public String getUserFinicialInfoService(int userId) {
        return JSON.toJSONString(userFinancialMapper.getUserFinancialInfo(userId));
    }
}
