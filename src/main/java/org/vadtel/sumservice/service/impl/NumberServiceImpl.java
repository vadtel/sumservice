package org.vadtel.sumservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.vadtel.sumservice.dao.NumberRepository;
import org.vadtel.sumservice.dto.NumberDto;
import org.vadtel.sumservice.dto.SumRequestDto;
import org.vadtel.sumservice.dto.mapper.NumberMapper;
import org.vadtel.sumservice.entity.NumberEntity;
import org.vadtel.sumservice.exception.ApiExceptionDuplicateEntry;
import org.vadtel.sumservice.exception.ApiExceptionNotFoundInDatabase;
import org.vadtel.sumservice.service.NumberService;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class NumberServiceImpl implements NumberService {

    private final NumberRepository numberRepository;
    private final NumberMapper numberMapper;

    @Override
    public void add(NumberDto numberDto) {
        Optional<Integer> numberEntity = numberRepository.getNumberByName(numberDto.getName());
        if (numberEntity.isPresent()) {
            throw new ApiExceptionDuplicateEntry();
        }

        NumberEntity mapEntity = numberMapper.toEntity(numberDto);
        numberRepository.save(mapEntity);
    }

    @Override
    public void remove(String name) {
        NumberEntity numberEntity = numberRepository.getNumberEntitiesByName(name).orElseThrow(ApiExceptionNotFoundInDatabase::new);

        numberRepository.delete(numberEntity);
    }

    @Override
    public Integer sum(SumRequestDto sumRequestDto) {
        Integer numberOne = numberRepository.getNumberByName(sumRequestDto.getFirst()).orElseThrow(ApiExceptionNotFoundInDatabase::new);
        Integer numberTwo = numberRepository.getNumberByName(sumRequestDto.getSecond()).orElseThrow(ApiExceptionNotFoundInDatabase::new);

        return numberOne + numberTwo;
    }
}
