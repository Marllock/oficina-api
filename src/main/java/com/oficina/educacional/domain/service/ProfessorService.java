package com.oficina.educacional.domain.service;

import com.oficina.educacional.api.model.input.ProfessorInputDTO;
import com.oficina.educacional.api.model.input.ProfessorSearchInputDTO;
import com.oficina.educacional.api.model.input.ProfessorUpdateInputDTO;
import com.oficina.educacional.api.model.input.UserInputDTO;
import com.oficina.educacional.api.utils.StringUtils;
import com.oficina.educacional.domain.model.Course;
import com.oficina.educacional.domain.model.Professor;
import com.oficina.educacional.domain.model.User;
import com.oficina.educacional.domain.repository.ProfessorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import static com.oficina.educacional.domain.repository.ProfessorRepository.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private StringUtils stringUtils;

    public Professor create(ProfessorInputDTO professorInputDTO) {
        UserInputDTO userInputDTO = new UserInputDTO();
        BeanUtils.copyProperties(professorInputDTO, userInputDTO);
        User user = userService.create(userInputDTO);

        Professor professor = new Professor();
        professor.setUser(user);

        Course course = courseService.findByIdOrFail(professorInputDTO.getCourseId());

        professor.setProfessorCourse(course);
        return professorRepository.save(professor);
    }

    public Page<Professor> index(ProfessorSearchInputDTO professorSearchInputDTO) {
        List<Specification<Professor>> specifications = new ArrayList<>();
        Pageable pageable = PageRequest.of(professorSearchInputDTO.getPage(), professorSearchInputDTO.getPerPage());

        if(Objects.nonNull(professorSearchInputDTO.getUserId())) {
            specifications.add(userId(professorSearchInputDTO.getUserId()));
        }

        if(Objects.nonNull(professorSearchInputDTO.getCourseId())) {
            specifications.add(courseId(professorSearchInputDTO.getCourseId()));
        }

        if(Objects.nonNull(professorSearchInputDTO.getUserName())) {
            specifications.add(userName(stringUtils.normalizeString(professorSearchInputDTO.getUserName())));
        }

        if(Objects.nonNull(professorSearchInputDTO.getUserEmail())) {
            specifications.add(userEmail(professorSearchInputDTO.getUserEmail()));
        }

        if(Objects.nonNull(professorSearchInputDTO.getUserProfile())) {
            specifications.add(userProfile(professorSearchInputDTO.getUserProfile()));
        }

        if (!specifications.isEmpty()) {
            Specification<Professor> where = Specification.where(specifications.get(0));
            specifications.forEach(where::and);

            return professorRepository.findAll(where, pageable);
        }
        return professorRepository.findAll(pageable);
    }

    public Professor update(ProfessorUpdateInputDTO professorUpdateInputDTO, long professorId) {
        Professor professor = professorRepository.findById(professorId).orElseThrow(NoSuchElementException::new);
        User user = new User();
        Course course = courseService.findByIdOrFail(professorUpdateInputDTO.getCourseId());
        professor.setProfessorCourse(course);

        BeanUtils.copyProperties(professorUpdateInputDTO.getUserAddress(), user);

        BeanUtils.copyProperties(professorUpdateInputDTO, user);
        professor.setUser(user);
        return professorRepository.save(professor);
    }

    public Professor show(long professorId) {
        return professorRepository.findById(professorId).orElseThrow(NoSuchElementException::new);
    }

    public void delete(long userId) {
        userService.delete(userId);
        professorRepository.deleteById(userId);
    }
}
