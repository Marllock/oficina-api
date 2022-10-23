package com.oficina.educacional.api.controller;

import com.oficina.educacional.api.assembler.CourseAssembler;
import com.oficina.educacional.api.model.CourseDTO;
import com.oficina.educacional.api.model.input.CourseInputDTO;
import com.oficina.educacional.api.model.input.CourseUpdateInputDTO;
import com.oficina.educacional.domain.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/v1/curso")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseAssembler courseAssembler;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public CourseDTO createCourse(@RequestBody @Valid CourseInputDTO courseInputDTO) {
        return courseAssembler.toModel(courseService.create(courseInputDTO));
    }

    @PutMapping("/{courseId}")
    public CourseDTO updateCourse(@PathVariable long courseId, @RequestBody @Valid CourseUpdateInputDTO courseUpdateInputDTO) {
        return courseAssembler.toModel(courseService.update(courseUpdateInputDTO, courseId));
    }

    @GetMapping("")
    public Page<CourseDTO> listAllCourses(@RequestParam int page, @RequestParam int perPage,
                                          @RequestParam Boolean isActive, @RequestParam String searchName) {
        return courseAssembler.toModel(courseService.listCourses(page, perPage, isActive, searchName));
    }

    @DeleteMapping("/delete/{courseId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long courseId) {
        courseService.delete(courseId);
    }
}
