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
public class CourseAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public CourseDTO toModel(Course course) {
        return modelMapper.map(course, CourseDTO.class);
    }

    public List<CourseDTO> toModel(List<Course> courses) {
        return courses.stream().map(this::toModel).collect(Collectors.toList());
    }

    public Page<CourseDTO> toModel(Page<Course> course) {
        return course.map(this::toModel);
    }
}
