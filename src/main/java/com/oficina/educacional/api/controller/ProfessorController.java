package com.oficina.educacional.api.controller;

import com.oficina.educacional.api.assembler.ProfessorAssembler;
import com.oficina.educacional.api.model.ProfessorDTO;
import com.oficina.educacional.api.model.input.ProfessorInputDTO;
import com.oficina.educacional.api.model.input.ProfessorSearchInputDTO;
import com.oficina.educacional.api.model.input.ProfessorUpdateInputDTO;
import com.oficina.educacional.domain.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @PostMapping("v1/professor")
    public ProfessorDTO create(@RequestBody @Valid ProfessorInputDTO professorInputDTO) {
        return professorAssembler.toModel(professorService.create(professorInputDTO));
    }

    @GetMapping("v1/professor")
    public Page<ProfessorDTO> index(@RequestBody @Valid ProfessorSearchInputDTO professorSearchInputDTO) {
        return professorAssembler.toModel(professorService.index(professorSearchInputDTO));
    }

    @PutMapping("v1/professor/{professorId}")
    public ProfessorDTO update(@RequestBody @Valid ProfessorUpdateInputDTO professorUpdateInputDTO,
                               @RequestParam long professorId) {
        return professorAssembler.toModel(professorService.update(professorUpdateInputDTO, professorId));
    }

    @GetMapping("v1/professor/{professorId}")
    public ProfessorDTO show(@PathVariable long professorId) {
        return professorAssembler.toModel(professorService.show(professorId));
    }

    @DeleteMapping("v1/professor/{professorId}")
    public ResponseEntity<String> delete(@PathVariable long professorId) {
        professorService.delete(professorId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Professor deleted");
    }
}
