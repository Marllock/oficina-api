package com.oficina.educacional.domain.service;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class ProfessorServiceUnitTest {

    @Order(1)
    @DisplayName("Testa criação de professor")
    @Test
    void shouldCreateProfessor() {

    }

    @Order(2)
    @DisplayName("Testa atualização de professor por nome")
    @Test
    void shouldUpdateProfessorByName() {

    }

    @Order(3)
    @DisplayName("Testa atualização de professor por endereço")
    @Test
    void shouldUpdateProfessorByAddress() {

    }

    @Order(4)
    @DisplayName("Testa atualização de professor por email")
    @Test
    void shouldUpdateProfessorByEmail() {

    }

    @Order(5)
    @DisplayName("Testa atualização de professor por curso")
    @Test
    void shouldUpdateProfessorByCourse() {

    }

    @Order(6)
    @DisplayName("Testa atualização de professor por telefone")
    @Test
    void shouldUpdateProfessorByTelephone() {

    }

    @Order(7)
    @DisplayName("Testa atualização de professor por status")
    @Test
    void shouldUpdateProfessorByStatus() {

    }

    @Order(8)
    @DisplayName("Testa deleção de professor")
    @Test
    void shouldDeleteProfessor() {

    }

    @Order(9)
    @DisplayName("Testa falha deleção de professor")
    @Test
    void shouldFailDeleteProfessor() {

    }
}
