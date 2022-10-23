package com.oficina.educacional.api.controller;

import com.oficina.educacional.api.assembler.ProfessorAssembler;
import com.oficina.educacional.api.model.ProfessorDTO;
import com.oficina.educacional.api.model.input.ProfessorInputDTO;
import com.oficina.educacional.domain.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("v1/professor")
public class ProfessorController {

    @Autowired
    private ProfessorAssembler professorAssembler;

    @Autowired
    private ProfessorService professorService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ProfessorDTO create(@RequestBody @Valid ProfessorInputDTO professorInputDTO) {
        return professorAssembler.toModel(professorService.create(professorInputDTO));
    }
}
