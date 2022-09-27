package com.example.demo.integrationTests;

import com.example.demo.adapters.entity.MovieEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AcceptanceTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void contextLoad() {
    }

    @Test
    @DisplayName("https://localhost:9090/findById/{id} -> 200")
    public void shouldReturnMovieById() throws Exception {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/findById/1")
                .contentType("application/json")
                .param("id", "1"))
                .andDo(print())
                .andExpect(status().isOk());
        MovieEntity expected = new MovieEntity(1L, "psy", "kryminalny");
        String jsonAsString = resultActions.andReturn().getResponse().getContentAsString();
        MovieEntity movieEntity = objectMapper.readValue(jsonAsString, MovieEntity.class);
        assertEquals(expected.getId(), movieEntity.getId());
        assertEquals(expected.getTitle(), movieEntity.getTitle());
        assertEquals(expected.getType(), movieEntity.getType());
    }

    @Test
    @DisplayName("https://localhost:9090/allmovie -> 200")
    public void shouldReturnAllMovie() {
        fail();
    }
}
