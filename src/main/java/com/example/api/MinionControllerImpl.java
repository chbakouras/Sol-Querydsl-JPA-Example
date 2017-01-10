package com.example.api;

import com.example.domain.entity.system.Minion;
import com.example.dto.system.MinionDto;
import com.example.mapper.system.MinionMapper;
import com.example.service.MinionServiceImpl;
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
@RequestMapping("/minions")
public class MinionControllerImpl implements QueryDslAsymmetricCrudApiController<Minion, MinionDto, MinionDto, String> {

    private final MinionServiceImpl minionService;

    private final MinionMapper minionMapper;

    @Autowired
    public MinionControllerImpl(MinionServiceImpl minionService, MinionMapper minionMapper) {
        this.minionService = minionService;
        this.minionMapper = minionMapper;
    }

    @Override
    public MinionMapper getMapper() {
        return minionMapper;
    }

    @Override
    public MinionMapper getReferenceMapper() {
        return minionMapper;
    }

    @Override
    public QueryDslCrudService<Minion, String> getService() {
        return minionService;
    }

    @Override
    public ResponseEntity<Page<MinionDto>> getAll(@QuerydslPredicate(root = Minion.class) Predicate predicate, Pageable pageable) {
        return getAllDefaultImplementation(predicate, pageable);
    }
}
