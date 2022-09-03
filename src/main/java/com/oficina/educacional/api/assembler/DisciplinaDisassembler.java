package com.oficina.educacional.api.assembler;

import com.oficina.educacional.api.model.DisciplinaDTO;
import com.oficina.educacional.domain.model.Disciplina;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class DisciplinaDisassembler {
    @Autowired
    private ModelMapper modelMapper;

    public Disciplina toModel(DisciplinaDTO curso) {
        return modelMapper.map(curso, Disciplina.class);
    }

    public List<Disciplina> toModel(List<DisciplinaDTO> cursos) {
        return cursos.stream().map(this::toModel).collect(Collectors.toList());
    }

    public Page<Disciplina> toModel(Page<DisciplinaDTO> curso) {
        return curso.map(this::toModel);
    }
}
