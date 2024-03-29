package com.example.chea_srey_khuoch_pp_spring_homework002.controller;

import com.example.chea_srey_khuoch_pp_spring_homework002.model.ApiResponse;
import com.example.chea_srey_khuoch_pp_spring_homework002.model.Student;
import com.example.chea_srey_khuoch_pp_spring_homework002.model.StudentRequest;
import com.example.chea_srey_khuoch_pp_spring_homework002.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    @Operation(summary = "Get All student")
    public ResponseEntity<?> getAllStudent(){
        List<Student> students = studentService.getAllStudent();
        return ResponseEntity.ok(new ApiResponse<>(
                "Successfully get all student",
                HttpStatus.OK,
                200,
                students
        ));
    }

    @PostMapping
    @Operation(summary = "Create student")
    public ResponseEntity<?> createStudent(@RequestBody StudentRequest studentRequest){
        Student student = studentService.createStudent(studentRequest);
        return ResponseEntity.ok(new ApiResponse<>(
                "Successfully Created",
                HttpStatus.OK,
                200,
                student

        ));
    }
}
