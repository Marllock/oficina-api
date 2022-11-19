package com.oficina.educacional.api.controller;

import com.oficina.educacional.api.assembler.GradeAssembler;
import com.oficina.educacional.api.model.GradeDTO;
import com.oficina.educacional.api.model.input.GradeInputDTO;
import com.oficina.educacional.api.model.input.GradeUpdateInputDTO;
import com.oficina.educacional.domain.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @Autowired
    private GradeAssembler gradeAssembler;

    @PostMapping("v1/grades")
    public GradeDTO create(@RequestBody @Valid GradeInputDTO gradeInputDTO) {
        return gradeAssembler.toModel(gradeService.create(gradeInputDTO));
    }

    @PutMapping("v1/grades/update")
    public GradeDTO update(@RequestBody @Valid GradeUpdateInputDTO gradeUpdateInputDTO){
        return gradeAssembler.toModel(gradeService.update(gradeUpdateInputDTO));
    }
    
    @GetMapping("v1/grades")
    public Page<GradeDTO> index(@RequestParam int page, @RequestParam int perPage,
                                @RequestParam long studentId, @RequestParam long classId) {
        return gradeAssembler.toModel(gradeService.index(page, perPage, studentId, classId));
    }
    
    @GetMapping("v1/grades/{gradeId}")
    public GradeDTO show(@PathVariable String gradeId){
        return gradeAssembler.toModel(gradeService.show(gradeId));
    }

    @DeleteMapping("v1/grades/{gradeId}")
    public ResponseEntity<String> delete(@PathVariable String gradeId) {
        gradeService.delete(gradeId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deleted with success");
    }
}
