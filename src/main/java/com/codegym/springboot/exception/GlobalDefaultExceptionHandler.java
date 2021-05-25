package com.codegym.springboot.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;

//@RestControllerAdvice
public class GlobalDefaultExceptionHandler {

//    @ExceptionHandler(EntityNotFoundException.class)
//    public ResponseEntity<Void> handleEntityNotFoundException() {
//        log.info("Entity Not found");
//        return ResponseEntity.notFound().build();
//    }
}
