package org.vadtel.sumservice.service;

import org.vadtel.sumservice.dto.MapDto;
import org.vadtel.sumservice.dto.SumTwoNumberDto;

public interface MapService {

    MapDto add(MapDto mapDto);

    void remove(String name);

    Integer sum(SumTwoNumberDto sumTwoNumberDto);

}
