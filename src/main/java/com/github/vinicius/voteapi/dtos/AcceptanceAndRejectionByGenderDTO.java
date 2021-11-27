package com.github.vinicius.voteapi.dtos;

import com.github.vinicius.voteapi.enums.GenderEnum;

public class AcceptanceAndRejectionByGenderDTO {

  private GenderEnum gender;
  private AcceptanceAndRejectionDTO acceptanceAndRejection;

  public GenderEnum getGender() {
    return gender;
  }
  public AcceptanceAndRejectionByGenderDTO setGender(GenderEnum gender) {
    this.gender = gender;
    return this;
  }

  public AcceptanceAndRejectionDTO getAcceptanceAndRejection() {
    return acceptanceAndRejection;
  }
  public AcceptanceAndRejectionByGenderDTO setAcceptanceAndRejection(AcceptanceAndRejectionDTO acceptanceAndRejection) {
    this.acceptanceAndRejection = acceptanceAndRejection;
    return this;
  }

}
