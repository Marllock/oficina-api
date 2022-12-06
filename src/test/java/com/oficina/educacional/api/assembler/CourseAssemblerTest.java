package com.oficina.educacional.api.assembler;

import com.oficina.educacional.domain.model.Course;
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
class CourseAssemblerTest {

    @Autowired
    private CourseAssembler courseAssembler;

    @DisplayName("Testa conversão de DTO para entidade")
    @Test
    void toModel() {
        Course course = new Course();
        course.setCourseName("Teste1");
        assertThat(courseAssembler.toModel(course).getCourseName()).isEqualTo("Teste1");
    }

    @DisplayName("Testa conversão para listagem de cursos")
    @Test
    void testToModelList() {
        Course course = new Course();
        List<Course> courseList = new ArrayList<>();

        course.setCourseName("Teste1");
        courseList.add(course);

        assertThat(courseAssembler.toModel(courseList)).hasSize(1);
        assertThat(courseAssembler.toModel(courseList).get(0).getCourseName()).isEqualTo("Teste1");
    }

    @DisplayName("Testa conversão para página de Cursos")
    @Test
    void testToModelPage() {
        Course course = new Course();
        List<Course> courseList = new ArrayList<>();

        course.setCourseName("Teste1");

        courseList.add(course);

        Pageable pageable = PageRequest.of(1, 1);
        Page<Course> coursePage = new PageImpl<>(courseList, pageable, 1);

        assertThat(courseAssembler.toModel(coursePage)).hasSize(1);
        assertThat(courseAssembler.toModel(coursePage).getContent().get(0).getCourseName()).isEqualTo("Teste1");
    }
}