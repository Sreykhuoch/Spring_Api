package com.example.chea_srey_khuoch_pp_spring_homework002.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {
    private String message;
    private HttpStatus httpStatus;
    private Integer code;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T payload;
}
