package com.myfin.service.impl;

import com.myfin.entity.Course;
import com.myfin.mapper.CourseMapper;
import com.myfin.service.CourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Blob;
import java.util.HashMap;
import java.util.List;

/**
 * @author Zihang Gao
 */
@Service
public class CourseServiceImpl implements CourseService {
    
    @Resource
    CourseMapper courseMapper;
    
    @Override
    public HashMap<String, Object> findCoursePageByType(String courseType, int pageNum) {
        int pageOffsite = (pageNum - 1) * 4;
        HashMap<String, Object> resultMap = new HashMap<>();

        List<Course> courseList = courseMapper.findCoursePageByType(courseType, pageOffsite);
        int pageAmount = courseMapper.findTotalPage();

        resultMap.put("courses", courseList);
        resultMap.put("totalPage", pageAmount);
        return resultMap;
    }

    @Override
    public int addCourse(String courseName, String courseType, String courseDesc, 
                         int courseIsCharge, String courseUrl, Blob courseImg, String courseImgUrl) {
        
            courseMapper.addCourse(courseName, courseType,
                    courseDesc, courseIsCharge, courseUrl, courseImg, courseImgUrl);
        return courseMapper.findMaxId();
    }

    @Override
    public void removeCourse(int courseId) {
        courseMapper.removeCourse(courseId);
    }
}
