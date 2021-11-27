package com.github.vinicius.voteapi.controllers;

import com.github.vinicius.voteapi.dtos.VotingIntentionDTO;
import com.github.vinicius.voteapi.models.VotingIntention;
import com.github.vinicius.voteapi.services.VotingIntentionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("voting-intentions")
public class VotingIntentionController {

  private final VotingIntentionService service;

  public VotingIntentionController(VotingIntentionService service) {
    this.service = service;
  }

  @PostMapping
  public ResponseEntity<VotingIntentionDTO> save(@Valid @RequestBody VotingIntentionDTO votingIntentionDTO) {
    VotingIntention transientVotingIntention = votingIntentionDTO.toEntity();
    VotingIntention savedVotingIntention = this.service.save(transientVotingIntention);
    return ResponseEntity.status(HttpStatus.CREATED).body(new VotingIntentionDTO(savedVotingIntention));
  }

}
