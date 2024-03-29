package com.example.chea_srey_khuoch_pp_spring_homework002.controller;

import com.example.chea_srey_khuoch_pp_spring_homework002.model.ApiResponse;
import com.example.chea_srey_khuoch_pp_spring_homework002.model.Instructor;
import com.example.chea_srey_khuoch_pp_spring_homework002.model.InstructorRequest;
import com.example.chea_srey_khuoch_pp_spring_homework002.service.InstructorService;

import io.swagger.v3.oas.annotations.Operation;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class InstructorController {
   private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }
    // get all data from database

    @GetMapping("instructors")
    @Operation(summary = "Get all instructor")
    public ResponseEntity<?> getAllInstructor(){
        List<Instructor> instructorList = instructorService.getAllInstructor();
        ApiResponse<?> response = new ApiResponse<>(
                "Successfully fetched author",
                HttpStatus.OK,
                200,
                instructorList
        );
        return ResponseEntity.ok(response);
    }


    // find instructor by id

    @GetMapping("{id}")
    @Operation(summary = "Find instructor by id")
    public ResponseEntity<?> getInstructorById(@PathVariable Integer id) throws NotFoundException{
        Instructor instructor = instructorService.getValueById(id);
        ApiResponse<Instructor> response = new ApiResponse<>(
                "Successfully found instructor by id",
                HttpStatus.OK,
                200,
                instructor
        );
        return ResponseEntity.ok(response);
    }


    // insert into database
    @PostMapping
    @Operation(summary = "Create Instructor")
    public ResponseEntity<?> insertInstructor(@RequestBody InstructorRequest instructorRequest){
        System.out.println("This is instructor In controller : "+instructorRequest.toString());
      Instructor instructor=  instructorService.insertInstructor(instructorRequest);
        ApiResponse<Instructor> response = new ApiResponse<>(
                "Successfully Updated instructor",
                HttpStatus.OK,
                200,
                instructor
        );
        return ResponseEntity.ok(response);
    }


    //update
    @PutMapping({"{id}"})
     @Operation(summary = "update instructor by id")
    public ResponseEntity<?> updateInstructor(@PathVariable Integer id, @RequestBody InstructorRequest instructorRequest ){
        instructorService.updateInstructor(id, instructorRequest);
        ApiResponse<Instructor> response = new ApiResponse<>(
                "Successfully updated instructor",
                HttpStatus.OK,
                200,
                null
        );
        return ResponseEntity.ok(response);
    }



    //delete

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete instructor by id ")
    public ResponseEntity<?> deleteInstructor(@PathVariable Integer id) throws NotFoundException {
        instructorService.deleteInstructor(id);
        ApiResponse<Instructor> response = new ApiResponse<>(
                "Successfully deleted instructor",
                HttpStatus.OK,
                200,
                null
        );
        return ResponseEntity.ok(response);
    }







}
