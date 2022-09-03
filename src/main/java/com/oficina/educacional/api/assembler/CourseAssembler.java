package com.oficina.educacional.api.assembler;

import com.oficina.educacional.api.model.CursoDTO;
import com.oficina.educacional.domain.model.Course;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CourseAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public CursoDTO toModel(Course course) {
        return modelMapper.map(course, CursoDTO.class);
    }

    public List<CursoDTO> toModel(List<Course> courses) {
        return courses.stream().map(this::toModel).collect(Collectors.toList());
    }

    public Page<CursoDTO> toModel(Page<Course> course) {
        return course.map(this::toModel);
    }
}
