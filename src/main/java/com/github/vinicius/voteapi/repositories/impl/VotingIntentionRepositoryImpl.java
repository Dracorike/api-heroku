package com.github.vinicius.voteapi.repositories.impl;

import com.github.vinicius.voteapi.dtos.AcceptanceAndRejectionDTO;
import com.github.vinicius.voteapi.dtos.AcceptanceAndRejectionFilterDTO;
import com.github.vinicius.voteapi.dtos.BigDecimalRangeDTO;
import com.github.vinicius.voteapi.dtos.IntegerRangeDTO;
import com.github.vinicius.voteapi.enums.GenderEnum;
import com.github.vinicius.voteapi.repositories.custom.VotingIntentionRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@Repository
public class VotingIntentionRepositoryImpl implements VotingIntentionRepositoryCustom {

  private final EntityManager entityManager;

  public VotingIntentionRepositoryImpl(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public AcceptanceAndRejectionDTO getAcceptanceAndRejectionByAgeGroup(IntegerRangeDTO ageGroup) {
    AcceptanceAndRejectionFilterDTO filter = new AcceptanceAndRejectionFilterDTO().setAgeGroup(ageGroup);
    return this.getAcceptanceAndRejection(filter);
  }

  @Override
  public AcceptanceAndRejectionDTO getAcceptanceAndRejectionByGender(GenderEnum gender) {
    AcceptanceAndRejectionFilterDTO filter = new AcceptanceAndRejectionFilterDTO().setGender(gender);
    return this.getAcceptanceAndRejection(filter);
  }

  @Override
  public AcceptanceAndRejectionDTO getAcceptanceAndRejectionBySalaryRange(BigDecimalRangeDTO salaryRange) {
    AcceptanceAndRejectionFilterDTO filter = new AcceptanceAndRejectionFilterDTO().setSalaryRange(salaryRange);
    return this.getAcceptanceAndRejection(filter);
  }

  private AcceptanceAndRejectionDTO getAcceptanceAndRejection(AcceptanceAndRejectionFilterDTO filter) {
    Map<String, Object> parameters = new HashMap<>();

    StringBuilder jpql = new StringBuilder()
      .append("SELECT vi.voteForJohn AS voteForJohn, COUNT(vi) AS quantity ")
      .append("FROM VotingIntention vi ")
      .append("WHERE 1 = 1 ");

    if (Objects.nonNull(filter.getAgeGroup())) {
      jpql.append("AND vi.age BETWEEN :ageFrom AND :ageTo ");
      parameters.put("ageFrom", filter.getAgeGroup().getFrom());
      parameters.put("ageTo", filter.getAgeGroup().getTo());
    }

    if (Objects.nonNull(filter.getSalaryRange())) {
      jpql.append("AND vi.monthlyIncome BETWEEN :monthlyIncomeFrom AND :monthlyIncomeTo ");
      parameters.put("monthlyIncomeFrom", filter.getSalaryRange().getFrom());
      parameters.put("monthlyIncomeTo", filter.getSalaryRange().getTo());
    }

    if (Objects.nonNull(filter.getGender())) {
      jpql.append("AND vi.gender = :gender ");
      parameters.put("gender", filter.getGender());
    }

    jpql.append("GROUP BY vi.voteForJohn");

    TypedQuery<Tuple> query = entityManager.createQuery(jpql.toString(), Tuple.class);
    parameters.forEach(query::setParameter);

    Function<Tuple, Boolean> getVoteForJohn = tuple -> tuple.get("voteForJohn", Boolean.class);
    Function<Tuple, Long> getQuantity = tuple -> tuple.get("quantity", Long.class);

    AcceptanceAndRejectionDTO acceptanceAndRejectionDTO = new AcceptanceAndRejectionDTO();
    query
      .getResultList()
      .stream()
      .collect(Collectors.toMap(getVoteForJohn, getQuantity))
      .forEach((voteForJohn, quantity) -> {
        if (voteForJohn) {
          acceptanceAndRejectionDTO.setPositiveVotingIntentionsQuantity(quantity);
        } else {
          acceptanceAndRejectionDTO.setNegativeVotingIntentionsQuantity(quantity);
        }
      });

    return acceptanceAndRejectionDTO;
  }

}
