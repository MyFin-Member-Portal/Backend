package com.myfin.mapper;

import com.myfin.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.sql.Blob;
import java.util.List;

/**
 * @author Zihang Gao
 */
@Mapper
@Repository
public interface CourseMapper {
    
    List<Course> findCoursePageByType(String courseType, int pageNum);
    
    void addCourse(String courseName, String courseType, String courseDesc, 
                  int courseIsCharge, String courseUrl, Blob courseImg, String courseImgUrl);
    
    void removeCourse(int courseId);
    
    int findMaxId();

    int findTotalPage();
}
