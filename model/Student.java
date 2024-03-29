package com.example.chea_srey_khuoch_pp_spring_homework002.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
  private String StudentId;
  private String studentName;
  private String email;
  private String phoneNumber;
  private Instructor instructor;

  List<Course> courses;
}
