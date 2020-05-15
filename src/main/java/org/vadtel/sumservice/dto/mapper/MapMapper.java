package org.vadtel.sumservice.dto.mapper;

import org.mapstruct.Mapper;
import org.vadtel.sumservice.dto.MapDto;
import org.vadtel.sumservice.entity.MapEntity;

@Mapper(componentModel = "spring")
public interface MapMapper {

    MapEntity toEntity(MapDto mapDto);

    MapDto toDto(MapEntity mapEntity);
}
