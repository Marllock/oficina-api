package com.oficina.educacional.api.assembler;

import com.oficina.educacional.api.model.ProfessorDTO;
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
class ProfessorDisassemblerTest {

    @Autowired
    private ProfessorDisassembler professorDisassembler;

    private static final User user = new User();

    @BeforeAll
    static void setUp() {
        user.setUserName("Test1");
    }

    @DisplayName("Testa conversão de DTO para entidade")
    @Test
    void toModel() {
        ProfessorDTO professorDTO = new ProfessorDTO();
        professorDTO.setUser(user);
        assertThat(professorDisassembler.toModel(professorDTO).getUser().getUserName()).isEqualTo("Test1");
    }

    @DisplayName("Testa conversão para listagem de professor")
    @Test
    void testToModelList() {
        ProfessorDTO professorDTO = new ProfessorDTO();
        List<ProfessorDTO> professorDTOList = new ArrayList<>();

        professorDTO.setUser(user);
        professorDTOList.add(professorDTO);

        assertThat(professorDisassembler.toModel(professorDTOList)).hasSize(1);
        assertThat(professorDisassembler.toModel(professorDTOList).get(0).getUser().getUserName()).isEqualTo("Test1");
    }

    @DisplayName("Testa conversão para página de professor")
    @Test
    void testToModelPage() {
        ProfessorDTO professor = new ProfessorDTO();
        List<ProfessorDTO> professorList = new ArrayList<>();

        professor.setUser(user);

        professorList.add(professor);
        Pageable pageable = PageRequest.of(1, 1);
        Page<ProfessorDTO> professorPage = new PageImpl<>(professorList, pageable, 1);

        assertThat(professorDisassembler.toModel(professorPage)).hasSize(1);
        assertThat(professorDisassembler.toModel(professorPage).getContent().get(0).getUser().getUserName()).isEqualTo("Test1");
    }
}