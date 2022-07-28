package com.myfin.service.impl;

import com.myfin.mapper.UserGoalsMapper;
import com.myfin.service.UserGoalsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author  Yuhzhuo Ma
 */

@Slf4j
@Service
public class UserGoalsServiceImpl implements UserGoalsService {

    @Resource
    private UserGoalsMapper userGoalsMapper;

}
