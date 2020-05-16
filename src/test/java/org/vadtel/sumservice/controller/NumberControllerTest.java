package org.vadtel.sumservice.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class NumberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void add() throws Exception {
        this.mockMvc.perform(post("/add").contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"three hundred\", \"value\": 300}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("code").value("0"))
                .andExpect(jsonPath("description").value("OK"));
    }

    @Test
    void remove() throws Exception {
        this.mockMvc.perform(post("/remove").contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"four\"}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("code").value("0"))
                .andExpect(jsonPath("description").value("OK"));

    }

    @Test
    void sum() throws Exception {
        this.mockMvc.perform(post("/sum").contentType(MediaType.APPLICATION_JSON)
                .content("{\"first\": \"four\", \"second\": \"four\"}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("sum").value("8"))
                .andExpect(jsonPath("code").value("0"))
                .andExpect(jsonPath("description").value("OK"));

    }
}
