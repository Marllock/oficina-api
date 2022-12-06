package com.oficina.educacional.api.controller;

import com.oficina.educacional.api.assembler.AdminAssembler;
import com.oficina.educacional.api.model.AdminDTO;
import com.oficina.educacional.api.model.UserUpdateInputDTO;
import com.oficina.educacional.api.model.input.UserInputDTO;
import com.oficina.educacional.domain.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
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
@Tag(name = "admin",description = "admin controller")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private AdminAssembler adminAssembler;

    @Operation(summary = "Create a Admin", description = "create a admin", tags = "admin")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = AdminDTO.class)))),
    })
    @PostMapping("v1/admin")
    public AdminDTO create(@RequestBody @Valid UserInputDTO userInputDTO){
        return adminAssembler.toModel(adminService.create(userInputDTO));
    }

    @Operation(summary = "Update a Admin", description = "update a admin", tags = "admin")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = AdminDTO.class)))),
    })
    @PutMapping("v1/admin/{adminId}")
    public AdminDTO update(@RequestBody @Valid UserUpdateInputDTO userUpdateInputDTO, @PathVariable long adminId) {
        return adminAssembler.toModel(adminService.update(userUpdateInputDTO, adminId));
    }

    @Operation(summary = "Find one Admin", description = "find one admin", tags = "admin")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = AdminDTO.class)))),
    })
    @GetMapping("v1/admin/{adminId}")
    public AdminDTO show(@PathVariable long adminId) {
        return adminAssembler.toModel(adminService.show(adminId));
    }
}
