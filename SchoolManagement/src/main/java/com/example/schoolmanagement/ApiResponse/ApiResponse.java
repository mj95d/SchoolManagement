package com.example.schoolmanagement.ApiResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


  @Data
  @NoArgsConstructor
  @AllArgsConstructor


public class ApiResponse {

        String message;
        Integer status;
    }