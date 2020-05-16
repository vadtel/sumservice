package org.vadtel.sumservice.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class SumOfTwoNumber {

    private final Integer sum;

    public SumOfTwoNumber(Integer first, Integer second) {
        this.sum = first + second;
    }

}
