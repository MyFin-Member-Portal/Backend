package com.myfin.mapper;

import com.myfin.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.sql.Blob;
import java.util.HashMap;
import java.util.List;

/**
 * @author Zihang Gao
 */
@Mapper
@Repository
public interface CourseMapper {
    
    List<HashMap<String, Object>> findCoursePageByType(String courseType, int pageNum);
    
    void addCourse(String courseName, String courseType, String courseDesc, 
                  int courseIsCharge, String courseUrl, Blob courseImg, String courseImgUrl);
    
    void removeCourse(int courseId);
    
    int findMaxId();

    int findTotalPage();

    /**
     * find the favourite course list for a user
     * @param userId user id 
     * @return the course list
     */
    List<HashMap<String, Integer>> findFavCourse(int userId);
    
    void addFavCourse(int userId, int courseId);

    void removeFavCourse(int userId, int courseId);
}
