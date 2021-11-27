package com.github.vinicius.voteapi.models;

import com.github.vinicius.voteapi.enums.GenderEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "voting_intentions")
public class VotingIntention {

  private Long id;
  private String name;
  private Integer age;
  private GenderEnum gender;
  private String profession;
  private BigDecimal monthlyIncome;
  private Boolean voteForJohn;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long getId() {
    return id;
  }
  public VotingIntention setId(Long id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }
  public VotingIntention setName(String name) {
    this.name = name;
    return this;
  }

  public Integer getAge() {
    return age;
  }
  public VotingIntention setAge(Integer age) {
    this.age = age;
    return this;
  }

  @Enumerated(EnumType.STRING)
  public GenderEnum getGender() {
    return gender;
  }
  public VotingIntention setGender(GenderEnum gender) {
    this.gender = gender;
    return this;
  }

  public String getProfession() {
    return profession;
  }
  public VotingIntention setProfession(String profession) {
    this.profession = profession;
    return this;
  }

  @Column(name = "monthly_income")
  public BigDecimal getMonthlyIncome() {
    return monthlyIncome;
  }
  public VotingIntention setMonthlyIncome(BigDecimal monthlyIncome) {
    this.monthlyIncome = monthlyIncome;
    return this;
  }

  @Column(name = "vote_for_john")
  public Boolean getVoteForJohn() {
    return voteForJohn;
  }
  public VotingIntention setVoteForJohn(Boolean voteForJohn) {
    this.voteForJohn = voteForJohn;
    return this;
  }

}
