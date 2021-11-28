package com.github.vinicius.voteapi.controllers;

import com.github.vinicius.voteapi.dtos.AcceptanceAndRejectionByAgeGroupDTO;
import com.github.vinicius.voteapi.dtos.AcceptanceAndRejectionByGenderDTO;
import com.github.vinicius.voteapi.dtos.AcceptanceAndRejectionBySalaryRangeDTO;
import com.github.vinicius.voteapi.dtos.BigDecimalRangeDTO;
import com.github.vinicius.voteapi.dtos.IntegerRangeDTO;
import com.github.vinicius.voteapi.enums.GenderEnum;
import com.github.vinicius.voteapi.services.AcceptanceAndRejectionService;
import org.springframework.web.bind.annotation.*;

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
  public AcceptanceAndRejectionByAgeGroupDTO getByAgeGroup(@Valid @RequestBody IntegerRangeDTO ageGroup) {
    return this.service.getByAgeGroup(ageGroup);
  }

  @GetMapping("by-gender/{gender}")
  public AcceptanceAndRejectionByGenderDTO getByAgeGroup(@PathVariable @Valid @NotEmpty String gender) {
    GenderEnum genderEnum = GenderEnum.getByGenderLetter(gender);
    return this.service.getByGender(genderEnum);
  }

  @GetMapping("by-salary-range")
  public AcceptanceAndRejectionBySalaryRangeDTO getBySalaryRange(@Valid @RequestBody BigDecimalRangeDTO salaryRange) {
    return this.service.getBySalaryRange(salaryRange);
  }

}
