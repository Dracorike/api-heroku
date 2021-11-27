package com.github.vinicius.voteapi.dtos;

public class AcceptanceAndRejectionBySalaryRangeDTO {

  private BigDecimalRangeDTO salaryRange;
  private AcceptanceAndRejectionDTO acceptanceAndRejection;

  public BigDecimalRangeDTO getSalaryRange() {
    return salaryRange;
  }
  public AcceptanceAndRejectionBySalaryRangeDTO setSalaryRange(BigDecimalRangeDTO salaryRange) {
    this.salaryRange = salaryRange;
    return this;
  }

  public AcceptanceAndRejectionDTO getAcceptanceAndRejection() {
    return acceptanceAndRejection;
  }
  public AcceptanceAndRejectionBySalaryRangeDTO setAcceptanceAndRejection(AcceptanceAndRejectionDTO acceptanceAndRejection) {
    this.acceptanceAndRejection = acceptanceAndRejection;
    return this;
  }

}
