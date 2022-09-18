package com.myfin.service;

import com.myfin.entity.Course;

import java.sql.Blob;
import java.util.HashMap;
import java.util.List;

/**
 * @author Zihang Gao
 */
public interface CourseService {

    HashMap<String, Object> findCoursePageByType(String courseType, int pageNum, int userId);

    int addCourse(String courseName, String courseType, String courseDesc,
                  int courseIsCharge, String courseUrl, Blob courseImg, String courseImgUrl);

    void removeCourse(int courseId);

    void addFavCourse(int userId, int courseId);

    void removeFavCourse(int userId, int courseId);

    List<HashMap<String, Integer>> findFavCourse(int userId);
}
