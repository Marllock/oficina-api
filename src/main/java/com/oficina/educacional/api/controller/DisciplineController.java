package com.oficina.educacional.api.controller;

import com.oficina.educacional.api.assembler.DisciplineAssembler;
import com.oficina.educacional.api.model.DisciplineDTO;
import com.oficina.educacional.api.model.input.DisciplineInputDTO;
import com.oficina.educacional.domain.service.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/discipline")
public class DisciplineController {

    @Autowired
    private DisciplineService disciplineService;

    @Autowired
    private DisciplineAssembler disciplineAssembler;

    @PostMapping
    public DisciplineDTO create(@RequestBody @Valid DisciplineInputDTO disciplineInputDTO) {
        return disciplineAssembler.toModel(disciplineService.create(disciplineInputDTO));
    }

    @PutMapping("/{disciplineId}")
    public DisciplineDTO update(@RequestBody @Valid DisciplineInputDTO disciplineInputDTO, @PathVariable long disciplineId) {
        return disciplineAssembler.toModel(disciplineService.update(disciplineInputDTO, disciplineId));
    }

    @GetMapping
    public Page<DisciplineDTO> index(@RequestParam int perPage, @RequestParam int page,
                                     @RequestParam String disciplineName, @RequestParam String disciplineCode,
                                     @RequestParam long courseId) {

        return disciplineAssembler.toModel(disciplineService.index(perPage, page, disciplineName, disciplineCode, courseId));
    }

    @DeleteMapping("/{disciplineId}")
    public ResponseEntity<String> delete(@PathVariable long disciplineId) {
        return new ResponseEntity<>("Discipline deleted successfully", HttpStatus.NO_CONTENT);
    }
}
