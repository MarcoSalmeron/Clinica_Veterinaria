package com.futuro_digital.demo.Clinica_Veterinaria.Infrastructure.rest.controller;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * Excepciones Gobales en el proyecto
 */
@Slf4j
@RestControllerAdvice
public class ExceptionController {

    // App //

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> entityNotFoundException(EntityNotFoundException ex){
        log.warn("Ejecutando Exception Handler -> "+ex.getClass());
        return new ResponseEntity<>("--{EXEPCION} Entidad no encontrada -> "+ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> runtimeException(RuntimeException ex){
        log.warn("Ejecutando Exception Handler -> "+ex.getClass());
        return new ResponseEntity<>("--{EXEPCION} Valores Atipicos -> "+ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    // Spring //

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<String> missingServletRequestParameterException(MissingServletRequestParameterException ex){
        log.warn("Ejecutando Exception Handler -> "+ex.getClass());
        return new ResponseEntity<>("Falta Parametro Requerido! = "+ex.getParameterName(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex){
        log.warn("Ejecutando Exception Handler -> "+ex.getClass());
        return new ResponseEntity<>("Tipo de Dato Incorrecto! = "+ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
