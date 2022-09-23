package com.oficina.educacional.api.assembler;

import com.oficina.educacional.api.model.CourseDTO;
import com.oficina.educacional.domain.model.Course;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CourseDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Course toModel(CourseDTO curso) {
        return modelMapper.map(curso, Course.class);
    }

    public List<Course> toModel(List<CourseDTO> cursos) {
        return cursos.stream().map(this::toModel).collect(Collectors.toList());
    }

    public Page<Course> toModel(Page<CourseDTO> curso) {
        return curso.map(this::toModel);
    }
}