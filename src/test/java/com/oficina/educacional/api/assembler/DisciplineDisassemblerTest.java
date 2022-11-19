package com.oficina.educacional.api.assembler;

import com.oficina.educacional.api.model.DisciplineDTO;
import com.oficina.educacional.domain.model.Discipline;
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

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class DisciplineDisassemblerTest {

    @Autowired
    private DisciplineDisassembler disciplineDisassembler;

    @DisplayName("Testa conversão para Disciplina")
    @Test
    void testToModel(){
        DisciplineDTO disciplineDTO = new DisciplineDTO();
        disciplineDTO.setDisciplineName("Teste1");

        assertThat(disciplineDisassembler.toModel(disciplineDTO)).isInstanceOf(Discipline.class);
        assertThat(disciplineDisassembler.toModel(disciplineDTO).getDisciplineName()).isEqualTo("Teste1");
    }

    @DisplayName("Testa conversão para Disciplina")
    @Test
    void testToModelList(){
        DisciplineDTO disciplineDTO = new DisciplineDTO();
        List<DisciplineDTO> disciplineDTOList = new ArrayList<>();
        disciplineDTO.setDisciplineName("Teste1");
        disciplineDTOList.add(disciplineDTO);

        assertThat(disciplineDisassembler.toModel(disciplineDTOList)).hasSize(1);
        assertThat(disciplineDisassembler.toModel(disciplineDTOList).get(0)).isInstanceOf(Discipline.class);
        assertThat(disciplineDisassembler.toModel(disciplineDTOList).get(0).getDisciplineName()).isEqualTo("Teste1");
    }

    @DisplayName("Testa conversão para página de Disciplina")
    @Test
    void testToModelPage(){
        DisciplineDTO disciplineDTO = new DisciplineDTO();
        List<DisciplineDTO> disciplineDTOList = new ArrayList<>();
        disciplineDTO.setDisciplineName("Teste1");
        disciplineDTOList.add(disciplineDTO);
        Pageable pageable = PageRequest.of(1, 1);
        Page<DisciplineDTO> disciplineDTOPage = new PageImpl<>(disciplineDTOList, pageable, 1);

        assertThat(disciplineDisassembler.toModel(disciplineDTOPage).getTotalPages()).isEqualTo(2);
        assertThat(disciplineDisassembler.toModel(disciplineDTOPage).getTotalElements()).isEqualTo(2);
        assertThat(disciplineDisassembler.toModel(disciplineDTOPage).getContent()).hasSize(1);
        assertThat(disciplineDisassembler.toModel(disciplineDTOPage).getContent().get(0).getDisciplineName()).isEqualTo("Teste1");
    }
}