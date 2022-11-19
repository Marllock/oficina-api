package com.oficina.educacional.api.assembler;

import com.oficina.educacional.api.model.DisciplineDTO;
import com.oficina.educacional.domain.model.Discipline;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DisciplineAssembler {
    @Autowired
    private ModelMapper modelMapper;

    public DisciplineDTO toModel(Discipline course) {
        return modelMapper.map(course, DisciplineDTO.class);
    }

    public List<DisciplineDTO> toModel(List<Discipline> courses) {
        return courses.stream().map(this::toModel).collect(Collectors.toList());
    }

    public Page<DisciplineDTO> toModel(Page<Discipline> course) {
        return course.map(this::toModel);
    }
}
