package com.example.service;

import com.example.domain.entity.system.Minion;
import com.example.domain.repository.MinionRepository;
import org.intellift.sol.domain.querydsl.repository.QueryDslRepository;
import org.intellift.sol.service.querydsl.QueryDslCrudService;
import org.springframework.stereotype.Service;

@Service
public class MinionServiceImpl implements QueryDslCrudService<Minion, String> {

    private final MinionRepository minionRepository;

    public MinionServiceImpl(MinionRepository minionRepository) {
        this.minionRepository = minionRepository;
    }

    @Override
    public QueryDslRepository<Minion, String> getRepository() {
        return minionRepository;
    }
}
