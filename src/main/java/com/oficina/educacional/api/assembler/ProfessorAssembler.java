package com.oficina.educacional.api.assembler;

import com.oficina.educacional.api.model.ProfessorDTO;
import com.oficina.educacional.domain.model.Professor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProfessorAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public ProfessorDTO toModel(Professor professor) {
        return modelMapper.map(professor, ProfessorDTO.class);
    }

    public List<ProfessorDTO> toModel(List<Professor> professors) {
        return professors.stream().map(this::toModel).collect(Collectors.toList());
    }

    public Page<ProfessorDTO> toModel(Page<Professor> professor) {
        return professor.map(this::toModel);
    }
}
