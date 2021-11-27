package com.github.vinicius.voteapi.dtos;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class BigDecimalRangeDTO {

  private BigDecimal from;
  private BigDecimal to;

  @NotNull
  @DecimalMin("0.0")
  public BigDecimal getFrom() {
    return from;
  }
  public void setFrom(BigDecimal from) {
    this.from = from;
  }

  @NotNull
  @DecimalMin("0.0")
  public BigDecimal getTo() {
    return to;
  }
  public void setTo(BigDecimal to) {
    this.to = to;
  }

}
