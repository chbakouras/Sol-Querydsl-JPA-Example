package com.example.mapper.system;

import com.example.domain.entity.system.Minion;
import com.example.dto.system.MinionDto;
import org.intellift.sol.mapper.PageMapper;
import org.mapstruct.Mapper;

@Mapper(uses = BananaMapper.class)
public interface MinionMapper extends PageMapper<Minion, MinionDto> {
}
