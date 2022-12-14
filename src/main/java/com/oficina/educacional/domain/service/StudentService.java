package com.oficina.educacional.domain.service;

import com.oficina.educacional.api.model.input.StudentInputDTO;
import com.oficina.educacional.api.model.input.StudentUpdateInputDTO;
import com.oficina.educacional.api.model.input.UserInputDTO;
import com.oficina.educacional.domain.model.Course;
import com.oficina.educacional.domain.model.Professor;
import com.oficina.educacional.domain.model.Student;
import com.oficina.educacional.domain.model.User;
import com.oficina.educacional.domain.repository.StudentRepository;
import org.springframework.beans.BeanUtils;
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
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private CourseService courseService;

    public Student create(StudentInputDTO studentInputDTO) {
        UserInputDTO userInputDTO = new UserInputDTO();
        BeanUtils.copyProperties(studentInputDTO, userInputDTO);
        User user = userService.create(userInputDTO);

        Student student = new Student();
        student.setUser(user);

        Course course = courseService.findByIdOrFail(studentInputDTO.getCourseId());

        student.setStudentCourse(course);
        return studentRepository.save(student);
    }

    public Page<Student> index(int page, int perPage, Long courseId, String studentName) {
        Pageable pageable = PageRequest.of(page, perPage);
        List<Specification<Student>> specifications = new ArrayList<>();
        if(Objects.nonNull(courseId)) {
            specifications.add(StudentRepository.course(courseId));
        }

        if (Objects.nonNull(studentName)) {
            specifications.add(StudentRepository.name(studentName));
        }
        if (!specifications.isEmpty()) {
            Specification<Student> where = Specification.where(specifications.get(0));
            specifications.forEach(where::and);

            return studentRepository.findAll(where, pageable);
        }
        return studentRepository.findAll(pageable);
    }

    public Student show(long studentId) {
        return studentRepository.findById(studentId).orElseThrow(NoSuchElementException::new);
    }

    public void delete(long studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(NoSuchElementException::new);
        userService.delete(studentId);
        studentRepository.delete(student);
    }

    public Student update(StudentUpdateInputDTO studentUpdateInputDTO, long studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(NoSuchElementException::new);
        User user = userService.show(student.getStudentId());

        BeanUtils.copyProperties(studentUpdateInputDTO.getUserAddress(), user);
        user.setUserTelephone(studentUpdateInputDTO.getUserTelephone());
        user.setUserIsActive(studentUpdateInputDTO.isUserIsActive());

        student.setUser(user);

        Course course = courseService.findByIdOrFail(studentUpdateInputDTO.getCourseId());
        student.setStudentCourse(course);

        return studentRepository.save(student);
    }
}
