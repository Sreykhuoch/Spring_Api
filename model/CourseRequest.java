package com.example.chea_srey_khuoch_pp_spring_homework002.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseRequest {
    private String courseName;
    private String description;
    private Integer instructorId;
}
