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
    public SumServiceResponse<Void> add(@RequestBody NumberDto numberDto,
                                        HttpServletResponse httpServletResponse) {

        numberService.add(numberDto);
        httpServletResponse.setStatus(200);
        return new SumServiceResponse<>(ResponseCode.OK);
    }

    @PostMapping("/remove")
    public SumServiceResponse<Void> remove(@RequestBody NumberDto numberDto,
                                           HttpServletResponse httpServletResponse) {

        numberService.remove(numberDto.getName());
        httpServletResponse.setStatus(200);
        return new SumServiceResponse<>(ResponseCode.OK);
    }

    @PostMapping("/sum")
    public SumServiceResponse<Integer> sum(@RequestBody SumRequestDto sumRequestDto,
                                           HttpServletResponse httpServletResponse) {
        Integer sum = numberService.sum(sumRequestDto);
        httpServletResponse.setStatus(200);
        return new SumServiceResponse<>(sum, ResponseCode.OK);
    }


}
