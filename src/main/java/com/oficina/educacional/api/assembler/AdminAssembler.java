package com.oficina.educacional.api.assembler;

import com.oficina.educacional.api.model.AdminDTO;
import com.oficina.educacional.domain.model.Admin;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AdminAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public AdminDTO toModel(Admin admin) {
        return modelMapper.map(admin, AdminDTO.class);
    }

    public List<AdminDTO> toModel(List<Admin> admins) {
        return admins.stream().map(this::toModel).collect(Collectors.toList());
    }

    public Page<AdminDTO> toModel(Page<Admin> admins) {
        return admins.map(this::toModel);
    }
}
