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
public class DisciplineDisassembler {
    @Autowired
    private ModelMapper modelMapper;

    public Discipline toModel(DisciplineDTO curso) {
        return modelMapper.map(curso, Discipline.class);
    }

    public List<Discipline> toModel(List<DisciplineDTO> cursos) {
        return cursos.stream().map(this::toModel).collect(Collectors.toList());
    }

    public Page<Discipline> toModel(Page<DisciplineDTO> curso) {
        return curso.map(this::toModel);
    }
}
