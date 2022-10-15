package com.oficina.educacional.domain.service;

import com.oficina.educacional.api.model.input.DisciplineUpdateInputDTO;
import com.oficina.educacional.domain.model.Course;
import com.oficina.educacional.domain.model.Discipline;
import com.oficina.educacional.domain.repository.CourseRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class DisciplineServiceTest {

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseRepository courseRepository;

    @MockBean
    private DisciplineService disciplineService;

    @AfterEach
    public void clean() {
        courseRepository.deleteAll();
    }

    @DisplayName("Testa criação de disciplina")
    @Test
    public void shouldCreateDiscipline() {
        Course course = mock(Course.class);
        when(courseService.findByIdOrFail(1L)).thenReturn(course);
        DisciplineInputDTO disciplineInputDTO = new DisciplineInputDTO();

        Discipline discipline = disciplineService.create(disciplineInputDTO);

        assertThat(discipline.getDisciplineCode()).isEqualTo("ASBC31");
    }

    @DisplayName("Testa atualização de disciplina")
    @Test
    public void shouldUpdateDiscipline() {
        DisciplineUpdateInputDTO disciplineUpdateInputDTO = new DisciplineUpdateInputDTO();


    }
}