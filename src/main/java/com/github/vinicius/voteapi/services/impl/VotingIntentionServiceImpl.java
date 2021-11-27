package com.github.vinicius.voteapi.services.impl;

import com.github.vinicius.voteapi.models.VotingIntention;
import com.github.vinicius.voteapi.repositories.VotingIntentionRepository;
import com.github.vinicius.voteapi.services.VotingIntentionService;
import org.springframework.stereotype.Service;

@Service
public class VotingIntentionServiceImpl implements VotingIntentionService {

  private final VotingIntentionRepository repository;

  public VotingIntentionServiceImpl(VotingIntentionRepository repository) {
    this.repository = repository;
  }

  @Override
  public VotingIntention save(VotingIntention votingIntention) {
    return this.repository.save(votingIntention);
  }

}
