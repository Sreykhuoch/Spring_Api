package com.example.chea_srey_khuoch_pp_spring_homework002.repositary;

import com.example.chea_srey_khuoch_pp_spring_homework002.model.Course;
import com.example.chea_srey_khuoch_pp_spring_homework002.model.CourseRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseRepositary {

    @Select("""
               select * from courses
            """)
    @Results(id = "courseMapping", value = {
            @Result(property = "courseId", column = "course_id"),
            @Result(property = "courseName", column = "course_name"),
            @Result(property = "instructor", column = "instructor_id",
                    one = @One(select = "com.example.chea_srey_khuoch_pp_spring_homework002.repositary.InstructorRepositary.findInstructorById"))
    })
    List<Course> getAllCourse();

    @Select("""
            SELECT * FROM courses
            WHERE course_id=#{courseId}
            """)

    @ResultMap("courseMapping")
    Course findByCourseId(Integer id);


    @ResultMap("courseMapping")
    @Select("""
            INSERT INTO courses(course_name, description, instructor_id)
            VALUES (#{course.courseName},#{course.description}, #{course.instructorId})
            RETURNING *;
            """)
    Course insertCourse(@Param("course") CourseRequest courseRequest);


    @Update("""
                    update courses
                    set course_name = #{course.courseName}, description = #{course.description}, instructor_id = #{course.instructorId}
                    where course_id=#{courseId};
            """)
    void updateAuthorById(Integer courseId, @Param("course") CourseRequest courseRequest);


    @ResultMap("courseMapping")
    @Delete("""
            Delete from courses
            where course_id=#{courseId}
            """)
    void deleteById(@Param("courseId") Integer courseId);


    @Select("""
                select c.course_id , c.course_name FROM courses c
        JOIN student_course sc On c.course_id = sc.course_id
        where sc.course_id = #{courseId}
        """)

    @Result(property = "courseName", column = "course_name")
    List<Course> getAllCourseByCourseId(Integer courseId);


}
