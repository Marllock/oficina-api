package com.oficina.educacional.domain.service;

import com.oficina.educacional.api.model.input.GradeInputDTO;
import com.oficina.educacional.api.model.input.GradeUpdateInputDTO;
import com.oficina.educacional.domain.model.ClassStudentsKey;
import com.oficina.educacional.domain.model.Grade;
import com.oficina.educacional.domain.model.Student;
import com.oficina.educacional.domain.model.Class;
import com.oficina.educacional.domain.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class GradeService {

    @Autowired
    private GradeRepository gradeRepository;

    @Autowired StudentService studentService;

    @Autowired ClassService classService;

    public Grade create(GradeInputDTO gradeInputDTO) {
        ClassStudentsKey classStudentsKey = new ClassStudentsKey();
        classStudentsKey.setClassId(gradeInputDTO.getClassId());
        classStudentsKey.setStudentId(gradeInputDTO.getStudentId());

        Student student = studentService.show(classStudentsKey.getStudentId());
        Class classModel = classService.show(classStudentsKey.getClassId());

        Grade grade = new Grade();
        grade.setGradeId(classStudentsKey);

        grade.setStudent(student);
        grade.setClassModel(classModel);

        return gradeRepository.save(grade);
    }

    public Grade update(GradeUpdateInputDTO gradeUpdateInputDTO) {
        Grade grade = show(gradeUpdateInputDTO.getGradeId());
        grade.setGradeScore(gradeUpdateInputDTO.getScore());
        return gradeRepository.save(grade);
    }

    public Page<Grade> index(int page, int perPage, Long studentId, Long classId) {
        Pageable pageable = PageRequest.of(page, perPage);
        return gradeRepository.findAll(GradeRepository.filter(studentId, classId), pageable);
    }

    public void delete(String gradeId) {
        Grade grade = show(gradeId);
        gradeRepository.delete(grade);
    }

    public Grade show(String gradeId) {
        return gradeRepository.findByGradeId(gradeId).orElseThrow(NoSuchElementException::new);
    }
}
