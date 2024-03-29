package com.example.chea_srey_khuoch_pp_spring_homework002.service;

import com.example.chea_srey_khuoch_pp_spring_homework002.model.Student;
import com.example.chea_srey_khuoch_pp_spring_homework002.model.StudentRequest;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudent();

    Student createStudent(StudentRequest studentRequest);
}
