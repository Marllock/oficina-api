package com.oficina.educacional.api.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;

@AutoConfigureMockMvc
class ProfessorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @DisplayName("Testa criação de professor")
    @Test
    void shouldCreateProfessor() {
        assertEquals(2, 3);
//        mockMvc.perform(MockMvcRequestBuilders.post("v1/professor")).
    }

    @DisplayName("Testa atualização de professor")
    @Test
    void shouldUpdateProfessor() {
        assertEquals(2, 3);
    }

    @DisplayName("Testa busca de professores")
    @Test
    void shouldFindAllFilteredProfessor() {
        assertEquals(2, 3);
    }

    @DisplayName("Testa deleção de professores")
    @Test
    void shouldDeleteProfessor() {
        assertEquals(2, 3);
    }
}