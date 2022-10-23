package com.oficina.educacional.api.controller;

import com.oficina.educacional.api.model.StudentDTO;
import com.oficina.educacional.api.model.input.StudentInputDTO;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("v1/student")
public class StudentController {

    @PostMapping
    public StudentDTO create(@RequestBody @Valid StudentInputDTO studentInputDTO) {
        return null;
    }

    @GetMapping
    Page<StudentDTO> index(@RequestParam long page, @RequestParam long perPage, @RequestParam long courseId) {
        return null;
    }

    @GetMapping("{studentId}")
    public StudentDTO show(@PathVariable long studentId) {
        return null;
    }

    @DeleteMapping("{studentId}")
    public ResponseEntity<String> delete(@PathVariable long studentId) {
        return null;
    }
}
