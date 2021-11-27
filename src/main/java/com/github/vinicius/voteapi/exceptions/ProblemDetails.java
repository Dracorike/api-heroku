package com.github.vinicius.voteapi.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProblemDetails {

  private int status;
  private String type = "error";
  private String title;
  private String message;
  private String detail;
  private List<Error> errors;

  public int getStatus() {
    return status;
  }
  public ProblemDetails setStatus(HttpStatus status) {
    this.status = status.value();
    return this;
  }

  public String getType() {
    return type;
  }
  public ProblemDetails setType(String type) {
    this.type = type;
    return this;
  }

  public String getTitle() {
    return title;
  }
  public ProblemDetails setTitle(String title) {
    this.title = title;
    return this;
  }

  public String getMessage() {
    return message;
  }
  public ProblemDetails setMessage(String message) {
    this.message = message;
    return this;
  }

  public String getDetail() {
    return detail;
  }
  public ProblemDetails setDetail(String detail) {
    this.detail = detail;
    return this;
  }

  public List<Error> getErrors() {
    return errors;
  }
  public ProblemDetails setErrors(List<Error> errors) {
    this.errors = errors;
    return this;
  }

  public OffsetDateTime getTimestamp() {
    return OffsetDateTime.now();
  }

  public ProblemDetails addError(Error error) {
    if (Objects.isNull(this.errors)) {
      this.errors = new ArrayList<>();
    }
    this.errors.add(error);
    return this;
  }

  public static class Error {
    private String name;
    private String message;

    public String getName() {
      return name;
    }
    public Error setName(String name) {
      this.name = name;
      return this;
    }

    public String getMessage() {
      return message;
    }
    public Error setMessage(String message) {
      this.message = message;
      return this;
    }
  }

}