package com.oficina.educacional.api.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@AutoConfigureMockMvc
@SpringBootTest
class CourseControllerTest {

    @DisplayName("Testa criação de course")
    @Test
    void shouldCreateCourse() {
        assertEquals(2, 3);
//        mockMvc.perform(MockMvcRequestBuilders.post("v1/course")).
    }

    @DisplayName("Testa atualização de course")
    @Test
    void shouldUpdateCourse() {
        assertEquals(2, 3);
    }

    @DisplayName("Testa busca de cursos")
    @Test
    void shouldFindAllFilteredCourse() {
        assertEquals(2, 3);
    }

    @DisplayName("Testa deleção de cursos")
    @Test
    void shouldDeleteCourse() {
        assertEquals(2, 3);
    }

}