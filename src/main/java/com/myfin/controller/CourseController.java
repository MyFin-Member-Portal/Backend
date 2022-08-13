package com.myfin.controller;

import com.myfin.base.Response;
import com.myfin.base.Result;
import com.myfin.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author zihang gao
 */
@Slf4j
@RestController
@RequestMapping("/myfin")
public class CourseController {
    
    @Resource
    CourseService courseService;
    
    
    @GetMapping("course/page")
    public Result<Object> coursePage(@RequestParam("pageNum") int pageNum, @RequestParam("courseType") String courseType){
        
        return Response.success(courseService.findCoursePageByType(courseType, pageNum));
    }
    
}
