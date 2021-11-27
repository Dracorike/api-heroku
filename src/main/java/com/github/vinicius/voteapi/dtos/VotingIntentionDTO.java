package com.github.vinicius.voteapi.dtos;

import com.github.vinicius.voteapi.enums.GenderEnum;
import com.github.vinicius.voteapi.models.VotingIntention;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class VotingIntentionDTO {

  private String name;
  private Integer age;
  private GenderEnum gender;
  private String profession;
  private BigDecimal monthlyIncome;
  private Boolean voteForJohn;

  public VotingIntentionDTO() { }

  public VotingIntentionDTO(VotingIntention votingIntention) {
    this.name = votingIntention.getName();
    this.age = votingIntention.getAge();
    this.gender = votingIntention.getGender();
    this.profession = votingIntention.getProfession();
    this.monthlyIncome = votingIntention.getMonthlyIncome();
    this.voteForJohn = votingIntention.getVoteForJohn();
  }

  @NotEmpty
  public String getName() {
    return name;
  }
  public VotingIntentionDTO setName(String name) {
    this.name = name;
    return this;
  }

  @Positive
  @Max(value = 100)
  public Integer getAge() {
    return age;
  }
  public VotingIntentionDTO setAge(Integer age) {
    this.age = age;
    return this;
  }

  @NotNull
  public GenderEnum getGender() {
    return gender;
  }
  public VotingIntentionDTO setGender(GenderEnum gender) {
    this.gender = gender;
    return this;
  }

  @NotEmpty
  public String getProfession() {
    return profession;
  }
  public VotingIntentionDTO setProfession(String profession) {
    this.profession = profession;
    return this;
  }

  @DecimalMin(value = "0.0")
  public BigDecimal getMonthlyIncome() {
    return monthlyIncome;
  }
  public VotingIntentionDTO setMonthlyIncome(BigDecimal monthlyIncome) {
    this.monthlyIncome = monthlyIncome;
    return this;
  }

  @NotNull
  public Boolean getVoteForJohn() {
    return voteForJohn;
  }
  public VotingIntentionDTO setVoteForJohn(Boolean voteForJohn) {
    this.voteForJohn = voteForJohn;
    return this;
  }

  public VotingIntention toEntity() {
    return new VotingIntention()
      .setName(name)
      .setAge(age)
      .setGender(gender)
      .setProfession(profession)
      .setMonthlyIncome(monthlyIncome)
      .setVoteForJohn(voteForJohn);
  }

}
