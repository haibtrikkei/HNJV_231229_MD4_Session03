package org.example.demo_custom_validattion.advice;

import org.example.demo_custom_validattion.model.dto.response.DataError;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CustomValidateAdvice {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public DataError<Map<String,String>> handleMethodArgument(MethodArgumentNotValidException ex){
        Map<String,String> map = new HashMap<>();
        for (int i = 0; i < ex.getAllErrors().size(); i++) {
            ObjectError error = ex.getAllErrors().get(i);
            map.put("error "+(i+1), error.getDefaultMessage());
        }
        return new DataError<>(map, HttpStatus.BAD_REQUEST);
    }
}
