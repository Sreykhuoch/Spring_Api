package com.example.chea_srey_khuoch_pp_spring_homework002.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Course {
   private Integer courseId;
   private String courseName;
   private String description;
   private Instructor instructor;

}
