package com.oficina.educacional.api.assembler;

import com.oficina.educacional.api.model.CursoDTO;
import com.oficina.educacional.api.model.DisciplinaDTO;
import com.oficina.educacional.domain.model.Curso;
import com.oficina.educacional.domain.model.Disciplina;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class DisciplinaAssembler {
    @Autowired
    private ModelMapper modelMapper;

    public DisciplinaDTO toModel(Disciplina curso) {
        return modelMapper.map(curso, DisciplinaDTO.class);
    }

    public List<DisciplinaDTO> toModel(List<Disciplina> cursos) {
        return cursos.stream().map(this::toModel).collect(Collectors.toList());
    }

    public Page<DisciplinaDTO> toModel(Page<Disciplina> curso) {
        return curso.map(this::toModel);
    }
}
