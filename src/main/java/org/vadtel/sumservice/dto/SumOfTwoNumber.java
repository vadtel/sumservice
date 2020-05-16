package org.vadtel.sumservice.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;

@Getter
public class SumOfTwoNumber {

    private final Integer sum;

    public SumOfTwoNumber(Integer first, Integer second) {
        this.sum = first + second;
    }

}
