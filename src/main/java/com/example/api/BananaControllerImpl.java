package com.example.api;

import com.example.domain.entity.system.Banana;
import com.example.dto.system.BananaDto;
import com.example.mapper.system.BananaMapper;
import com.example.service.BananaServiceImpl;
import com.querydsl.core.types.Predicate;
import org.intellift.sol.controller.querydsl.api.QueryDslAsymmetricCrudApiController;
import org.intellift.sol.service.querydsl.QueryDslCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Chrisostomos Bakouras.
 */
@RestController
@RequestMapping("/bananas")
public class BananaControllerImpl implements QueryDslAsymmetricCrudApiController<Banana, BananaDto, BananaDto, String> {

    private final BananaServiceImpl bananaService;

    private final BananaMapper bananaMapper;

    @Autowired
    public BananaControllerImpl(BananaServiceImpl bananaService, BananaMapper bananaMapper) {
        this.bananaService = bananaService;
        this.bananaMapper = bananaMapper;
    }

    @Override
    public BananaMapper getMapper() {
        return bananaMapper;
    }

    @Override
    public BananaMapper getReferenceMapper() {
        return getMapper();
    }

    @Override
    public QueryDslCrudService<Banana, String> getService() {
        return bananaService;
    }

    @Override
    public ResponseEntity<Page<BananaDto>> getAll(@QuerydslPredicate(root = Banana.class) Predicate predicate, Pageable pageable) {
        return getAllDefaultImplementation(predicate, pageable);
    }
}
