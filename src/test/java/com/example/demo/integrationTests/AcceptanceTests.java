package com.example.demo.integrationTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
@AutoConfigureMockMvc
public class AcceptanceTests {
    @Test
    public void contextLoad() {
    }

    @Test
    @DisplayName("https://localhost:9090/findById/{id} -> 200")
    public void shouldReturnMovieById() {
        fail();
    }

    @Test
    @DisplayName("https://localhost:9090/allmovie -> 200")
    public void shouldReturnAllMovie() {
        fail();
    }
}
