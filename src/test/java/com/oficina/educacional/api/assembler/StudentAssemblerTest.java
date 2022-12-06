package com.oficina.educacional.api.assembler;

import com.oficina.educacional.domain.model.Student;
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
class StudentAssemblerTest {
    @Autowired
    private StudentAssembler studentAssembler;

    private static final User user = new User();

    @BeforeAll
    static void setUp() {
        user.setUserName("Test1");
    }

    @DisplayName("Testa conversão de DTO para entidade")
    @Test
    void toModel() {
        Student student = new Student();
        student.setUser(user);
        assertThat(studentAssembler.toModel(student).getUser().getUserName()).isEqualTo("Test1");
    }

    @DisplayName("Testa conversão para listagem de student")
    @Test
    void testToModelList() {
        Student student = new Student();
        List<Student> studentList = new ArrayList<>();

        student.setUser(user);
        studentList.add(student);

        assertThat(studentAssembler.toModel(studentList)).hasSize(1);
        assertThat(studentAssembler.toModel(studentList).get(0).getUser().getUserName()).isEqualTo("Test1");
    }

    @DisplayName("Testa conversão para página de student")
    @Test
    void testToModelPage() {
        Student student = new Student();
        List<Student> studentList = new ArrayList<>();

        student.setUser(user);

        studentList.add(student);
        Pageable pageable = PageRequest.of(1, 1);
        Page<Student> studentPage = new PageImpl<>(studentList, pageable, 1);

        assertThat(studentAssembler.toModel(studentPage)).hasSize(1);
        assertThat(studentAssembler.toModel(studentPage).getContent().get(0).getUser().getUserName()).isEqualTo("Test1");
    }
}