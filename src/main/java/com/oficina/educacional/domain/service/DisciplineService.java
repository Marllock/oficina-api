package com.oficina.educacional.domain.service;

import com.oficina.educacional.api.model.input.DisciplineInputDTO;
import com.oficina.educacional.api.utils.StringUtils;
import com.oficina.educacional.domain.exception.EmptyResultException;
import com.oficina.educacional.domain.model.Course;
import com.oficina.educacional.domain.model.Discipline;
import com.oficina.educacional.domain.repository.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Objects;

@Service
public class DisciplineService {

    @Autowired
    private DisciplineRepository disciplineRepository;

    @Autowired
    private CourseService courseService;

    @Autowired
    private StringUtils stringUtils;

    @Transactional
    public void delete(long disciplineId) {
        try{
            disciplineRepository.deleteById(disciplineId);
        } catch( EmptyResultException e) {
            throw new EmptyResultException(String.format("Disciplina de id %d não encontrado", disciplineId));
        }
    }

    public Page<Discipline> index(int perPage, int page, String disciplineName,
                                  String disciplineCode, long courseId) {


        Pageable pageable = PageRequest.of(page, perPage);
        return disciplineRepository.findAll(DisciplineRepository.index(stringUtils.normalizeString(disciplineName), disciplineCode,
                courseId), pageable);
    }

    @Transactional
    public Discipline update(DisciplineInputDTO disciplineInputDTO, long disciplineId) {
        Discipline disciplineToUpdate = disciplineRepository.findById(disciplineId).orElseThrow(NoSuchElementException::new);

        if (Objects.nonNull(disciplineInputDTO.getDisciplineName())){
            disciplineToUpdate.setDisciplineName(disciplineInputDTO.getDisciplineName());
            disciplineToUpdate.setDisciplineNormalizedName(stringUtils.normalizeString(disciplineInputDTO.getDisciplineName()));
        }

        if (Objects.nonNull(disciplineInputDTO.getDisciplineCode())) {
            disciplineToUpdate.setDisciplineCode(disciplineInputDTO.getDisciplineCode());
        }

        if (Objects.nonNull(disciplineInputDTO.getCourseId())){
            Course course = courseService.findByIdOrFail(disciplineInputDTO.getCourseId());
            disciplineToUpdate.setCourseId(course);
        }
        return disciplineRepository.save(disciplineToUpdate);
    }

    @Transactional
    public Discipline create(DisciplineInputDTO disciplineInputDTO) {
        Discipline disciplineToCreate = new Discipline();

        disciplineToCreate.setDisciplineName(disciplineInputDTO.getDisciplineName());
        disciplineToCreate.setDisciplineCode(disciplineInputDTO.getDisciplineCode());
        disciplineToCreate.setDisciplineNormalizedName(stringUtils
                .normalizeString(disciplineInputDTO.getDisciplineName()));

        Course course = courseService.findByIdOrFail(disciplineInputDTO.getCourseId());
        disciplineToCreate.setCourseId(course);

        return disciplineRepository.save(disciplineToCreate);
    }

    public Discipline show(long disciplineId) {
        return disciplineRepository.findById(disciplineId).orElseThrow(NoSuchElementException::new);
    }
}
