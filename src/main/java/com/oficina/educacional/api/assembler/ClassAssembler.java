package com.oficina.educacional.api.assembler;

import com.oficina.educacional.api.model.ClassDTO;
import com.oficina.educacional.domain.model.Class;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class ClassAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public ClassDTO toModel(Class classObject){
        return modelMapper.map(classObject, ClassDTO.class);
    }

    public Page<ClassDTO> toModel(Page<Class> pageClass) {
        return pageClass.map(this::toModel);
    }
}
