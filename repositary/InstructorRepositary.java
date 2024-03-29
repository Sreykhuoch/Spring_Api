package com.example.chea_srey_khuoch_pp_spring_homework002.repositary;

import com.example.chea_srey_khuoch_pp_spring_homework002.model.Instructor;
import com.example.chea_srey_khuoch_pp_spring_homework002.model.InstructorRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface InstructorRepositary {

    //to select from database , we use :

    @Select("""
                  SELECT * FROM instructors
            """)


    @Results(id = "instructorMapping", value = {
            @Result(property = "instructorName", column = "instructor_name"),
            @Result(property = "id", column = "instructor_id")
    })
    List<Instructor> getAllinstructors();

    @Select("""
                 select * from instructors where instructor_id = #{id};
            """)
    @ResultMap("instructorMapping")
    Instructor findInstructorById(@Param("id") Integer id);

    @Select("""
                  Insert into instructors(instructor_name, email)
                  VALUES ( #{instructor.instructorName}, #{instructor.email})
                  RETURNING *
            """)
    @ResultMap("instructorMapping")
    Instructor insertInstructor(@Param("instructor") InstructorRequest instructorRequest);

    @Update("""
                 UPDATE instructors
                 set instructor_name = #{instructor.instructorName},
                     email=#{instructor.email} where instructor_id = #{id};
                 
            """)
    void updateInstructor(Integer id, @Param("instructor") InstructorRequest instructorRequest);

    @Delete("""
            delete from instructors where instructor_id = #{id}
            """)
    void deleteInstructor(Integer id);

}

