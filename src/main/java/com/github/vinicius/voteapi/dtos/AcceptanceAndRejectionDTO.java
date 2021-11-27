package com.github.vinicius.voteapi.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.vinicius.voteapi.utils.NumberUtils;

public class AcceptanceAndRejectionDTO {

  private long positiveVotingIntentions;
  private long negativeVotingIntentions;

  public long getPositiveVotingIntentions() {
    return positiveVotingIntentions;
  }

  public long getNegativeVotingIntentions() {
    return negativeVotingIntentions;
  }

  public double getAcceptance() {
    return this.getPercentageFromTotal(positiveVotingIntentions);
  }

  public double getRejection() {
    return this.getPercentageFromTotal(negativeVotingIntentions);
  }

  @JsonIgnore
  private double getPercentageFromTotal(long quantity) {
    double percentage = this.getTotalVotingIntentions() > 0
      ? ((double) quantity / this.getTotalVotingIntentions()) * 100
      : 0;
    return NumberUtils.round(percentage, 2);
  }

  private long getTotalVotingIntentions() {
    return this.negativeVotingIntentions + this.positiveVotingIntentions;
  }

  public void setPositiveVotingIntentionsQuantity(long votingIntentions) {
    this.positiveVotingIntentions = votingIntentions;
  }

  public void setNegativeVotingIntentionsQuantity(long votingIntentions) {
    this.negativeVotingIntentions = votingIntentions;
  }

}
