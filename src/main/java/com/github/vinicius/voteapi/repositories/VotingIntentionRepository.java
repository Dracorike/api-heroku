package com.github.vinicius.voteapi.repositories;

import com.github.vinicius.voteapi.models.VotingIntention;
import com.github.vinicius.voteapi.repositories.custom.VotingIntentionRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotingIntentionRepository extends JpaRepository<VotingIntention, Long>,
  VotingIntentionRepositoryCustom {

}
