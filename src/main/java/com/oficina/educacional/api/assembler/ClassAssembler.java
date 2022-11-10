package com.oficina.educacional.api.assembler;

import com.oficina.educacional.api.model.ClassDTO;
import com.oficina.educacional.domain.model.Class;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClassAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public ClassDTO toModel(Class classObject){
        return modelMapper.map(classObject, ClassDTO.class);
    }

    public List<ClassDTO> toModel(List<Class> listClass) {
        return listClass.stream().map(this::toModel).collect(Collectors.toList());
    }

    public Page<ClassDTO> toModel(Page<Class> pageClass) {
        return pageClass.map(this::toModel);
    }
}
