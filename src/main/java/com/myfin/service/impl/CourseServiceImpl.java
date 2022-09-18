package com.myfin.service.impl;

import com.myfin.entity.Course;
import com.myfin.mapper.CourseMapper;
import com.myfin.service.CourseService;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Blob;
import java.util.Collections;
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
    public HashMap<String, Object> findCoursePageByType(String courseType, int pageNum, int userId) {
        int pageOffsite = (pageNum - 1) * 4;
        HashMap<String, Object> resultMap = new HashMap<>();
        List<HashMap<String, Integer>> favCourseList = courseMapper.findFavCourse(userId);
        // get result from database
        List<HashMap<String, Object>> courseList = courseMapper.findCoursePageByType(courseType, pageOffsite);
        int pageAmount = courseMapper.findTotalPage();
        
        for(HashMap course: courseList){
            for(HashMap item: favCourseList){
                int favId = (int) item.get("course_id");
                if((int)course.get("course_id") == favId){
                    course.put("courseIsFavorite", 1);
                }else {
                    course.put("courseIsFavorite", 0);
                }
            }
        }
        
        // put result in a hashmap
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

    @Override
    public void addFavCourse(int userId, int courseId) {
        courseMapper.addFavCourse(userId, courseId);
    }

    @Override
    public void removeFavCourse(int userId, int courseId) {
        courseMapper.removeFavCourse(userId, courseId);
    }

    @Override
    public List<HashMap<String, Integer>> findFavCourse(int userId) {
        return findFavCourse(userId);
    }


}
