package org.vadtel.sumservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.vadtel.sumservice.dto.MapDto;
import org.vadtel.sumservice.dto.SumTwoNumberDto;
import org.vadtel.sumservice.service.MapService;

@Controller
@RequestMapping(value = "/",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MapController {

    private final MapService mapService;


    @PostMapping("/add")
    public ResponseEntity<Void> add(@RequestBody MapDto mapDto) {
        MapDto add = mapService.add(mapDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/remove")
    public ResponseEntity<Void> remove(@RequestBody MapDto mapDto) {
        mapService.remove(mapDto.getName());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/sum")
    public ResponseEntity<Integer> sum(@RequestBody SumTwoNumberDto sumTwoNumberDto) {
        Integer sum = mapService.sum(sumTwoNumberDto);

        return new ResponseEntity<>(sum, HttpStatus.OK);
    }


}
