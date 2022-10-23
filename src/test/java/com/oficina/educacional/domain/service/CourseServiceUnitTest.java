package com.oficina.educacional.domain.service;

import com.oficina.educacional.api.model.input.CourseInputDTO;
import com.oficina.educacional.api.model.input.CourseUpdateInputDTO;
import com.oficina.educacional.domain.exception.EmptyResultException;
import com.oficina.educacional.domain.model.Course;
import com.oficina.educacional.domain.repository.CourseRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class CourseServiceUnitTest {

    @MockBean
    private CourseRepository courseRepository;

    @Autowired
    private CourseService courseService;

    @Order(1)
    @DisplayName("Testa criação de curso")
    @Test
    void shouldCreateCourse() {
        Course course = new Course();
        CourseInputDTO courseInputDTO = new CourseInputDTO("teste", "AS31B");
        course.setCourseName("teste");
        course.setCourseNormalizedName("teste");
        course.setCourseIsActive(true);
        course.setCourseCode("AS31B");
        when(courseRepository.save(any(Course.class))).thenReturn(course);

        assertThat(courseService.create(courseInputDTO)).hasFieldOrPropertyWithValue("courseName", "teste");
        verify(courseRepository, times(1)).save(any(Course.class));
    }

    @Order(2)
    @DisplayName("Testa atualização de curso com nome")
    @Test
    void shouldUpdateCourseWithName() {
        Course course = new Course();
        CourseUpdateInputDTO courseUpdateInputDTO = new CourseUpdateInputDTO("teste", null, null);
        course.setCourseName("teste");
        when(courseRepository.findById(anyLong())).thenReturn(Optional.of(course));
        when(courseRepository.save(any(Course.class))).thenReturn(course);
        assertThat(courseService.update(courseUpdateInputDTO, 1L))
                .isInstanceOf(Course.class)
                .isEqualTo(course);

        verify(courseRepository, times(1)).save(any(Course.class));
        verify(courseRepository, times(1)).findById(anyLong());
    }

    @Order(3)
    @DisplayName("Testa atualização de curso com código")
    @Test
    void shouldUpdateCourseWithCode() {
        Course course = new Course();
        CourseUpdateInputDTO courseUpdateInputDTO = new CourseUpdateInputDTO(null, null, "AS31B");
        course.setCourseCode("AS31A");
        when(courseRepository.findById(anyLong())).thenReturn(Optional.of(course));
        when(courseRepository.save(any(Course.class))).thenReturn(course);
        assertThat(courseService.update(courseUpdateInputDTO, 1L))
                .isInstanceOf(Course.class)
                .isEqualTo(course);

        verify(courseRepository, times(1)).save(any(Course.class));
        verify(courseRepository, times(1)).findById(anyLong());
    }

    @Order(4)
    @DisplayName("Testa atualização de curso com flag ativo")
    @Test
    void shouldUpdateCourseWithActive() {
        Course course = new Course();
        CourseUpdateInputDTO courseUpdateInputDTO = new CourseUpdateInputDTO(null, true, null);
        course.setCourseIsActive(true);
        when(courseRepository.findById(anyLong())).thenReturn(Optional.of(course));
        when(courseRepository.save(any(Course.class))).thenReturn(course);
        assertThat(courseService.update(courseUpdateInputDTO, 1L))
                .isInstanceOf(Course.class)
                .isEqualTo(course);

        verify(courseRepository, times(1)).save(any(Course.class));
        verify(courseRepository, times(1)).findById(anyLong());
    }

    @Order(5)
    @DisplayName("Testa atualização de curso completo")
    @Test
    void shouldUpdateCourseWithComplete() {
        Course course = new Course();
        CourseUpdateInputDTO courseUpdateInputDTO = new CourseUpdateInputDTO("teste", true, "AS31A");
        course.setCourseIsActive(true);
        when(courseRepository.findById(anyLong())).thenReturn(Optional.of(course));
        when(courseRepository.save(any(Course.class))).thenReturn(course);
        assertThat(courseService.update(courseUpdateInputDTO, 1L))
                .isInstanceOf(Course.class)
                .isEqualTo(course);

        verify(courseRepository, times(1)).save(any(Course.class));
        verify(courseRepository, times(1)).findById(anyLong());
    }

    @Order(6)
    @DisplayName("Testa falha atualização de curso com id inválido")
    @Test
    void shouldNotUpdateCourseWithInvalidId() {
        Course course = new Course();
        CourseUpdateInputDTO courseUpdateInputDTO = new CourseUpdateInputDTO(null, true, null);
        course.setCourseIsActive(true);
        when(courseRepository.findById(anyLong())).thenThrow(new NoSuchElementException("Elemento não encontrado"));

        assertThatThrownBy(() -> {
            courseService.update(courseUpdateInputDTO, 1L);
        })
                .isInstanceOf(NoSuchElementException.class)
                .hasMessage("Elemento não encontrado");
        verify(courseRepository, times(1)).findById(anyLong());
    }

    @Order(7)
    @DisplayName("Testa deleção de cursos")
    @Test
    void shouldDeleteCourses() {
        doNothing().when(courseRepository).deleteById(anyLong());
        courseService.delete(1L);
        verify(courseRepository, times(1)).deleteById(anyLong());
    }

    @Order(8)
    @DisplayName("Testa exceção na deleção de cursos")
    @Test
    void shouldNotDeleteCourses() {
        doThrow(new EmptyResultException("Curso de id 1 não encontrado")).when(courseRepository).deleteById(anyLong());
        assertThatThrownBy(() -> {
            courseService.delete(1L);
        })
                .isInstanceOf(EmptyResultException.class)
                .hasMessage("Curso de id 1 não encontrado");
        verify(courseRepository, times(1)).deleteById(anyLong());
    }
}
