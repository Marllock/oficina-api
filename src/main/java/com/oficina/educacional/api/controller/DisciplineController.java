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
public class DisciplineController {

    @Autowired
    private DisciplineService disciplineService;

    @Autowired
    private DisciplineAssembler disciplineAssembler;

    @PostMapping("/v1/discipline")
    public DisciplineDTO create(@RequestBody @Valid DisciplineInputDTO disciplineInputDTO) {
        return disciplineAssembler.toModel(disciplineService.create(disciplineInputDTO));
    }

    @PutMapping("/v1/discipline/{disciplineId}")
    public DisciplineDTO update(@RequestBody @Valid DisciplineInputDTO disciplineInputDTO, @PathVariable long disciplineId) {
        return disciplineAssembler.toModel(disciplineService.update(disciplineInputDTO, disciplineId));
    }

    @GetMapping("/v1/discipline")
    public Page<DisciplineDTO> index(@RequestParam(defaultValue = "10") int perPage, @RequestParam(defaultValue = "1") int page,
                                     @RequestParam(defaultValue = "") String disciplineName, @RequestParam(defaultValue = "") String disciplineCode,
                                     @RequestParam(defaultValue = "0") long courseId) {

        return disciplineAssembler.toModel(disciplineService.index(perPage, page, disciplineName, disciplineCode, courseId));
    }

    @GetMapping("/v1/discipline/{disciplineId}")
    public ResponseEntity<DisciplineDTO> show(@PathVariable long disciplineId) {
        return ResponseEntity.ok(disciplineAssembler.toModel(disciplineService.show(disciplineId)));
    }

    @DeleteMapping("/v1/discipline/{disciplineId}")
    public ResponseEntity<String> delete(@PathVariable long disciplineId) {
        return new ResponseEntity<>("Discipline deleted successfully", HttpStatus.NO_CONTENT);
    }
}
