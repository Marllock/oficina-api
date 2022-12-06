package com.oficina.educacional.api.assembler;

import com.oficina.educacional.api.model.GradeDTO;
import com.oficina.educacional.domain.model.Grade;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class GradeAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public GradeDTO toModel(Grade grade) {
        return modelMapper.map(grade, GradeDTO.class);
    }

    public Page<GradeDTO> toModel(Page<Grade> grades) {
        return grades.map(this::toModel);
    }
}
