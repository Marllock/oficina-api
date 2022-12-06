package com.oficina.educacional.domain.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class StudentServiceUnitTest {

    @DisplayName("Testa Criação de estudante")
    @Test
    void shouldCreateStudent() {
        assertThat(2).isEqualTo(3);
    }

    @DisplayName("Testa atualização de estudante")
    @Test
    void shouldUpdateStudent(){
        assertThat(2).isEqualTo(3);
    }

    @DisplayName("Testa busca de estudante")
    @Test
    void shouldFindAllStudent() {
        assertThat(2).isEqualTo(3);
    }

    @DisplayName("Testa deleção de estudante")
    @Test
    void shouldDeleteStudent() {
        assertThat(2).isEqualTo(3);
    }
}
