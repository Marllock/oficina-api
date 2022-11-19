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

import javax.validation.Valid;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseAssembler courseAssembler;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/v1/course")
    public CourseDTO createCourse(@RequestBody @Valid CourseInputDTO courseInputDTO) {
        return courseAssembler.toModel(courseService.create(courseInputDTO));
    }

    @PutMapping("/v1/course/{courseId}")
    public CourseDTO updateCourse(@PathVariable long courseId, @RequestBody @Valid CourseUpdateInputDTO courseUpdateInputDTO) {
        return courseAssembler.toModel(courseService.update(courseUpdateInputDTO, courseId));
    }

    @GetMapping("/v1/course")
    public Page<CourseDTO> listAllCourses(@RequestParam int page, @RequestParam int perPage,
                                          @RequestParam Boolean isActive, @RequestParam String searchName) {
        return courseAssembler.toModel(courseService.listCourses(page, perPage, isActive, searchName));
    }

    @GetMapping("/v1/course/{courseId}")
    public ResponseEntity<CourseDTO> show(@PathVariable long courseId) {
        return ResponseEntity.ok(courseAssembler.toModel(courseService.show(courseId)));
    }

    @DeleteMapping("/v1/course/delete/{courseId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long courseId) {
        courseService.delete(courseId);
    }
}
