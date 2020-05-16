package org.vadtel.sumservice.service;

import org.vadtel.sumservice.dto.NumberDto;
import org.vadtel.sumservice.dto.SumRequestDto;

public interface NumberService {

    void add(NumberDto numberDto);

    void remove(String name);

    Integer sum(SumRequestDto sumRequestDto);

}
