package org.vadtel.sumservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.vadtel.sumservice.dao.MapRepository;
import org.vadtel.sumservice.dto.SumDto;
import org.vadtel.sumservice.service.MapService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MapServiceImpl implements MapService {

    private final MapRepository mapRepository;

    @Override
    public void add(String name, Integer value) {

    }

    @Override
    public void remove(String name) {

    }

    @Override
    public Integer sum(SumDto sumDto) {
        Integer first = mapRepository.getByName(sumDto.getFirst());
        Integer second = mapRepository.getByName(sumDto.getSecond());
        return first + second;
    }
}
