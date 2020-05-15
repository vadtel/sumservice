package org.vadtel.sumservice.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.vadtel.sumservice.dto.MapDto;
import org.vadtel.sumservice.dto.SumDto;
import org.vadtel.sumservice.service.MapService;

import java.util.List;

@Controller
@RequestMapping(value = "/",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MapController {

    private final MapService mapService;

    @PostMapping("/add")
    public ResponseEntity<MapDto> add(@RequestBody MapDto mapDto) {

        return new ResponseEntity<>(mapDto, HttpStatus.OK);
    }

    @PostMapping("/remove")
    public ResponseEntity<MapDto> remove(@RequestBody MapDto mapDto) {

        return new ResponseEntity<>(mapDto, HttpStatus.OK);
    }

    @PostMapping("/sum")
    public ResponseEntity<Integer> sum(@RequestBody SumDto sumDto) {
        Integer sum = mapService.sum(sumDto);

        return new ResponseEntity<>(sum, HttpStatus.OK);
    }






}
