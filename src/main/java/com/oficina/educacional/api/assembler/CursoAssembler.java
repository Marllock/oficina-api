package com.oficina.educacional.api.assembler;

import com.oficina.educacional.api.model.CursoDTO;
import com.oficina.educacional.domain.model.Curso;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CursoAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public CursoDTO toModel(Curso curso) {
        return modelMapper.map(curso, CursoDTO.class);
    }

    public List<CursoDTO> toModel(List<Curso> cursos) {
        return cursos.stream().map(this::toModel).collect(Collectors.toList());
    }

    public Page<CursoDTO> toModel(Page<Curso> curso) {
        return curso.map(this::toModel);
    }
}
