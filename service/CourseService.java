package com.example.chea_srey_khuoch_pp_spring_homework002.service;

import com.example.chea_srey_khuoch_pp_spring_homework002.model.Course;
import com.example.chea_srey_khuoch_pp_spring_homework002.model.CourseRequest;
import org.apache.ibatis.javassist.NotFoundException;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourse();

    Course createCourse(CourseRequest courseRequest);

    Course getCourseById(Integer id) throws NotFoundException;

    void updateCourse(Integer id ,CourseRequest courseRequest) throws NotFoundException;

    void deleteCourse(Integer id) throws NotFoundException;
}
