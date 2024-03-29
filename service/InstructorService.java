package com.example.chea_srey_khuoch_pp_spring_homework002.service;

import com.example.chea_srey_khuoch_pp_spring_homework002.model.Instructor;
import com.example.chea_srey_khuoch_pp_spring_homework002.model.InstructorRequest;
import org.apache.ibatis.javassist.NotFoundException;

import java.util.List;

public interface InstructorService {

    List<Instructor> getAllInstructor();

    Instructor getValueById(Integer id) throws NotFoundException;

    //insert
    Instructor insertInstructor(InstructorRequest instructorRequest);

    //update
    void updateInstructor(Integer id, InstructorRequest instructorRequest);

    //delete
    void deleteInstructor(Integer id);

}
