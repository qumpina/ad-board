package com.boardmaster.bulletinboard.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {


  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException exception){
    Map<String, String> response = Map.of("error", String.format("%s not found with id: %d",exception.getResourceName(),exception.getId()));

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<?> handleArgumentNotValidException(MethodArgumentNotValidException exception){
    Map<String,String> errors = new HashMap<>();
    exception.getBindingResult()
            .getFieldErrors()
        .forEach(error -> errors.put(error.getField(),error.getDefaultMessage()));
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
  }
  @ExceptionHandler(Exception.class)
  public ResponseEntity<?> handleException(Exception exception){
    Map<String, String> response=Map.of("error", "Internal server error");
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
  }

}
