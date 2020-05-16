package org.vadtel.sumservice.service;

import org.vadtel.sumservice.dto.NumberDto;
import org.vadtel.sumservice.dto.SumOfTwoNumber;
import org.vadtel.sumservice.dto.SumRequestDto;

public interface NumberService {

    void add(NumberDto numberDto);

    void remove(String name);

    SumOfTwoNumber sum(SumRequestDto sumRequestDto);

}
