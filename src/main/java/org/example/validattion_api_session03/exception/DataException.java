package org.example.validattion_api_session03.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DataException extends Exception{
    private String fieldError;
    public DataException(String fieldError, String message) {
        super(message);
    }
}
