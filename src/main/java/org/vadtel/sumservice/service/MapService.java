package org.vadtel.sumservice.service;

import org.vadtel.sumservice.dto.SumDto;

import java.util.List;

public interface MapService {

    void add(String name, Integer value);

    void remove(String name);

    Integer sum(SumDto sumDto);

}
