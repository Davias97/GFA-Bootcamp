package com.example.reddit.controller;

import com.example.reddit.model.Post;
import com.example.reddit.repo.PostRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class RedditControllerTest {

    @Autowired
    MockMvc  mockMvc;

    @MockBean
    PostRepo postRepo;

    @Test
    void home() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/")
                        .param("title", "dabu")
                        .param("url", "dabu.com"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("dabu"))
                .andExpect(jsonPath("$.url").value("dabu.com"));
    }

    @Test
    void createNewPost() {
    }

    @Test
    void saveNewPost() {
    }

    @Test
    void getPost() {
    }

    @Test
    void getLoginPage() {
    }

    @Test
    void sendLogin() {
    }

    @Test
    void getRegisterPage() {
    }

    @Test
    void registerNewUser() {
    }
}