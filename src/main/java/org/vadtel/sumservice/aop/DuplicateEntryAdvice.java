package org.vadtel.sumservice.aop;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.vadtel.sumservice.controller.response.ResponseCode;
import org.vadtel.sumservice.controller.response.SumServiceResponse;
import org.vadtel.sumservice.exception.ApiExceptionDuplicateEntry;

@ControllerAdvice
public class DuplicateEntryAdvice {

    @ResponseBody
    @ExceptionHandler(ApiExceptionDuplicateEntry.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    SumServiceResponse<Void> duplicateEntryHandler(ApiExceptionDuplicateEntry e){
        return new SumServiceResponse<>(ResponseCode.DUPLICATE_ENTRY);
    }
}
