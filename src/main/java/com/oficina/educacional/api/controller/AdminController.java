package com.oficina.educacional.api.controller;

import com.oficina.educacional.api.assembler.AdminAssembler;
import com.oficina.educacional.api.model.AdminDTO;
import com.oficina.educacional.api.model.input.AdminInputDTO;
import com.oficina.educacional.api.model.input.AdminUpdateInputDTO;
import com.oficina.educacional.domain.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private AdminAssembler adminAssembler;

    @PostMapping("v1/admin")
    public AdminDTO create(@RequestBody @Valid AdminInputDTO adminInputDTO){
        return adminAssembler.toModel(adminService.create(adminInputDTO));
    }

    @PutMapping("v1/admin/{adminId}")
    public AdminDTO update(@RequestBody @Valid AdminUpdateInputDTO adminUpdateInputDTO, @PathVariable long adminId) {
        return adminAssembler.toModel(adminService.update(adminUpdateInputDTO, adminId));
    }

    @GetMapping("v1/admin/{adminId}")
    public AdminDTO show(@PathVariable long adminId) {
        return adminAssembler.toModel(adminService.show(adminId));
    }
}
