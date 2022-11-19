package com.oficina.educacional.api.assembler;

import com.oficina.educacional.api.model.StudentDTO;
import com.oficina.educacional.domain.model.Student;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentDisassembler {
    @Autowired
    private ModelMapper modelMapper;

    public Student toModel(StudentDTO student) {
        return modelMapper.map(student, Student.class);
    }

    public List<Student> toModel(List<StudentDTO> students) {
        return students.stream().map(this::toModel).collect(Collectors.toList());
    }

    public Page<Student> toModel(Page<StudentDTO> student) {
        return student.map(this::toModel);
    }
}
