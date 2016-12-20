package com.example.service;

import com.example.domain.entity.system.Banana;
import com.example.domain.repository.BananaRepository;
import org.intellift.sol.domain.querydsl.repository.QueryDslRepository;
import org.intellift.sol.service.querydsl.QueryDslCrudService;
import org.springframework.stereotype.Service;

/**
 * @author Chrisostomos Bakouras.
 */
@Service
public class BananaServiceImpl implements QueryDslCrudService<Banana, String> {

    private final BananaRepository bananaRepository;

    public BananaServiceImpl(BananaRepository bananaRepository) {
        this.bananaRepository = bananaRepository;
    }

    @Override
    public QueryDslRepository<Banana, String> getRepository() {
        return bananaRepository;
    }
}
