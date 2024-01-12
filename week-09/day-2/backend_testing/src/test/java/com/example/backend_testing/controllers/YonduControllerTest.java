package com.example.backend_testing.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class YonduControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void getArrow() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/yondu")
                .param("distance", "100.0").param("time", "10.0"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.speed").value("10.0"));
    }

    @Test
    void getError() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/yondu"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error2").value("ENTER INPUT, FOOL!"));
    }
}