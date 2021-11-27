package com.github.vinicius.voteapi.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public enum GenderEnum {

  @JsonProperty("M")
  MALE("M"),
  @JsonProperty("F")
  FEMALE("F");

  private final String letter;

  GenderEnum(String letter) {
    this.letter = letter;
  }

  public static GenderEnum getByGenderLetter(String letter) {
    return Arrays.stream(GenderEnum.values())
      .filter(gender -> gender.letter.equalsIgnoreCase(letter))
      .findFirst()
      .orElseThrow(() -> new IllegalArgumentException(String.format("Unknown gender '%s'", letter)));
  }

}
