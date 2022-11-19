package com.oficina.educacional.api.assembler;

import com.oficina.educacional.api.model.AdminDTO;
import com.oficina.educacional.domain.model.Admin;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdminAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public AdminDTO toModel(Admin admin) {
        return modelMapper.map(admin, AdminDTO.class);
    }
}
