package com.github.vinicius.voteapi.services.impl;

import com.github.vinicius.voteapi.dtos.AcceptanceAndRejectionByAgeGroupDTO;
import com.github.vinicius.voteapi.dtos.AcceptanceAndRejectionByGenderDTO;
import com.github.vinicius.voteapi.dtos.AcceptanceAndRejectionBySalaryRangeDTO;
import com.github.vinicius.voteapi.dtos.BigDecimalRangeDTO;
import com.github.vinicius.voteapi.dtos.IntegerRangeDTO;
import com.github.vinicius.voteapi.enums.GenderEnum;
import com.github.vinicius.voteapi.repositories.VotingIntentionRepository;
import com.github.vinicius.voteapi.services.AcceptanceAndRejectionService;
import org.springframework.stereotype.Service;

@Service
public class AcceptanceAndRejectionServiceImpl implements AcceptanceAndRejectionService {

  private final VotingIntentionRepository votingIntentionRepository;

  public AcceptanceAndRejectionServiceImpl(VotingIntentionRepository votingIntentionRepository) {
    this.votingIntentionRepository = votingIntentionRepository;
  }

  @Override
  public AcceptanceAndRejectionByAgeGroupDTO getByAgeGroup(IntegerRangeDTO ageGroup) {
    return new AcceptanceAndRejectionByAgeGroupDTO()
      .setAgeGroup(ageGroup)
      .setAcceptanceAndRejection(this.votingIntentionRepository.getAcceptanceAndRejectionByAgeGroup(ageGroup));
  }

  @Override
  public AcceptanceAndRejectionByGenderDTO getByGender(GenderEnum gender) {
    return new AcceptanceAndRejectionByGenderDTO()
      .setGender(gender)
      .setAcceptanceAndRejection(this.votingIntentionRepository.getAcceptanceAndRejectionByGender(gender));
  }

  @Override
  public AcceptanceAndRejectionBySalaryRangeDTO getBySalaryRange(BigDecimalRangeDTO salaryRange) {
    return new AcceptanceAndRejectionBySalaryRangeDTO()
      .setSalaryRange(salaryRange)
      .setAcceptanceAndRejection(this.votingIntentionRepository.getAcceptanceAndRejectionBySalaryRange(salaryRange));
  }

}
