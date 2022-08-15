package com.myfin.service;

import com.myfin.entity.Course;

import java.util.HashMap;
import java.util.List;

/**
 * @author Zihang Gao
 */
public interface CourseService {

    List<Course> findCoursePageByType(String courseType, int pageNum);
}
