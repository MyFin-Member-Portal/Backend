package com.myfin.mapper;

import com.myfin.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Zihang Gao
 */
@Mapper
@Repository
public interface CourseMapper {
    
    List<Course> findCoursePageByType(String courseType, int pageNum);
}
