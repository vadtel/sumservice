package org.vadtel.sumservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.vadtel.sumservice.dao.MapRepository;
import org.vadtel.sumservice.dto.MapDto;
import org.vadtel.sumservice.dto.SumTwoNumberDto;
import org.vadtel.sumservice.dto.mapper.MapMapper;
import org.vadtel.sumservice.entity.MapEntity;
import org.vadtel.sumservice.service.MapService;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MapServiceImpl implements MapService {

    private final MapRepository mapRepository;
    private final MapMapper mapMapper;

    @Override
    public MapDto add(MapDto mapDto) {
        MapEntity mapEntity = mapMapper.toEntity(mapDto);
        MapEntity savedMapEntity = mapRepository.save(mapEntity);
        return mapMapper.toDto(savedMapEntity);
    }

    @Override
    public void remove(String name) {
        mapRepository.deleteMapEntityByName(name);
    }

    @Override
    public Integer sum(SumTwoNumberDto sumTwoNumberDto) {
        Integer first = mapRepository.getByName(sumTwoNumberDto.getFirst());
        Integer second = mapRepository.getByName(sumTwoNumberDto.getSecond());
        return first + second;
    }
}
