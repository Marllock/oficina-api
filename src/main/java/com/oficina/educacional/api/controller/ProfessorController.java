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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.Valid;

@RestController
@RequestMapping("v1/professor")
@Tag(name = "Professor", description = "professor controller")
public class ProfessorController {

    @Autowired
    private ProfessorAssembler professorAssembler;

    @Autowired
    private ProfessorService professorService;

    @Operation(summary = "Create a Professor", description = "create professor", tags = "professor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = ProfessorDTO.class)))),
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("v1/professor")
    public ProfessorDTO create(@RequestBody @Valid ProfessorInputDTO professorInputDTO) {
        return professorAssembler.toModel(professorService.create(professorInputDTO));
    }

    @Operation(summary = "Find all Professors", description = "find all professor with filters", tags = "professor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = ProfessorDTO.class)))),
    })
    @GetMapping("v1/professor")
    public Page<ProfessorDTO> index(@RequestBody @Valid ProfessorSearchInputDTO professorSearchInputDTO) {
        return professorAssembler.toModel(professorService.index(professorSearchInputDTO));
    }

    @Operation(summary = "Update a Professor", description = "update a professor", tags = "professor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = ProfessorDTO.class)))),
    })
    @PutMapping("v1/professor/{professorId}")
    public ProfessorDTO update(@RequestBody @Valid ProfessorUpdateInputDTO professorUpdateInputDTO,
                               @RequestParam long professorId) {
        return professorAssembler.toModel(professorService.update(professorUpdateInputDTO, professorId));
    }

    @Operation(summary = "Find one Professor", description = "Find one professor", tags = "professor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = ProfessorDTO.class)))),
    })
    @GetMapping("v1/professor/{professorId}")
    public ProfessorDTO show(@PathVariable long professorId) {
        return professorAssembler.toModel(professorService.show(professorId));
    }

    @Operation(summary = "Create a Professor", description = "create professor", tags = "professor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = String.class)))),
    })
    @DeleteMapping("v1/professor/{professorId}")
    public ResponseEntity<String> delete(@PathVariable long professorId) {
        professorService.delete(professorId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Professor deleted");
    }
}
