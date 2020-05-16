package org.vadtel.sumservice.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SumServiceResponse<T> {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T body;

    private Integer code;

    private String description;

    public SumServiceResponse(ResponseCode responseCode) {
        this(null, responseCode);
    }

    public SumServiceResponse(T body, ResponseCode responseCode) {
        this.body = body;
        this.code = responseCode.getCode();
        this.description = responseCode.getDescription();
    }

}
