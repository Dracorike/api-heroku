package com.github.vinicius.voteapi.dtos;

public class AcceptanceAndRejectionByAgeGroupDTO {

  private IntegerRangeDTO ageGroup;
  private AcceptanceAndRejectionDTO acceptanceAndRejection;

  public IntegerRangeDTO getAgeGroup() {
    return ageGroup;
  }
  public AcceptanceAndRejectionByAgeGroupDTO setAgeGroup(IntegerRangeDTO ageGroup) {
    this.ageGroup = ageGroup;
    return this;
  }

  public AcceptanceAndRejectionDTO getAcceptanceAndRejection() {
    return acceptanceAndRejection;
  }
  public AcceptanceAndRejectionByAgeGroupDTO setAcceptanceAndRejection(AcceptanceAndRejectionDTO acceptanceAndRejection) {
    this.acceptanceAndRejection = acceptanceAndRejection;
    return this;
  }

}
