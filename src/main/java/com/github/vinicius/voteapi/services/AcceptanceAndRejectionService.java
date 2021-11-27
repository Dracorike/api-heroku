package com.github.vinicius.voteapi.services;

import com.github.vinicius.voteapi.dtos.AcceptanceAndRejectionByAgeGroupDTO;
import com.github.vinicius.voteapi.dtos.AcceptanceAndRejectionByGenderDTO;
import com.github.vinicius.voteapi.dtos.AcceptanceAndRejectionBySalaryRangeDTO;
import com.github.vinicius.voteapi.dtos.BigDecimalRangeDTO;
import com.github.vinicius.voteapi.dtos.IntegerRangeDTO;
import com.github.vinicius.voteapi.enums.GenderEnum;

public interface AcceptanceAndRejectionService {

  AcceptanceAndRejectionByAgeGroupDTO getByAgeGroup(IntegerRangeDTO ageGroup);
  AcceptanceAndRejectionByGenderDTO getByGender(GenderEnum gender);
  AcceptanceAndRejectionBySalaryRangeDTO getBySalaryRange(BigDecimalRangeDTO salaryRange);

}
