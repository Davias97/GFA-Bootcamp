package com.example.reddit.model;

import com.example.reddit.repo.PostRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PostTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    PostRepo postRepo;

    @Test
    void getTitle() throws Exception {
        Post post = new Post("title", "dabu.com");
        post.setId(0L);

        when(postRepo.findAll()).thenReturn(List.of(post));

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value(post.getTitle()))
                .andExpect(status().isOk());
    }

    @Test
    void setTitle() {
    }
}