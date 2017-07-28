package com.example.domain.repository;

import com.example.domain.entity.system.Minion;
import org.intellift.sol.domain.querydsl.repository.QueryDslRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MinionRepository extends QueryDslRepository<Minion, String> {
}
