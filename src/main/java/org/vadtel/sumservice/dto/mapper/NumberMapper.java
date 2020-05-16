package org.vadtel.sumservice.dto.mapper;

import org.mapstruct.Mapper;
import org.vadtel.sumservice.dto.NumberDto;
import org.vadtel.sumservice.entity.NumberEntity;

@Mapper(componentModel = "spring")
public interface NumberMapper {

    NumberEntity toEntity(NumberDto numberDto);

    NumberDto toDto(NumberEntity mapEntity);
}
