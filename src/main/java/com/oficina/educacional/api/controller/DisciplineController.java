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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.Valid;

@RestController
@Tag(name = "Discipline", description = "discipline controller")
public class DisciplineController {

    @Autowired
    private DisciplineService disciplineService;

    @Autowired
    private DisciplineAssembler disciplineAssembler;

    @Operation(summary = "Create a Discipline", description = "create a discipline", tags = "discipline")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = DisciplineDTO.class)))),
    })
    @PostMapping("/v1/discipline")
    public DisciplineDTO create(@RequestBody @Valid DisciplineInputDTO disciplineInputDTO) {
        return disciplineAssembler.toModel(disciplineService.create(disciplineInputDTO));
    }

    @Operation(summary = "Update a Discipline", description = "Update a discipline", tags = "discipline")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = DisciplineDTO.class)))),
    })
    @PutMapping("/v1/discipline/{disciplineId}")
    public DisciplineDTO update(@RequestBody @Valid DisciplineInputDTO disciplineInputDTO, @PathVariable long disciplineId) {
        return disciplineAssembler.toModel(disciplineService.update(disciplineInputDTO, disciplineId));
    }

    @Operation(summary = "Find all Discipline", description = "Find all discipline with filter", tags = "discipline")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = DisciplineDTO.class)))),
    })
    @GetMapping("/v1/discipline")
    public Page<DisciplineDTO> index(@RequestParam(defaultValue = "10") int perPage, @RequestParam(defaultValue = "1") int page,
                                     @RequestParam(defaultValue = "") String disciplineName, @RequestParam(defaultValue = "") String disciplineCode,
                                     @RequestParam(defaultValue = "0") long courseId) {

        return disciplineAssembler.toModel(disciplineService.index(perPage, page, disciplineName, disciplineCode, courseId));
    }

    @Operation(summary = "Find one Discipline", description = "find one discipline", tags = "discipline")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = DisciplineDTO.class)))),
    })
    @GetMapping("/v1/discipline/{disciplineId}")
    public ResponseEntity<DisciplineDTO> show(@PathVariable long disciplineId) {
        return ResponseEntity.ok(disciplineAssembler.toModel(disciplineService.show(disciplineId)));
    }

    @Operation(summary = "Delete a Discipline", description = "delete a discipline", tags = "discipline")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = String.class)))),
    })
    @DeleteMapping("/v1/discipline/{disciplineId}")
    public ResponseEntity<String> delete(@PathVariable long disciplineId) {
        return new ResponseEntity<>("Discipline deleted successfully", HttpStatus.NO_CONTENT);
    }
}
