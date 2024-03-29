package com.example.chea_srey_khuoch_pp_spring_homework002.repositary;

import com.example.chea_srey_khuoch_pp_spring_homework002.model.Course;
import com.example.chea_srey_khuoch_pp_spring_homework002.model.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface StudentRepositary {
        @Select("""
       SELECT * FROM students
    """)

        @Results(id = "studentMapping" , value = {
                @Result(property = "studentId", column = "student_id"),
                @Result(property = "studentName", column = "student_name"),
                @Result(property = "email", column = "student_email"),
                @Result(property = "phoneNumber", column = "phone_number"),
                @Result(property = "instructor", column = "instructor_id",
                one = @One(select = "com.example.chea_srey_khuoch_pp_spring_homework002.repositary.InstructorRepositary.findInstructorById")
                ),
                @Result(property = "courseId", column = "course_id",
                many = @Many(select = "com.example.chea_srey_khuoch_pp_spring_homework002.repositary.CourseRepositary.getAllCourseByCourseId"))

        })
    List<Student> getAllStudent();




    }
