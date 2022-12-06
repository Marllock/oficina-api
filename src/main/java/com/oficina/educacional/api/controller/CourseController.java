package com.oficina.educacional.api.controller;

import com.oficina.educacional.api.assembler.CourseAssembler;
import com.oficina.educacional.api.model.CourseDTO;
import com.oficina.educacional.api.model.input.CourseInputDTO;
import com.oficina.educacional.api.model.input.CourseUpdateInputDTO;
import com.oficina.educacional.domain.service.CourseService;
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
@Tag(name = "Course", description = "Course controller")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseAssembler courseAssembler;

    @Operation(summary = "Create a Course", description = "create a course", tags = "course")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = CourseDTO.class)))),
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/v1/course")
    public CourseDTO createCourse(@RequestBody @Valid CourseInputDTO courseInputDTO) {
        return courseAssembler.toModel(courseService.create(courseInputDTO));
    }

    @Operation(summary = "Update a Course", description = "update a course", tags = "course")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = CourseDTO.class)))),
    })
    @PutMapping("/v1/course/{courseId}")
    public CourseDTO updateCourse(@PathVariable long courseId, @RequestBody @Valid CourseUpdateInputDTO courseUpdateInputDTO) {
        return courseAssembler.toModel(courseService.update(courseUpdateInputDTO, courseId));
    }

    @Operation(summary = "find all Courses", description = "find all courses", tags = "course")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = CourseDTO.class)))),
    })
    @GetMapping("/v1/course")
    public Page<CourseDTO> listAllCourses(@RequestParam int page, @RequestParam int perPage,
                                          @RequestParam(required = false) Boolean isActive,
                                          @RequestParam(required = false) String searchName) {
        return courseAssembler.toModel(courseService.listCourses(page, perPage, isActive, searchName));
    }

    @Operation(summary = "find one Course", description = "find one course", tags = "course")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = CourseDTO.class)))),
    })
    @GetMapping("/v1/course/{courseId}")
    public ResponseEntity<CourseDTO> show(@PathVariable long courseId) {
        return ResponseEntity.ok(courseAssembler.toModel(courseService.show(courseId)));
    }

    @Operation(summary = "Delete a Course", description = "delete a course", tags = "course")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = String.class)))),
    })
    @DeleteMapping("/v1/course/delete/{courseId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> delete(@PathVariable Long courseId) {
        courseService.delete(courseId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Course deleted with success");
    }
}
