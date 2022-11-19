package com.oficina.educacional.api.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@AutoConfigureMockMvc
@SpringBootTest
class DisciplineControllerTest {

    @DisplayName("Testa criação de discipline")
    @Test
    void shouldCreateDiscipline() {
        assertEquals(2, 3);
//        mockMvc.perform(MockMvcRequestBuilders.post("v1/discipline")).
    }

    @DisplayName("Testa atualização de discipline")
    @Test
    void shouldUpdateDiscipline() {
        assertEquals(2, 3);
    }

    @DisplayName("Testa busca de disciplinas")
    @Test
    void shouldFindAllFilteredDiscipline() {
        assertEquals(2, 3);
    }

    @DisplayName("Testa deleção de disciplinas")
    @Test
    void shouldDeleteDiscipline() {
        assertEquals(2, 3);
    }
}