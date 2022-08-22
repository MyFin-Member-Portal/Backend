package com.myfin.controller;

import com.myfin.base.Response;
import com.myfin.base.Result;
import com.myfin.controller.reqeust.CourseRequest;
import com.myfin.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author zihang gao
 */
@Slf4j
@RestController
@RequestMapping("/myfin/course")
public class CourseController {
    
    @Resource
    CourseService courseService;
    
    
    @GetMapping("/page")
    public Result<Object> coursePage(@RequestParam("pageNum") int pageNum, @RequestParam("courseType") String courseType){
        
        return Response.success(courseService.findCoursePageByType(courseType, pageNum));
    }

    @GetMapping("/remove")
    public Result<String> removeCourse(@RequestParam("courseId") int courseId){
        
        try {
            courseService.removeCourse(courseId);
        } catch (Exception e){
            e.printStackTrace();
            return Response.fail(null);
        }

        return Response.success("Remove success");
    }

    @PostMapping("/add")
    public Result<Integer> addCourse(@RequestBody CourseRequest r){
        int courseId = -1;
        try {
            courseId = courseService.addCourse(r.getCourseName(), r.getCourseType(), r.getCourseDesc(), r.getCourseIsCharge(), 
                    r.getCourseUrl(), r.getCourseImg(), r.getCourseImgUrl());
            
        } catch (Exception e){
            e.printStackTrace();
        }

        return Response.success(courseId);
    }
    
}
