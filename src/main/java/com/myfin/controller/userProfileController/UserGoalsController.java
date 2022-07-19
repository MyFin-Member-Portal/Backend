package com.myfin.controller.userProfileController;

import com.myfin.service.UserGoalsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author  Yuhzhuo Ma
 */

@Slf4j
@RestController
@RequestMapping("/myfin/user/profile/goals")
public class UserGoalsController {
    @Resource
    private UserGoalsService userGoalsService;
}
