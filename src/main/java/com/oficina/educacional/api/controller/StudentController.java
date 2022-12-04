package com.oficina.educacional.api.controller;

import com.oficina.educacional.api.assembler.StudentAssembler;
import com.oficina.educacional.api.model.StudentDTO;
import com.oficina.educacional.api.model.input.StudentInputDTO;
import com.oficina.educacional.api.model.input.StudentUpdateInputDTO;
import com.oficina.educacional.domain.service.StudentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping
@Tag(name = "student", description = "student controller")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentAssembler studentAssembler;

    @Operation(summary = "Create a Student", description = "create student", tags = "student")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = StudentDTO.class)))),
    })
    @PostMapping("v1/student")
    public StudentDTO create(@RequestBody @Valid StudentInputDTO studentInputDTO) {

        return studentAssembler.toModel(studentService.create(studentInputDTO));
    }

    @Operation(summary = "Update a Student", description = "update student", tags = "student")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = StudentDTO.class)))),
    })
    @PutMapping("v1/student/{studentId}")
    public StudentDTO update(@RequestBody @Valid StudentUpdateInputDTO studentUpdateInputDTO,
            @PathVariable long studentId) {
        return studentAssembler.toModel(studentService.update(studentUpdateInputDTO, studentId));
    }

    @Operation(summary = "Find all Student", description = "find all students with filters", tags = "student")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = StudentDTO.class)))),
    })
    @GetMapping("v1/student")
    Page<StudentDTO> index(@RequestParam int page, @RequestParam int perPage,
            @RequestParam(required = false) Long courseId, @RequestParam(required = false) String studentName) {
        return studentAssembler.toModel(studentService.index(page, perPage, courseId, studentName));
    }

    @Operation(summary = "Find one Student", description = "find one student", tags = "student")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = StudentDTO.class)))),
    })
    @GetMapping("v1/student/{studentId}")
    public StudentDTO show(@PathVariable long studentId) {
        return studentAssembler.toModel(studentService.show(studentId));
    }

    @Operation(summary = "Delete a Student", description = "delete student", tags = "student")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = String.class)))),
    })
    @DeleteMapping("v1/student/{studentId}")
    public ResponseEntity<String> delete(@PathVariable long studentId) {
        studentService.delete(studentId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Student deleted successfully");
    }
}
