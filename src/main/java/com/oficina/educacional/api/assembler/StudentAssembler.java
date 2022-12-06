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
public class StudentAssembler {
    @Autowired
    private ModelMapper modelMapper;

    public StudentDTO toModel(Student student) {
        return modelMapper.map(student, StudentDTO.class);
    }

    public List<StudentDTO> toModel(List<Student> students) {
        return students.stream().map(this::toModel).collect(Collectors.toList());
    }

    public Page<StudentDTO> toModel(Page<Student> student) {
        return student.map(this::toModel);
    }
}
