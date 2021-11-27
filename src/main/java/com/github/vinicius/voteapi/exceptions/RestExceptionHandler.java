package com.github.vinicius.voteapi.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class RestExceptionHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ProblemDetails> handleMethodArgumentNotValid(MethodArgumentNotValidException exception) {
    List<ProblemDetails.Error> problemErrors = exception.getBindingResult().getAllErrors().stream()
      .map(error -> new ProblemDetails.Error()
        .setName(error instanceof FieldError ? ((FieldError) error).getField() : error.getObjectName())
        .setMessage(error.getDefaultMessage())
      ).collect(Collectors.toList());

    String defaultMessage = "Some fields are invalid!";
    ProblemDetails problem = new ProblemDetails()
      .setMessage(defaultMessage)
      .setDetail(defaultMessage)
      .setStatus(HttpStatus.BAD_REQUEST)
      .setErrors(problemErrors);

    return ResponseEntity.badRequest()
      .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PROBLEM_JSON_VALUE)
      .body(problem);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ProblemDetails> handleException(Exception exception) {
    exception.printStackTrace();
    ProblemDetails problem = new ProblemDetails()
      .setMessage("Unknown error")
      .setDetail(exception.getLocalizedMessage())
      .setStatus(HttpStatus.INTERNAL_SERVER_ERROR);

    return ResponseEntity.internalServerError()
      .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PROBLEM_JSON_VALUE)
      .body(problem);
  }

}
