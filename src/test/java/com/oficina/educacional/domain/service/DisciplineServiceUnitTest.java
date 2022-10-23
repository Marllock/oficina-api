package com.oficina.educacional.domain.service;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class DisciplineServiceUnitTest {

    @Order(1)
    @DisplayName("Testa criação de disciplina")
    @Test
    void shouldCreateDiscipline() {
        assertThat(3).isEqualTo(2);
    }

    @Order(2)
    @DisplayName("Testa deleção de disciplina")
    @Test
    void shouldDeleteDiscipline() {
        assertThat(3).isEqualTo(2);
    }

    @Order(3)
    @DisplayName("Testa atualização de nome de disciplina")
    @Test
    void shouldUpdateDisciplineName() {
        assertThat(3).isEqualTo(2);
    }

    @Order(4)
    @DisplayName("Testa atualização de código de disciplina")
    @Test
    void shouldUpdateDisciplineCode() {
        assertThat(3).isEqualTo(2);
    }

    @Order(5)
    @DisplayName("Testa atualização de curso de disciplina")
    @Test
    void shouldUpdateDisciplineCourse() {
        assertThat(3).isEqualTo(2);
    }

    @Order(6)
    @DisplayName("Testa atualização completa de disciplina")
    @Test
    void shouldUpdateDiscipline() {
        assertThat(3).isEqualTo(2);
    }

    @Order(7)
    @DisplayName("Testa falha de atualização de disciplina com disciplina inválida")
    @Test
    void shouldNotUpdateDisciplineWithInvalidDisciplineId() {
        assertThat(3).isEqualTo(2);
    }

    @Order(8)
    @DisplayName("Testa falha de atualização de disciplina com curso inválida")
    @Test
    void shouldNotUpdateDisciplineWithInvalidCourseId() {
        assertThat(3).isEqualTo(2);
    }
}
