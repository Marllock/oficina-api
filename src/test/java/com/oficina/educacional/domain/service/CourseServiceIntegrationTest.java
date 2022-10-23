package com.oficina.educacional.domain.service;

import com.oficina.educacional.api.model.input.CourseInputDTO;
import com.oficina.educacional.api.model.input.CourseUpdateInputDTO;
import com.oficina.educacional.domain.exception.EmptyResultException;
import com.oficina.educacional.domain.model.Course;
import com.oficina.educacional.domain.repository.CourseRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
@TestPropertySource("/application-test.properties")
@SpringBootTest
class CourseServiceIntegrationTest {

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseRepository courseRepository;

    @AfterEach
    public void setDown() {
        courseRepository.deleteAll();
    }

    @DisplayName("Testa criação de curso")
    @Test
    public void shouldCreateCourse(){
        CourseInputDTO courseInputDTO = new CourseInputDTO("Teste", "AS31B");
        Course course = courseService.create(courseInputDTO);

        assertThat(course.getCourseName()).isEqualTo("Teste");
    }

    @DisplayName("Testar atualização de curso")
    @Sql("/insertCourseData.sql")
    @Test
    public void shouldUpdateCourse() {
        CourseUpdateInputDTO courseUpdateInputDTO = new CourseUpdateInputDTO("teste 2", true, "AS32C");

        assertThat(courseRepository.findById(1L).isPresent()).isTrue();

        Course course = courseService.update(courseUpdateInputDTO, 1);

        assertThat(course.getCourseCode()).isEqualTo("AS32C");
    }

    @DisplayName("Testar listagem de cursos ativos")
    @Sql("/insertCourseData.sql")
    @Test
    public void shouldListActiveCourses() {
        Page<Course> courses = courseService.listCourses(0, 10, true, "");

        assertThat(courses).hasSize(3);
    }

    @DisplayName("Testar listagem de cursos inativos")
    @Sql("/insertCourseData.sql")
    @Test
    public void shouldListInactiveCourses() {
        Page<Course> courses = courseService.listCourses(0, 10, false, "");

        assertThat(courses).hasSize(1);
    }

    @DisplayName("Testar listagem de cursos com nome")
    @Sql("/insertCourseData.sql")
    @Test
    public void shouldListCoursesWithSearchName() {
        Page<Course> courses = courseService.listCourses(0, 10, null, "curso");

        assertThat(courses).hasSize(4);
    }

    @DisplayName("Testar listagem de cursos sem filtro")
    @Sql("/insertCourseData.sql")
    @Test
    public void shouldListCoursesWithoutFilter() {
        Page<Course> courses = courseService.listCourses(0, 10, null, "");
        assertThat(courses).hasSize(4);
    }

    @DisplayName("Testar listagem de cursos com todos os filtro")
    @Sql("/insertCourseData.sql")
    @Test
    public void shouldListCoursesWithAllFilter() {
        Page<Course> courses = courseService.listCourses(0, 10, true, "curso");
        assertThat(courses).hasSize(3);
    }

    @DisplayName("Testar exclusão de curso")
    @Sql("/insertCourseData.sql")
    @Test
    public void shouldDeleteCourseById() {
        courseService.delete(1L);
        assertThat(courseRepository.findById(1L).isPresent()).isFalse();
    }

    @DisplayName("Testar exceção ao excluir curos")
    @Sql("/insertCourseData.sql")
    @Test
    public void shouldThrowExceptionOnDeleteCourseById() {
        assertThatThrownBy(() -> courseService.delete(5L))
                .isInstanceOf(EmptyResultException.class)
                .hasMessage("Curso de id 5 não encontrado");
    }
}