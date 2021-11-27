package com.github.vinicius.voteapi.controllers;

import com.github.vinicius.voteapi.dtos.AcceptanceAndRejectionByAgeGroupDTO;
import com.github.vinicius.voteapi.dtos.AcceptanceAndRejectionByGenderDTO;
import com.github.vinicius.voteapi.dtos.AcceptanceAndRejectionBySalaryRangeDTO;
import com.github.vinicius.voteapi.dtos.BigDecimalRangeDTO;
import com.github.vinicius.voteapi.dtos.IntegerRangeDTO;
import com.github.vinicius.voteapi.enums.GenderEnum;
import com.github.vinicius.voteapi.services.AcceptanceAndRejectionService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@CrossOrigin("*")
@RestController
@RequestMapping("acceptance-rejection")
public class AcceptanceAndRejectionController {

  private final AcceptanceAndRejectionService service;

  public AcceptanceAndRejectionController(AcceptanceAndRejectionService service) {
    this.service = service;
  }

  @GetMapping("by-age")
  public AcceptanceAndRejectionByAgeGroupDTO getByAgeGroup(@Valid IntegerRangeDTO ageGroup) {
    return this.service.getByAgeGroup(ageGroup);
  }

  @GetMapping("by-gender")
  public AcceptanceAndRejectionByGenderDTO getByAgeGroup(@Valid @NotEmpty String gender) {
    GenderEnum genderEnum = GenderEnum.getByGenderLetter(gender);
    return this.service.getByGender(genderEnum);
  }

  @GetMapping("by-salary-range")
  public AcceptanceAndRejectionBySalaryRangeDTO getBySalaryRange(@Valid BigDecimalRangeDTO salaryRange) {
    return this.service.getBySalaryRange(salaryRange);
  }

}
