package com.oficina.educacional.domain.service;

import com.oficina.educacional.api.model.input.ProfessorInputDTO;
import com.oficina.educacional.api.model.input.ProfessorSearchInputDTO;
import com.oficina.educacional.api.model.input.UserInputDTO;
import com.oficina.educacional.domain.model.Course;
import com.oficina.educacional.domain.model.Professor;
import com.oficina.educacional.domain.model.User;
import com.oficina.educacional.domain.repository.ProfessorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private CourseService courseService;

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
        return null;
    }
}
