package com.example.demo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionTranslator {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<RestResponse> invalid(BadRequestException ex) {
        return new ResponseEntity<>(ResponseUtil.getBadRequestResponse(ex.getMessage(),
                ex.getDetail()), HttpStatus.BAD_REQUEST);
    }

}
