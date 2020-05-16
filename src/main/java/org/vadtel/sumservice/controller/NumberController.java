package org.vadtel.sumservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vadtel.sumservice.controller.response.ResponseCode;
import org.vadtel.sumservice.controller.response.SumServiceResponse;
import org.vadtel.sumservice.dto.NumberDto;
import org.vadtel.sumservice.dto.SumRequestDto;
import org.vadtel.sumservice.exception.ApiExceptionDuplicateEntry;
import org.vadtel.sumservice.exception.ApiExceptionNotFoundInDatabase;
import org.vadtel.sumservice.service.NumberService;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class NumberController {

    private final NumberService numberService;


    @PostMapping("/add")
    public SumServiceResponse<Void> add(@RequestBody NumberDto numberDto, HttpServletResponse httpServletResponse) {
        try {
            numberService.add(numberDto);
        } catch (ApiExceptionDuplicateEntry e) {
            httpServletResponse.setStatus(503);
            return new SumServiceResponse<>(ResponseCode.DUPLICATE_ENTRY);
        } catch (Exception e) {
            httpServletResponse.setStatus(503);
            return new SumServiceResponse<>(ResponseCode.OTHER_ERROR);
        }
        httpServletResponse.setStatus(200);
        return new SumServiceResponse<>(ResponseCode.OK);
    }

    @PostMapping("/remove")
    public SumServiceResponse<Void> remove(@RequestBody NumberDto numberDto) {

        numberService.remove(numberDto.getName());
        return new SumServiceResponse<>(ResponseCode.OK);
    }

    @PostMapping("/sum")
    public SumServiceResponse<Integer> sum(@RequestBody SumRequestDto sumRequestDto, HttpServletResponse httpServletResponse) {
        Integer sum = null;
        try {
            sum = numberService.sum(sumRequestDto);
        } catch (ApiExceptionNotFoundInDatabase e) {
            httpServletResponse.setStatus(404);
            return new SumServiceResponse<>(ResponseCode.NUMBER_NOT_FOUND);
        } catch (Exception e) {
            httpServletResponse.setStatus(503);
            return new SumServiceResponse<>(ResponseCode.OTHER_ERROR);
        }
        httpServletResponse.setStatus(200);
        return new SumServiceResponse<>(sum, ResponseCode.OK);
    }


}
