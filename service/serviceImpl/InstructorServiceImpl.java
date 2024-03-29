package com.example.chea_srey_khuoch_pp_spring_homework002.service.serviceImpl;

import com.example.chea_srey_khuoch_pp_spring_homework002.model.Instructor;
import com.example.chea_srey_khuoch_pp_spring_homework002.model.InstructorRequest;
import com.example.chea_srey_khuoch_pp_spring_homework002.repositary.InstructorRepositary;
import com.example.chea_srey_khuoch_pp_spring_homework002.service.InstructorService;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepositary instructorRepositary;

    public InstructorServiceImpl(InstructorRepositary instructorRepositary) {
        this.instructorRepositary = instructorRepositary;
    }

    @Override
    public List<Instructor> getAllInstructor() {
        return instructorRepositary.getAllinstructors();
    }

    @Override
    public Instructor getValueById(Integer id) throws NotFoundException {
        if(instructorRepositary.findInstructorById(id)==null){
            throw new NotFoundException("Instructor doesn't exist");
        }

        return instructorRepositary.findInstructorById(id);
    }

    @Override
    public Instructor insertInstructor(InstructorRequest instructorRequest) {
        System.out.println(instructorRequest.getInstructorName() == null);
        return instructorRepositary.insertInstructor(instructorRequest);
    }

    @Override
    public void updateInstructor(Integer id, InstructorRequest instructorRequest) {
      instructorRepositary.updateInstructor(id, instructorRequest);
    }

    @Override
    public void deleteInstructor(Integer id) {
       instructorRepositary.deleteInstructor(id);
    }
}
