package com.oficina.educacional.api.assembler;

import com.oficina.educacional.domain.model.Professor;
import com.oficina.educacional.domain.model.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ProfessorAssemblerTest {

    @Autowired
    private ProfessorAssembler professorAssembler;

    private static final User user = new User();

    @BeforeAll
    static void setUp() {
        user.setUserName("Test1");
    }

    @DisplayName("Testa conversão de DTO para entidade")
    @Test
    void toModel() {
        Professor professor = new Professor();
        professor.setUser(user);
        assertThat(professorAssembler.toModel(professor).getUser().getUserName()).isEqualTo("Test1");
    }

    @DisplayName("Testa conversão para listagem de professor")
    @Test
    void testToModelList() {
        Professor professor = new Professor();
        List<Professor> professorList = new ArrayList<>();

        professor.setUser(user);
        professorList.add(professor);

        assertThat(professorAssembler.toModel(professorList)).hasSize(1);
        assertThat(professorAssembler.toModel(professorList).get(0).getUser().getUserName()).isEqualTo("Test1");
    }

    @DisplayName("Testa conversão para página de professor")
    @Test
    void testToModelPage() {
        Professor professor = new Professor();
        List<Professor> professorList = new ArrayList<>();

        professor.setUser(user);

        professorList.add(professor);
        Pageable pageable = PageRequest.of(1, 1);
        Page<Professor> professorPage = new PageImpl<>(professorList, pageable, 1);

        assertThat(professorAssembler.toModel(professorPage)).hasSize(1);
        assertThat(professorAssembler.toModel(professorPage).getContent().get(0).getUser().getUserName()).isEqualTo("Test1");
    }
}