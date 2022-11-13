package com.oficina.educacional.domain.service;

import com.oficina.educacional.api.model.input.ClassInputDTO;
import com.oficina.educacional.domain.model.Class;
import com.oficina.educacional.domain.model.Course;
import com.oficina.educacional.domain.model.Professor;
import com.oficina.educacional.domain.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

@Service
public class ClassService {

    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private ProfessorService professorService;

    @Autowired
    private CourseService courseService;

    public Class create(ClassInputDTO classInputDTO) {
        Class classModel = new Class();

        Professor professor = professorService.show(classInputDTO.getProfessorId());
        Course course = courseService.show(classInputDTO.getCourseId());

        classModel.setClassIsActive(true);
        classModel.setClassCourse(course);
        classModel.setClassProfessor(professor);

        return classRepository.save(classModel);
    }

    public Class update(ClassInputDTO classInputDTO, long classId) {
        Class classModel = classRepository.findById(classId).orElseThrow(NoSuchElementException::new);

        Professor professor = professorService.show(classInputDTO.getProfessorId());
        Course course = courseService.show(classInputDTO.getCourseId());

        classModel.setClassIsActive(true);
        classModel.setClassCourse(course);
        classModel.setClassProfessor(professor);

        return classRepository.save(classModel);
    }

    public Page<Class> index(int page, int perPage, Boolean isActive, Long courseId, Long professorId) {

        Pageable pageable = PageRequest.of(page, perPage);
        List<Specification<Class>> specifications = new ArrayList<>();

        if(Objects.nonNull(isActive)){
            specifications.add(ClassRepository.isActive(isActive));
        }

        if(Objects.nonNull(courseId)){
            specifications.add(ClassRepository.course(courseId));
        }

        if(Objects.nonNull(professorId)) {
            specifications.add(ClassRepository.professor(professorId));
        }
        if (!specifications.isEmpty()) {
            Specification<Class> where = Specification.where(specifications.get(0));
            specifications.forEach(where::and);

            return classRepository.findAll(where, pageable);
        }
        return classRepository.findAll(pageable);
    }

    public Class show(long classId) {
        return classRepository.findById(classId).orElseThrow(NoSuchElementException::new);
    }

    public void delete(long classId) {
        Class classModel = classRepository.findById(classId).orElseThrow(NoSuchElementException::new);

        classRepository.delete(classModel);
    }
}
