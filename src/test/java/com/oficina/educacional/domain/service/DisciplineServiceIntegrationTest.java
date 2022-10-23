package com.oficina.educacional.domain.service;

import com.oficina.educacional.api.model.input.DisciplineInputDTO;
import com.oficina.educacional.domain.repository.CourseRepository;
import com.oficina.educacional.domain.repository.DisciplineRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;

@TestPropertySource("/application-test.properties")
@SpringBootTest
class DisciplineServiceIntegrationTest {

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private DisciplineRepository disciplineRepository;

    @Autowired
    private DisciplineService disciplineService;

    @AfterEach
    public void deleteAll() {
        disciplineRepository.deleteAll();
        courseRepository.deleteAll();
    }

    @DisplayName("Testa criação de disciplina")
    @Sql("/insertCourseData.sql")
    @Test
    public void shouldCreateDiscipline() {
        DisciplineInputDTO disciplineInputDTO = new DisciplineInputDTO();
        disciplineInputDTO.setDisciplineName("Test1");
        disciplineInputDTO.setDisciplineCode("ASBC31");
        disciplineInputDTO.setCourseId(1L);

        assertThat(disciplineService.create(disciplineInputDTO)).hasFieldOrPropertyWithValue("disciplineName", "Test1");
    }

    @DisplayName("Testa atualização de nome de disciplina")
    @Sql("/insertCourseData.sql")
    @Sql("/insertDisciplineData.sql")
    @Test
    public void shouldUpdateDisciplineName() {
        DisciplineInputDTO disciplineInputDTO = new DisciplineInputDTO();
        disciplineInputDTO.setDisciplineName("teste4");
        assertThat(disciplineService.update(disciplineInputDTO, 1L))
                .hasFieldOrPropertyWithValue("disciplineName", "teste4");
    }

    @DisplayName("Testa atualização de código disciplina")
    @Sql("/insertCourseData.sql")
    @Sql("/insertDisciplineData.sql")
    @Test
    public void shouldUpdateDisciplineCode() {
        DisciplineInputDTO disciplineInputDTO = new DisciplineInputDTO();
        disciplineInputDTO.setDisciplineCode("1237");
        assertThat(disciplineService.update(disciplineInputDTO, 1L))
                .hasFieldOrPropertyWithValue("disciplineCode", "1237");
    }

    @DisplayName("Testa atualização de código disciplina com conflito")
    @Sql("/insertCourseData.sql")
    @Sql("/insertDisciplineData.sql")
    @Test
    public void shouldThrowConflictExceptionWhenUpdateDisciplineCode() {
        DisciplineInputDTO disciplineInputDTO = new DisciplineInputDTO();
        disciplineInputDTO.setDisciplineCode("123");
        assertThatThrownBy(() -> {
            disciplineService.update(disciplineInputDTO, 2L);
        }).isInstanceOf(DataIntegrityViolationException.class);

    }

    @DisplayName("Testa atualização de curso em disciplina")
    @Sql("/insertCourseData.sql")
    @Sql("/insertDisciplineData.sql")
    @Test
    public void shouldUpdateDisciplineCourse() {
        DisciplineInputDTO disciplineInputDTO = new DisciplineInputDTO();
        disciplineInputDTO.setCourseId(2L);
        assertThat(disciplineService.update(disciplineInputDTO, 1L).getCourseId().getCourseId())
                .isEqualTo(2);
    }

    @DisplayName("Testa atualização de curso de disciplina não existente")
    @Sql("/insertCourseData.sql")
    @Sql("/insertDisciplineData.sql")
    @Test
    public void shouldThrowNoSuchElemenExceptionWhenUpdateDisciplineCourse() {
        DisciplineInputDTO disciplineInputDTO = new DisciplineInputDTO();
        disciplineInputDTO.setCourseId(8L);

        assertThatThrownBy(()-> {
            disciplineService.update(disciplineInputDTO, 1L);
        }).isInstanceOf(NoSuchElementException.class);
    }

    @DisplayName("Testa atualização de disciplina completa")
    @Sql("/insertCourseData.sql")
    @Sql("/insertDisciplineData.sql")
    @Test
    public void shouldUpdateCompleteDiscipline() {
        DisciplineInputDTO disciplineInputDTO = new DisciplineInputDTO();
        disciplineInputDTO.setDisciplineCode("1237");
        disciplineInputDTO.setDisciplineName("teste4");
        disciplineInputDTO.setCourseId(2L);

        assertThat(disciplineService.update(disciplineInputDTO, 1L))
                .hasFieldOrPropertyWithValue("disciplineName", "teste4")
                .hasFieldOrPropertyWithValue("disciplineCode", "1237");
    }

    @DisplayName("Testa falha de atualização de disciplina com id inexistente")
    @Sql("/insertCourseData.sql")
    @Sql("/insertDisciplineData.sql")
    @Test
    public void shouldThrowNoSuchElementExceptionOnUpdateDiscipline() {
        DisciplineInputDTO disciplineInputDTO = new DisciplineInputDTO();
        disciplineInputDTO.setDisciplineCode("1237");
        assertThatThrownBy(() -> {
            disciplineService.update(disciplineInputDTO, 8L);
        }).isInstanceOf(NoSuchElementException.class);
    }

    @DisplayName("Testa listagem de disciplina com nome paginada")
    @Sql("/insertCourseData.sql")
    @Sql("/insertDisciplineData.sql")
    @Test
    public void shouldIndexDisciplineWithName() {

        assertThat(disciplineService.index(10, 0, "teste", "", 0).getContent())
                .hasSize(4);
    }
    @DisplayName("Testa listagem de disciplina com código paginada")
    @Sql("/insertCourseData.sql")
    @Sql("/insertDisciplineData.sql")
    @Test
    public void shouldIndexDisciplineWithCode() {
        assertThat(disciplineService.index(10, 0, "", "123", 0).getContent())
                .hasSize(1);
    }

    @DisplayName("Testa listagem de disciplina com curso paginada")
    @Sql("/insertCourseData.sql")
    @Sql("/insertDisciplineData.sql")
    @Test
    public void shouldIndexDisciplineWithCourse() {
        assertThat(disciplineService.index(10, 0, "", "", 1L).getContent())
                .hasSize(4);
    }

    @DisplayName("Testa listagem de disciplina commpleto paginada")
    @Sql("/insertCourseData.sql")
    @Sql("/insertDisciplineData.sql")
    @Test
    public void shouldIndexDiscipline() {
        assertThat(disciplineService.index(10, 0, "teste", "123", 1L).getContent())
                .hasSize(1);
    }

    @DisplayName("Testa deleção de disciplina")
    @Sql("/insertCourseData.sql")
    @Sql("/insertDisciplineData.sql")
    @Test
    public void shouldDeleteDiscipline() {
        assertThat(disciplineRepository.findById(1L).orElseThrow(NoSuchElementException::new))
                .hasFieldOrPropertyWithValue("disciplineName", "teste");
       disciplineService.delete(1L);
        assertThatThrownBy(() -> {
            disciplineRepository.findById(1L).orElseThrow(NoSuchElementException::new);
        }).isInstanceOf(NoSuchElementException.class);
    }
}