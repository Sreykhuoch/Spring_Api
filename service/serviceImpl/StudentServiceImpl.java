package com.example.chea_srey_khuoch_pp_spring_homework002.service.serviceImpl;

import com.example.chea_srey_khuoch_pp_spring_homework002.model.Student;
import com.example.chea_srey_khuoch_pp_spring_homework002.model.StudentRequest;
import com.example.chea_srey_khuoch_pp_spring_homework002.repositary.StudentRepositary;
import com.example.chea_srey_khuoch_pp_spring_homework002.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepositary studentRepositary;

    public StudentServiceImpl(StudentRepositary studentRepositary) {
        this.studentRepositary = studentRepositary;
    }


    @Override
    public List<Student> getAllStudent() {
        return studentRepositary.getAllStudent();
    }

    @Override
    public Student createStudent(StudentRequest studentRequest) {
      return null;
    }
}
