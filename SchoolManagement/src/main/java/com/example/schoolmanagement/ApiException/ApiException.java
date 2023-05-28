package com.example.schoolmanagement.ApiException;

import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.ErrorResponse;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ConcurrentModificationException;
import java.util.concurrent.ExecutionException;


public class ApiException {



        @ExceptionHandler(Exception.class)
        public ResponseEntity<ErrorResponse> handelExceptionApiResponse(ExecutionException e) {
            ErrorResponse error = new ErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(error);
        }

        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<ErrorResponse> MethodArgumentNotValidException(MethodArgumentNotValidException ex) {
            ErrorResponse error = new ErrorResponse(ex.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }

        @ExceptionHandler(value = ConcurrentModificationException.class)
        public ResponseEntity<ErrorResponse> ConstraintViolationException(ConstraintViolationException e) {
            ErrorResponse error = new ErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }

        @ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
        public ResponseEntity<ErrorResponse> SQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException e) {
            ErrorResponse error = new ErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }

        @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
        public ResponseEntity<ErrorResponse> HttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
            ErrorResponse error = new ErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }


        @ExceptionHandler(value = InvalidDataAccessResourceUsageException.class)
        public ResponseEntity<ErrorResponse> InvalidDataAccessResourceUsageException(InvalidDataAccessResourceUsageException e) {
            ErrorResponse error = new ErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }

        @ExceptionHandler(value = HttpMessageNotReadableException.class)
        public ResponseEntity<ErrorResponse> HttpMessageNotReadableException(HttpMessageNotReadableException e) {
            ErrorResponse error = new ErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);

    }
}