package com.oficina.educacional.api.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@AutoConfigureMockMvc
@SpringBootTest
class StudentControllerTest {

    @DisplayName("Testa criação de student")
    @Test
    void shouldCreateStudent() {
        assertEquals(2, 3);
//        mockMvc.perform(MockMvcRequestBuilders.post("v1/student")).
    }

    @DisplayName("Testa atualização de student")
    @Test
    void shouldUpdateStudent() {
        assertEquals(2, 3);
    }

    @DisplayName("Testa busca de students")
    @Test
    void shouldFindAllFilteredStudent() {
        assertEquals(2, 3);
    }

    @DisplayName("Testa deleção de students")
    @Test
    void shouldDeleteStudent() {
        assertEquals(2, 3);
    }
}