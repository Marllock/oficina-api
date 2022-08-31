package com.oficina.educacional.api.controller;

import com.oficina.educacional.api.assembler.CursoAssembler;
import com.oficina.educacional.api.model.CursoDTO;
import com.oficina.educacional.api.model.input.CursoInputDTO;
import com.oficina.educacional.domain.model.Curso;
import com.oficina.educacional.domain.service.CursoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/v1/curso")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @Autowired
    private CursoAssembler cursoAssembler;

//    @ApiOperation(value = "Cria curso")
//    @ResponseStatus(HttpStatus.CREATED)
//    @GetMapping("")
//    public CursoDTO createCourse(@RequestBody @Valid CursoInputDTO cursoInputDTO) {
//        Curso curso = cursoService.createCurso(cursoInputDTO);
//        return cursoAssembler.toModel(curso);
//    }
}
