package com.oficina.educacional.domain.service;

import com.oficina.educacional.api.assembler.CourseAssembler;
import com.oficina.educacional.api.model.input.CourseInputDTO;
import com.oficina.educacional.api.model.input.CourseUpdateInputDTO;
import com.oficina.educacional.api.utils.StringUtils;
import com.oficina.educacional.domain.exception.EmptyResultException;
import com.oficina.educacional.domain.exception.IntegrityException;
import com.oficina.educacional.domain.model.Course;
import com.oficina.educacional.domain.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

import static com.oficina.educacional.domain.repository.CourseRepository.courseContainsName;
import static com.oficina.educacional.domain.repository.CourseRepository.courseIsActive;

@Service
@AllArgsConstructor
public class CourseService {

    private CourseRepository courseRepository;

    private CourseAssembler courseAssembler;

    private StringUtils stringUtils;

    @Transactional
    public Course create(@Valid CourseInputDTO courseInputDTO) {
        try {

        Course course = new Course();
        BeanUtils.copyProperties(courseInputDTO, course);
        course.setCourseIsActive(true);
        course.setCourseNormalizedName(stringUtils
                .normalizeString(courseInputDTO.getCourseName()));
        return courseRepository.save(course);
        } catch (Exception e) {
            String errorMessage =
                    (e.getCause() != null && e.getCause().getCause().getMessage() != null) ? e.getCause().getCause().getMessage() : e.getMessage();
            throw new IntegrityException(errorMessage);
        }
    }

    @Transactional
    public Course update(CourseUpdateInputDTO courseUpdateInputDTO, long courseId) {
        Course course = findByIdOrFail(courseId);

        if(Objects.nonNull(courseUpdateInputDTO.getCourseName())){
            course.setCourseName(courseUpdateInputDTO.getCourseName());
            course.setCourseNormalizedName(stringUtils
                    .normalizeString(courseUpdateInputDTO.getCourseName()));
        }

        if(Objects.nonNull(courseUpdateInputDTO.getCourseIsActive())) {
            course.setCourseIsActive(courseUpdateInputDTO.getCourseIsActive());
        }

        if(Objects.nonNull(courseUpdateInputDTO.getCourseCode())) {
            course.setCourseCode(courseUpdateInputDTO.getCourseCode());
        }

        return courseRepository.save(course);
    }

    public Page<Course> listCourses(int page, int perPage, Boolean isActive, String searchName) {
        Pageable pageable = PageRequest.of(page, perPage);

        List<Specification<Course>> specifications = new ArrayList<>();

        if (Objects.nonNull(isActive)) {
            specifications.add(courseIsActive(isActive));
        }

        if (!searchName.isBlank()) {
            specifications.add(courseContainsName(stringUtils.normalizeString(searchName)));
        }

        if (!specifications.isEmpty()) {
            Specification<Course> where = Specification.where(specifications.get(0));
            specifications.forEach(where::and);

        return courseRepository.findAll(where, pageable);
        }
        return courseRepository.findAll(pageable);
    }

    @Transactional
    public void delete(Long adminId) {
        try {
            courseRepository.deleteById(adminId);
            courseRepository.flush();
        } catch (EmptyResultDataAccessException e) {
            throw new EmptyResultException(String.format("Curso de id %d não encontrado", adminId));
        } catch (DataIntegrityViolationException e) {
            throw new IntegrityException(String.format("Curso de id %d já está em uso", adminId));
        }
    }

    public Course findByIdOrFail(long courseId) {
        return courseRepository.findById(courseId).orElseThrow(() -> new NoSuchElementException("Elemento não encontrado"));
    }
}
