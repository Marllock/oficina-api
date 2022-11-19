package com.oficina.educacional.api.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@AutoConfigureMockMvc
@SpringBootTest
class UserControllerTest {

    @DisplayName("Testa criação de user")
    @Test
    void shouldCreateUser() {
        assertEquals(2, 3);
//        mockMvc.perform(MockMvcRequestBuilders.post("v1/user")).
    }

    @DisplayName("Testa atualização de user")
    @Test
    void shouldUpdateUser() {
        assertEquals(2, 3);
    }

    @DisplayName("Testa busca de users")
    @Test
    void shouldFindAllFilteredUser() {
        assertEquals(2, 3);
    }

    @DisplayName("Testa deleção de users")
    @Test
    void shouldDeleteUser() {
        assertEquals(2, 3);
    }
}