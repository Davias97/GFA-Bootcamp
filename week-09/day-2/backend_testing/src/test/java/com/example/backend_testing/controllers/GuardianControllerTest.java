package com.example.backend_testing.controllers;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class GuardianControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void getGroot() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/groot")
                        .param("message", "somemessage"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.received").value("somemessage"))
                .andExpect(jsonPath("$.translated").value("I am Groot!"));
    }

    @Test
    public void withoutParameter_whenGetGroot_thenStatusBadRequestAndErrorResponse() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/groot"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error").value("I am Groot!"));
    }
}