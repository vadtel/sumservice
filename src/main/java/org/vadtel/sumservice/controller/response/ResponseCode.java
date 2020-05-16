package org.vadtel.sumservice.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseCode {
    OK(0, "OK"),
    DUPLICATE_ENTRY(2, "Entry has already been created"),
    NUMBER_NOT_FOUND(3, "Entry not found"),
    OTHER_ERROR(4, "Something wrong");

    private Integer code;
    private String description;

}
