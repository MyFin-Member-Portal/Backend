package com.myfin.service;

import com.myfin.entity.Course;

import java.sql.Blob;
import java.util.HashMap;
import java.util.List;

/**
 * @author Zihang Gao
 */
public interface CourseService {

    List<Course> findCoursePageByType(String courseType, int pageNum);

    int addCourse(String courseName, String courseType, String courseDesc,
                  int courseIsCharge, String courseUrl, Blob courseImg, String courseImgUrl);

    void removeCourse(int courseId);
}
