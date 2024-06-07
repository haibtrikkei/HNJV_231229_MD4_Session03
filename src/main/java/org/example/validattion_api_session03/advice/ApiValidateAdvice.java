package org.example.validattion_api_session03.advice;

import jakarta.validation.UnexpectedTypeException;
import org.example.validattion_api_session03.model.dto.response.DataError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class ApiValidateAdvice {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public DataError<Map<String,String>> handleMethodErr(MethodArgumentNotValidException ex){
        Map<String,String> map = new HashMap<>();
        ex.getFieldErrors().forEach(fieldError -> map.put(fieldError.getField(),fieldError.getDefaultMessage()));
        return new DataError<>("error",map, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public DataError<String> handleNotSuch(NoSuchElementException e){
        return new DataError<>("error",e.getLocalizedMessage(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnexpectedTypeException.class)
    public DataError<?> handUnexpected(UnexpectedTypeException e){
        return new DataError<>("error",e.getLocalizedMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
