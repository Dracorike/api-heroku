package com.github.vinicius.voteapi.dtos;

import com.github.vinicius.voteapi.enums.GenderEnum;

public class AcceptanceAndRejectionFilterDTO {

  private IntegerRangeDTO ageGroup;
  private BigDecimalRangeDTO salaryRange;
  private GenderEnum gender;

  public IntegerRangeDTO getAgeGroup() {
    return ageGroup;
  }
  public AcceptanceAndRejectionFilterDTO setAgeGroup(IntegerRangeDTO ageGroup) {
    this.ageGroup = ageGroup;
    return this;
  }

  public BigDecimalRangeDTO getSalaryRange() {
    return salaryRange;
  }
  public AcceptanceAndRejectionFilterDTO setSalaryRange(BigDecimalRangeDTO salaryRange) {
    this.salaryRange = salaryRange;
    return this;
  }

  public GenderEnum getGender() {
    return gender;
  }
  public AcceptanceAndRejectionFilterDTO setGender(GenderEnum gender) {
    this.gender = gender;
    return this;
  }

}
