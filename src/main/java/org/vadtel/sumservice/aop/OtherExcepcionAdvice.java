package org.vadtel.sumservice.aop;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.vadtel.sumservice.controller.response.ResponseCode;
import org.vadtel.sumservice.controller.response.SumServiceResponse;

@ControllerAdvice
public class OtherExcepcionAdvice {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    SumServiceResponse<Void> otherExceptionHandler(Exception e) {
        return new SumServiceResponse<>(ResponseCode.OTHER_ERROR);
    }
}
