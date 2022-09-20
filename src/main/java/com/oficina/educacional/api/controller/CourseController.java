package com.oficina.educacional.api.controller;

import com.oficina.educacional.api.assembler.CourseAssembler;
import com.oficina.educacional.api.model.CourseDTO;
import com.oficina.educacional.api.model.input.CourseInputDTO;
import com.oficina.educacional.api.model.input.CourseUpdateInputDTO;
import com.oficina.educacional.domain.model.Course;
import com.oficina.educacional.domain.service.CourseService;
//import io.swagger.annotations.ApiOperation;
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

//    @ApiOperation(value = "Cria curso")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public CourseDTO createCourse(@RequestBody @Valid CourseInputDTO courseInputDTO) {
        Course course = courseService.create(courseInputDTO);
        return courseAssembler.toModel(course);
    }

//    @ApiOperation(value = "Atualiza curso")
    @PutMapping("/{courseId}")
    public CourseDTO updateCourse(@PathVariable long courseId, @RequestBody @Valid CourseUpdateInputDTO courseUpdateInputDTO) {

        Course course = courseService.update(courseUpdateInputDTO, courseId);
        return courseAssembler.toModel(course);
    }

//    @ApiOperation(value = "Lista todos os curso paginado")
    @GetMapping("")
    public Page<CourseDTO> listAllCourses(@RequestParam int page, @RequestParam int perPage,
                                          @RequestParam Boolean isActive, @RequestParam String searchName) {
        Page<Course> courses = courseService.listCourses(page, perPage, isActive, searchName);
        return courseAssembler.toModel(courses);
    }

    @DeleteMapping("/delete/{courseId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @ApiOperation(value = "Remove um curso")
    public void delete(@PathVariable Long courseId) {
        courseService.delete(courseId);
    }
}
