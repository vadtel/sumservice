package org.vadtel.sumservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class SumRequestDto {
    String first;
    String second;
}
