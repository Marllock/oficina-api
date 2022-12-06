package com.oficina.educacional.api.controller;

import com.oficina.educacional.api.assembler.ClassAssembler;
import com.oficina.educacional.api.model.ClassDTO;
import com.oficina.educacional.api.model.input.ClassInputDTO;
import com.oficina.educacional.domain.service.ClassService;
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

@RestController
@Tag(name = "Class", description = "Class controller")
public class ClassController {

    @Autowired
    private ClassService classService;

    @Autowired
    private ClassAssembler classAssembler;

    @Operation(summary = "Create a Class", description = "create a class", tags = "class")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = ClassDTO.class)))),
    })
    @PostMapping("v1/class")
    public ClassDTO create(@RequestBody ClassInputDTO classInputDTO) {
        return classAssembler.toModel(classService.create(classInputDTO));
    }

    @Operation(summary = "Update a Class", description = "update a class", tags = "class")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = ClassDTO.class)))),
    })
    @PutMapping("v1/class/{classId}")
    public ClassDTO update(@PathVariable long classId, @RequestBody ClassInputDTO classInputDTO) {
        return classAssembler.toModel(classService.update(classInputDTO, classId));
    }

    @Operation(summary = "Find all Class", description = "find all class", tags = "class")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = ClassDTO.class)))),
    })
    @GetMapping("v1/class")
    public Page<ClassDTO> index(@RequestParam int page, @RequestParam int perPage, @RequestParam boolean isActive,
                                @RequestParam long courseId, @RequestParam long professorId) {
        return classAssembler.toModel(classService.index(page, perPage, isActive, courseId, professorId));
    }

    @Operation(summary = "Find one Class", description = "find one class", tags = "class")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = ClassDTO.class)))),
    })
    @GetMapping("v1/class/{classId}")
    public ClassDTO show(@PathVariable long classId) {
        return classAssembler.toModel(classService.show(classId));
    }

    @Operation(summary = "Delete a Class", description = "delete a class", tags = "class")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = String.class)))),
    })
    @DeleteMapping("v1/class/{classId}")
public ResponseEntity<String> delete(@PathVariable long classId) {
        classService.delete(classId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Delete with Success");
    }
}
