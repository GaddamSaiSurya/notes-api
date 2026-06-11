package com.example.notes.exception;

import com.example.notes.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleIdNotFoundException(
            IdNotFoundException ex
    ){
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorResponse);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleNotValidException(
            MethodArgumentNotValidException ex
    ){
        String errorMessage = ex.getBindingResult().getFieldError().getDefaultMessage();

        ErrorResponse errorResponse = new ErrorResponse(errorMessage);

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);
    }
}
