package com.oficina.educacional.api.assembler;

import com.oficina.educacional.api.model.StudentDTO;
import com.oficina.educacional.domain.model.User;
import org.junit.jupiter.api.BeforeAll;
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
class StudentDisassemblerTest {
    @Autowired
    private StudentDisassembler studentDisassembler;

    private static final User user = new User();

    @BeforeAll
    static void setUp() {
        user.setUserName("Test1");
    }

    @DisplayName("Testa conversão de DTO para entidade")
    @Test
    void toModel() {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setUser(user);
        assertThat(studentDisassembler.toModel(studentDTO).getUser().getUserName()).isEqualTo("Test1");
    }

    @DisplayName("Testa conversão para listagem de student")
    @Test
    void testToModelList() {
        StudentDTO studentDTO = new StudentDTO();
        List<StudentDTO> studentDTOList = new ArrayList<>();

        studentDTO.setUser(user);
        studentDTOList.add(studentDTO);

        assertThat(studentDisassembler.toModel(studentDTOList)).hasSize(1);
        assertThat(studentDisassembler.toModel(studentDTOList).get(0).getUser().getUserName()).isEqualTo("Test1");
    }

    @DisplayName("Testa conversão para página de student")
    @Test
    void testToModelPage() {
        StudentDTO student = new StudentDTO();
        List<StudentDTO> studentList = new ArrayList<>();

        student.setUser(user);

        studentList.add(student);
        Pageable pageable = PageRequest.of(1, 1);
        Page<StudentDTO> studentPage = new PageImpl<>(studentList, pageable, 1);

        assertThat(studentDisassembler.toModel(studentPage)).hasSize(1);
        assertThat(studentDisassembler.toModel(studentPage).getContent().get(0).getUser().getUserName()).isEqualTo("Test1");
    }
}