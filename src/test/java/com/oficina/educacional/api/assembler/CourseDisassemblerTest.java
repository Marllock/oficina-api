package com.oficina.educacional.api.assembler;

import com.oficina.educacional.api.model.CourseDTO;
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
class CourseDisassemblerTest {

    @Autowired
    private CourseDisassembler courseDisassembler;

    @DisplayName("Testa conversão para Curso")
    @Test
    void testToModel(){
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setCourseName("Teste1");

        assertThat(courseDisassembler.toModel(courseDTO)).isInstanceOf(Course.class);
        assertThat(courseDisassembler.toModel(courseDTO).getCourseName()).isEqualTo("Teste1");
    }

    @DisplayName("Testa conversão para Curso")
    @Test
    void testToModelList(){
        CourseDTO courseDTO = new CourseDTO();
        List<CourseDTO> courseDTOList = new ArrayList<>();
        courseDTO.setCourseName("Teste1");
        courseDTOList.add(courseDTO);

        assertThat(courseDisassembler.toModel(courseDTOList)).hasSize(1);
        assertThat(courseDisassembler.toModel(courseDTOList).get(0)).isInstanceOf(Course.class);
        assertThat(courseDisassembler.toModel(courseDTOList).get(0).getCourseName()).isEqualTo("Teste1");
    }

    @DisplayName("Testa conversão para página de Curso")
    @Test
    void testToModelPage(){
        CourseDTO courseDTO = new CourseDTO();
        List<CourseDTO> courseDTOList = new ArrayList<>();
        courseDTO.setCourseName("Teste1");
        courseDTOList.add(courseDTO);
        Pageable pageable = PageRequest.of(1, 1);
        Page<CourseDTO> courseDTOPage = new PageImpl<>(courseDTOList, pageable, 1);

        assertThat(courseDisassembler.toModel(courseDTOPage).getTotalPages()).isEqualTo(2);
        assertThat(courseDisassembler.toModel(courseDTOPage).getTotalElements()).isEqualTo(2);
        assertThat(courseDisassembler.toModel(courseDTOPage).getContent()).hasSize(1);
        assertThat(courseDisassembler.toModel(courseDTOPage).getContent().get(0).getCourseName()).isEqualTo("Teste1");
    }
}