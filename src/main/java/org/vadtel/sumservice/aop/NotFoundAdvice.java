package org.vadtel.sumservice.aop;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.vadtel.sumservice.controller.response.ResponseCode;
import org.vadtel.sumservice.controller.response.SumServiceResponse;
import org.vadtel.sumservice.exception.ApiExceptionNotFoundInDatabase;

@ControllerAdvice
class NotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(ApiExceptionNotFoundInDatabase.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    SumServiceResponse<Void> notFoundHandler(ApiExceptionNotFoundInDatabase e) {
        return new SumServiceResponse<>(ResponseCode.NUMBER_NOT_FOUND);
    }
}