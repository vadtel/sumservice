package org.vadtel.sumservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class SumRequestDto {

    private String first;

    private String second;
}
