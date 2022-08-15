package com.myfin.entity;

import lombok.Data;

import java.sql.Blob;

/**
 * @author Zihang Gao
 */
@Data
public class Course {
    private int courseId;
    
    private String courseName;
    
    private String courseDesc;
    
    private String courseUrl;
    
    private Blob courseImg;

    private String courseType;
    
    private String courseImgUrl;
}
