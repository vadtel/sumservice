package org.vadtel.sumservice.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.vadtel.sumservice.dao.NumberRepository;
import org.vadtel.sumservice.dto.NumberDto;
import org.vadtel.sumservice.dto.SumOfTwoNumber;
import org.vadtel.sumservice.dto.SumRequestDto;
import org.vadtel.sumservice.service.NumberService;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class NumberServiceImplTest {

    @Autowired
    public NumberService numberService;
    @Autowired
    public NumberRepository numberRepository;

    @BeforeEach
    void setUp() {

    }

    @Test
    void add() {
        numberService.add(new NumberDto("hundred", 100));
        assertTrue(numberRepository.findValueByName("hundred").isPresent());
    }

    @Test
    void remove() {
        numberService.remove("one");
        assertFalse(numberRepository.findByName("one").isPresent());
    }

    @Test
    void sum() {
        SumOfTwoNumber sum = numberService.sum(new SumRequestDto("one", "two"));
        assertEquals(new SumOfTwoNumber(1, 2), sum);
    }
}