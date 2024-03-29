package com.example.chea_srey_khuoch_pp_spring_homework002.controller;

import com.example.chea_srey_khuoch_pp_spring_homework002.model.ApiResponse;
import com.example.chea_srey_khuoch_pp_spring_homework002.model.Course;
import com.example.chea_srey_khuoch_pp_spring_homework002.model.CourseRequest;
import com.example.chea_srey_khuoch_pp_spring_homework002.service.CourseService;
import com.example.chea_srey_khuoch_pp_spring_homework002.service.InstructorService;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Api/v1/course")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }



    @GetMapping("/{id}")
    @Operation(summary = "Get Course By Id")
    public ResponseEntity<?> getCourseById(@PathVariable Integer id) throws NotFoundException{
        Course course = courseService.getCourseById(id);
        System.out.println(course);
        ApiResponse<Course> response = new ApiResponse<>(
                "Successfully get course by id",
                HttpStatus.OK,
                200,
                course
        );
        return ResponseEntity.ok(response);
    }


    @GetMapping
    @Operation(summary = "Get All Course")
    public ResponseEntity<?> getAllCourse(){
        List<Course> courses = courseService.getAllCourse();
        return ResponseEntity.ok(new ApiResponse<>(
                "sucessfully display !",
                HttpStatus.OK,
                200,
                courses
        ));
    }

    @PostMapping
    @Operation(summary = "Create Course")
    public ResponseEntity<?> insertCourse(@RequestBody CourseRequest courseRequest){
        Course course = courseService.createCourse(courseRequest);
        return ResponseEntity.ok(new ApiResponse<>(
                "Successfully created book",
                HttpStatus.OK,
                200,
                course
        ));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Course By Id")
    public ResponseEntity<?> updateCourse(@PathVariable Integer id,
                                          @RequestBody CourseRequest courseRequest) throws NotFoundException{
        courseService.updateCourse(id, courseRequest);
        ApiResponse<Course> response= new ApiResponse<>(
                "Successfully updated courses",
                HttpStatus.OK,
                200,
                null
        );
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Course By Id")
    public ResponseEntity<?> deleteCourse(@PathVariable Integer id) throws NotFoundException{
        courseService.deleteCourse(id);
        ApiResponse<?> response = new ApiResponse<>(
                "Successfully deleted from course",
                HttpStatus.OK,
                200,
                null
        );
        return ResponseEntity.ok(response);
    }

}
