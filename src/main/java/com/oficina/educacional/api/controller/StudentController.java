package com.oficina.educacional.api.controller;

import com.oficina.educacional.api.assembler.StudentAssembler;
import com.oficina.educacional.api.model.StudentDTO;
import com.oficina.educacional.api.model.input.StudentInputDTO;
import com.oficina.educacional.api.model.input.StudentUpdateInputDTO;
import com.oficina.educacional.domain.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentAssembler studentAssembler;

    @PostMapping("v1/student")
    public StudentDTO create(@RequestBody @Valid StudentInputDTO studentInputDTO) {

        return studentAssembler.toModel(studentService.create(studentInputDTO));
    }
    
    @PutMapping("v1/student/{studentId}")
    public StudentDTO update(@RequestBody @Valid StudentUpdateInputDTO studentUpdateInputDTO,
                             @PathVariable long studentId) {
        return studentAssembler.toModel(studentService.update(studentUpdateInputDTO, studentId));
    }

    @GetMapping("v1/student")
    Page<StudentDTO> index(@RequestParam int page, @RequestParam int perPage, @RequestParam(required = false) Long courseId) {
        return studentAssembler.toModel(studentService.index(page, perPage, courseId));
    }

    @GetMapping("v1/student/{studentId}")
    public StudentDTO show(@PathVariable long studentId) {

        return studentAssembler.toModel(studentService.show(studentId));
    }

    @DeleteMapping("v1/student/{studentId}")
    public ResponseEntity<String> delete(@PathVariable long studentId) {
        studentService.delete(studentId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Student deleted successfully");
    }
}
