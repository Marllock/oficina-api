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
public class ProfessorDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Professor toModel(ProfessorDTO professor) {
        return modelMapper.map(professor, Professor.class);
    }

    public List<Professor> toModel(List<ProfessorDTO> professors) {
        return professors.stream().map(this::toModel).collect(Collectors.toList());
    }

    public Page<Professor> toModel(Page<ProfessorDTO> professor) {
        return professor.map(this::toModel);
    }
}
