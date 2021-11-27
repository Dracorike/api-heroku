package com.github.vinicius.voteapi.repositories.custom;

import com.github.vinicius.voteapi.dtos.AcceptanceAndRejectionDTO;
import com.github.vinicius.voteapi.dtos.BigDecimalRangeDTO;
import com.github.vinicius.voteapi.dtos.IntegerRangeDTO;
import com.github.vinicius.voteapi.enums.GenderEnum;

public interface VotingIntentionRepositoryCustom {

  AcceptanceAndRejectionDTO getAcceptanceAndRejectionByAgeGroup(IntegerRangeDTO ageGroup);
  AcceptanceAndRejectionDTO getAcceptanceAndRejectionByGender(GenderEnum gender);
  AcceptanceAndRejectionDTO getAcceptanceAndRejectionBySalaryRange(BigDecimalRangeDTO salaryRange);

}
