package com.oficina.educacional.domain.service;

import com.oficina.educacional.api.model.input.CourseInputDTO;
import com.oficina.educacional.domain.model.Course;
import com.oficina.educacional.domain.repository.CourseRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class CourseServiceTest {

    @Mock
    private CourseRepository courseRepository;

    @InjectMocks
    private CourseService courseService;

    @AfterEach
    void tearDown() throws Exception {
        courseRepository.deleteAll();
    }

    @Test
    public void shouldCreateCourse() {
        CourseInputDTO courseInputDTO = new CourseInputDTO("Exatas", "AS31B");
        Course course = courseService.create(courseInputDTO);
        assertThat(course).isNotNull();
    }
}