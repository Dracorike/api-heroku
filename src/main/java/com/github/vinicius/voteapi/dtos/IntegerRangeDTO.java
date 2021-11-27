package com.github.vinicius.voteapi.dtos;

import javax.validation.constraints.PositiveOrZero;

public class IntegerRangeDTO {

  private int from;
  private int to;

  @PositiveOrZero
  public int getFrom() {
    return from;
  }
  public void setFrom(int from) {
    this.from = from;
  }

  @PositiveOrZero
  public int getTo() {
    return to;
  }
  public void setTo(int to) {
    this.to = to;
  }

}
