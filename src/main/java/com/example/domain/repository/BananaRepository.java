package com.example.domain.repository;

import com.example.domain.entity.system.Banana;
import org.intellift.sol.domain.querydsl.repository.QueryDslRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Chrisostomos Bakouras.
 */
@Repository
public interface BananaRepository extends QueryDslRepository<Banana, String> {
}
