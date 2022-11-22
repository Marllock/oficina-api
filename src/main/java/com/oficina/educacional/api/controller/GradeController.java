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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.Valid;

@RestController
@Tag(name = "Grades", description = "Grades controller")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @Autowired
    private GradeAssembler gradeAssembler;

    @Operation(summary = "Create a Grade", description = "create grade", tags = "grade")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = GradeDTO.class)))),
    })
    @PostMapping("v1/grades")
    public GradeDTO create(@RequestBody @Valid GradeInputDTO gradeInputDTO) {
        return gradeAssembler.toModel(gradeService.create(gradeInputDTO));
    }

    @Operation(summary = "Update a Grade", description = "update a grade", tags = "grade")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = GradeDTO.class)))),
    })
    @PutMapping("v1/grades/update")
    public GradeDTO update(@RequestBody @Valid GradeUpdateInputDTO gradeUpdateInputDTO){
        return gradeAssembler.toModel(gradeService.update(gradeUpdateInputDTO));
    }
    
    @Operation(summary = "Find all Grades", description = "find all grades", tags = "grade")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = GradeDTO.class)))),
    })
    @GetMapping("v1/grades")
    public Page<GradeDTO> index(@RequestParam int page, @RequestParam int perPage,
                                @RequestParam long studentId, @RequestParam long classId) {
        return gradeAssembler.toModel(gradeService.index(page, perPage, studentId, classId));
    }
    
    @Operation(summary = "Find one Grade", description = "find one grade", tags = "grade")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = GradeDTO.class)))),
    })
    @GetMapping("v1/grades/{gradeId}")
    public GradeDTO show(@PathVariable String gradeId){
        return gradeAssembler.toModel(gradeService.show(gradeId));
    }

    @Operation(summary = "Delete a Grade", description = "delete a grade", tags = "grade")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = String.class)))),
    })
    @DeleteMapping("v1/grades/{gradeId}")
    public ResponseEntity<String> delete(@PathVariable String gradeId) {
        gradeService.delete(gradeId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deleted with success");
    }
}
