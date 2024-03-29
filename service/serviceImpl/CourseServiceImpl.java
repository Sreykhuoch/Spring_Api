package com.example.chea_srey_khuoch_pp_spring_homework002.service.serviceImpl;

import com.example.chea_srey_khuoch_pp_spring_homework002.model.Course;
import com.example.chea_srey_khuoch_pp_spring_homework002.model.CourseRequest;
import com.example.chea_srey_khuoch_pp_spring_homework002.repositary.CourseRepositary;
import com.example.chea_srey_khuoch_pp_spring_homework002.service.CourseService;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepositary courseRepositary;

    public CourseServiceImpl(CourseRepositary courseRepositary) {
        this.courseRepositary = courseRepositary;
    }

    @Override
    public List<Course> getAllCourse() {
        return courseRepositary.getAllCourse();
    }

    public Course getCourseById(Integer id) throws NotFoundException{
          if(courseRepositary.findByCourseId(id)==null){
              throw new NotFoundException("Course not found");
          }
          return courseRepositary.findByCourseId(id);
    }
    @Override
    public Course createCourse(CourseRequest courseRequest) {
        return courseRepositary.insertCourse(courseRequest);
    }

    @Override
    public void updateCourse(Integer id, CourseRequest courseRequest) throws NotFoundException {
        if(courseRepositary.findByCourseId(id)==null){
            throw new NotFoundException("Course are not found");

        }
        courseRepositary.updateAuthorById(id, courseRequest);
    }

    @Override
    public void deleteCourse(Integer id) throws NotFoundException {
        if(courseRepositary.findByCourseId(id)==null){
            throw new NotFoundException("Course are not found");

        }
        courseRepositary.deleteById(id);
    }


}
