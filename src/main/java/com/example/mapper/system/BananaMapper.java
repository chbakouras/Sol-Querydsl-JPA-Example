package com.example.mapper.system;

import com.example.domain.entity.system.Banana;
import com.example.dto.system.BananaDto;
import com.example.mapper.ReferenceMapper;
import org.intellift.sol.mapper.PageMapper;
import org.mapstruct.Mapper;

@Mapper(uses = ReferenceMapper.class)
public interface BananaMapper extends PageMapper<Banana, BananaDto> {
}
