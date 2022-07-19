package com.myfin.controller.userProfileController;


import com.myfin.service.UserAssetsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author  Yuhzhuo Ma
 */

@Slf4j
@RestController
@RequestMapping("/myfin/user/profile/assets")
public class UserAssetsController {
    @Resource
    private UserAssetsService userAssetsService;
}
