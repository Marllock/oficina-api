package com.oficina.educacional.domain.service;

import com.oficina.educacional.api.model.input.DisciplineInputDTO;
import com.oficina.educacional.domain.exception.EmptyResultException;
import com.oficina.educacional.domain.model.Course;
import com.oficina.educacional.domain.model.Discipline;
import com.oficina.educacional.domain.repository.DisciplineRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class DisciplineServiceUnitTest {

    @MockBean
    private DisciplineRepository disciplineRepository;

    @MockBean
    private CourseService courseService;

    @Autowired
    private DisciplineService disciplineService;

    @Order(1)
    @DisplayName("Testa criação de disciplina")
    @Test
    void shouldCreateDiscipline() {
        DisciplineInputDTO disciplineInputDTO = new DisciplineInputDTO();
        disciplineInputDTO.setDisciplineCode("AS31B");
        disciplineInputDTO.setDisciplineName("teste");
        disciplineInputDTO.setCourseId(1L);

        Course course = new Course();
        course.setCourseName("teste");

        Discipline discipline = new Discipline();
        discipline.setCourseId(course);
        discipline.setDisciplineName("teste");
        discipline.setDisciplineCode("AS31B");

        when(disciplineRepository.save(any(Discipline.class))).thenReturn(discipline);
        when(courseService.findByIdOrFail(anyLong())).thenReturn(course);

        assertThat(disciplineService.create(disciplineInputDTO))
                .isEqualTo(discipline)
                .isInstanceOf(Discipline.class);
    }

    @Order(2)
    @DisplayName("Testa falha na criação de disciplina")
    @Test
    void shouldFailCreateDiscipline() {
        DisciplineInputDTO disciplineInputDTO = new DisciplineInputDTO();
        disciplineInputDTO.setDisciplineCode("AS31B");
        disciplineInputDTO.setDisciplineName("teste");
        disciplineInputDTO.setCourseId(1L);

        when(courseService.findByIdOrFail(anyLong())).thenThrow(new NoSuchElementException("Elemento não encontrado"));

        assertThatThrownBy(() -> disciplineService.create(disciplineInputDTO)).isInstanceOf(NoSuchElementException.class).hasMessage("Elemento não encontrado");

    }

    @Order(3)
    @DisplayName("Testa deleção de disciplina")
    @Test
    void shouldDeleteDiscipline() {
        doNothing().when(disciplineRepository).deleteById(anyLong());

        disciplineService.delete(1L);

        verify(disciplineRepository, times(1)).deleteById(anyLong());
    }

    @Order(4)
    @DisplayName("Testa falha de deleção de disciplina")
    @Test
    void shouldFailOnDeleteDiscipline() {
        doThrow(EmptyResultException.class).when(disciplineRepository).deleteById(anyLong());

        assertThatThrownBy(() -> disciplineService.delete(1L)).isInstanceOf(EmptyResultException.class).hasMessage("Disciplina de id 1 não encontrado");

        verify(disciplineRepository, times(1)).deleteById(anyLong());
    }

    @Order(5)
    @DisplayName("Testa atualização completa de disciplina")
    @Test
    void shouldUpdateDiscipline() {
        DisciplineInputDTO disciplineInputDTO = new DisciplineInputDTO();
        disciplineInputDTO.setDisciplineCode("AS31B");
        disciplineInputDTO.setDisciplineName("teste");
        disciplineInputDTO.setCourseId(1L);

        Course course = new Course();
        course.setCourseName("teste");
        course.setCourseCreatedAt(LocalDateTime.of(2022, 11, 4, 10, 25));
        course.setCourseUpdatedAt(LocalDateTime.of(2022, 11, 4, 10, 26));

        Discipline discipline = new Discipline();
        discipline.setCourseId(course);
        discipline.setDisciplineName("teste");
        discipline.setDisciplineCode("AS31B");
        discipline.setDisciplineCreatedAt(LocalDateTime.of(2022, 11, 4, 10, 25));

        when(disciplineRepository.findById(anyLong())).thenReturn(Optional.of(discipline));
        when(disciplineRepository.save(any(Discipline.class))).thenReturn(discipline);
        when(courseService.findByIdOrFail(anyLong())).thenReturn(course);
        Discipline result = disciplineService.update(disciplineInputDTO, 1L);

        assertThat(result).isInstanceOf(Discipline.class).isNotNull().hasFieldOrPropertyWithValue("disciplineName", "teste");
        assertThat(result.getCourseId().getCourseName()).isEqualTo("teste");
    }

    @Order(6)
    @DisplayName("Testa falha de atualização de disciplina com disciplina inválida")
    @Test
    void shouldNotUpdateDisciplineWithInvalidDisciplineId() {
        DisciplineInputDTO disciplineInputDTO = new DisciplineInputDTO();
        disciplineInputDTO.setDisciplineCode("AS31B");
        disciplineInputDTO.setDisciplineName("teste");
        disciplineInputDTO.setCourseId(1L);

        Course course = new Course();
        course.setCourseName("teste");
        course.setCourseCreatedAt(LocalDateTime.of(2022, 11, 4, 10, 25));
        course.setCourseUpdatedAt(LocalDateTime.of(2022, 11, 4, 10, 26));

        Discipline discipline = new Discipline();
        discipline.setCourseId(course);
        discipline.setDisciplineName("teste");
        discipline.setDisciplineCode("AS31B");
        discipline.setDisciplineCreatedAt(LocalDateTime.of(2022, 11, 4, 10, 25));

        when(disciplineRepository.findById(anyLong())).thenReturn(Optional.of(discipline));
        when(courseService.findByIdOrFail(anyLong())).thenThrow(NoSuchElementException.class);

        assertThatThrownBy(() -> disciplineService.update(disciplineInputDTO, 1L)).isInstanceOf(NoSuchElementException.class);
    }

    @Order(7)
    @DisplayName("Testa falha de atualização de disciplina com curso inválida")
    @Test
    void shouldNotUpdateDisciplineWithInvalidCourseId() {
        DisciplineInputDTO disciplineInputDTO = new DisciplineInputDTO();
        disciplineInputDTO.setDisciplineCode("AS31B");
        disciplineInputDTO.setDisciplineName("teste");
        disciplineInputDTO.setCourseId(1L);
        when(disciplineRepository.findById(anyLong())).thenThrow(NoSuchElementException.class);

        assertThatThrownBy(() -> disciplineService.update(disciplineInputDTO, 1L)).isInstanceOf(NoSuchElementException.class);
    }
}
