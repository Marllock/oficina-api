package com.oficina.educacional.domain.service;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@TestPropertySource("/application-test.properties")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class ProfessorServiceIntegrationTest {

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

    @Order(10)
    @DisplayName("Testa listagem de professor pelo nome")
    @Test
    void shouldListProfessorByName() {

    }

    @Order(11)
    @DisplayName("Testa listagem de professor pelo curso")
    @Test
    void shouldListProfessorByCourseId() {

    }

    @Order(12)
    @DisplayName("Testa listagem de professor pelo id de usuario")
    @Test
    void shouldListProfessorByUserId() {

    }

    @Order(13)
    @DisplayName("Testa listagem de professor pelo email")
    @Test
    void shouldListProfessorByEmail() {

    }

    @Order(14)
    @DisplayName("Testa listagem de professor pela cidade")
    @Test
    void shouldListProfessorByCity() {

    }

    @Order(15)
    @DisplayName("Testa listagem de professor pelo estado")
    @Test
    void shouldListProfessorByState() {

    }

    @Order(16)
    @DisplayName("Testa listagem de professor com todos os filtros")
    @Test
    void shouldListProfessorWithAllFilters() {

    }

    @Order(17)
    @DisplayName("Testa listagem de professor com nenhum os filtros")
    @Test
    void shouldListProfessorWithNoFilters() {

    }
}