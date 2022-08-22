package com.myfin.controller.reqeust;

import lombok.Data;

import java.sql.Blob;

/**
 * @author Zihang Gao
 */
@Data
public class CourseRequest {
    private int courseId;

    private String courseName;

    private String courseDesc;

    private String courseUrl;

    private Blob courseImg;

    private String courseType;

    private String courseImgUrl;

    private int courseIsCharge;
}
