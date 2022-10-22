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
class DisciplineAssemblerTest {

    @Autowired
    private DisciplineAssembler disciplineAssembler;
    @DisplayName("Testa conversão de disciplina")
    @Test
    void testToModel(){
        Discipline discipline = new Discipline();
        DisciplineDTO disciplineDTO = new DisciplineDTO();

        discipline.setDisciplineName("Teste1");
        disciplineDTO.setDisciplineName("Teste1");

        assertThat(disciplineAssembler.toModel(discipline).getDisciplineName()).isEqualTo(disciplineDTO.getDisciplineName());
    }

    @DisplayName("Testa conversão de lista de disciplina")
    @Test
    void testToModelList(){
        Discipline discipline = new Discipline();
        DisciplineDTO disciplineDTO = new DisciplineDTO();
        List<Discipline> disciplineList = new ArrayList<>();

        discipline.setDisciplineName("Teste1");
        disciplineDTO.setDisciplineName("Teste1");

        disciplineList.add(discipline);

        assertThat(disciplineAssembler.toModel(disciplineList)).hasSize(1);
        assertThat(disciplineAssembler.toModel(disciplineList).get(0).getDisciplineName()).isEqualTo(disciplineDTO.getDisciplineName());
    }

    @DisplayName("Testa conversão de página de disciplina")
    @Test
    void testToModelPage(){
        Discipline discipline = new Discipline();
        DisciplineDTO disciplineDTO = new DisciplineDTO();
        List<Discipline> disciplineList = new ArrayList<>();

        discipline.setDisciplineName("Teste1");
        disciplineDTO.setDisciplineName("Teste1");

        disciplineList.add(discipline);

        Pageable pageable = PageRequest.of(1, 1);
        Page<Discipline> disciplinePage = new PageImpl<>(disciplineList, pageable, 1);

        assertThat(disciplineAssembler.toModel(disciplinePage).getTotalElements()).isEqualTo(2);
        assertThat(disciplineAssembler.toModel(disciplinePage).getTotalPages()).isEqualTo(2);
        assertThat(disciplineAssembler.toModel(disciplinePage).getContent().get(0).getDisciplineName()).isEqualTo(disciplineDTO.getDisciplineName());
    }
}