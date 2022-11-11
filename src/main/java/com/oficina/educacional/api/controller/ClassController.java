package com.oficina.educacional.api.controller;

import com.oficina.educacional.api.assembler.ClassAssembler;
import com.oficina.educacional.api.model.ClassDTO;
import com.oficina.educacional.api.model.input.ClassInputDTO;
import com.oficina.educacional.api.model.input.ClassUpdateInputDTO;
import com.oficina.educacional.domain.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClassController {

    @Autowired
    private ClassService classService;

    @Autowired
    private ClassAssembler classAssembler;

    @PostMapping("v1/class")
    public ClassDTO create(@RequestBody ClassInputDTO classInputDTO) {
        return classAssembler.toModel(classService.create(classInputDTO));
    }

    @PutMapping("v1/class/{classId}")
    public ClassDTO update(@PathVariable long classId, @RequestBody ClassInputDTO classInputDTO) {
        return classAssembler.toModel(classService.update(classInputDTO, classId));
    }

    @GetMapping("v1/class")
    public Page<ClassDTO> index(@RequestParam int page, @RequestParam int perPage, @RequestParam boolean isActive,
                                @RequestParam long courseId, @RequestParam long professorId) {
        return classAssembler.toModel(classService.index(page, perPage, isActive, courseId, professorId));
    }

    @GetMapping("v1/class/{classId}")
    public ClassDTO show(@PathVariable long classId) {
        return classAssembler.toModel(classService.show(classId));
    }

    @DeleteMapping("v1/class/{classId}")
public ResponseEntity<?> delete(@PathVariable long classId) {
        classService.delete(classId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Delete with Success");
    }
}
