package com.oficina.educacional.domain.service;

import com.oficina.educacional.api.model.input.StudentInputDTO;
import com.oficina.educacional.api.model.input.StudentUpdateInputDTO;
import com.oficina.educacional.api.model.input.UserInputDTO;
import com.oficina.educacional.domain.model.Course;
import com.oficina.educacional.domain.model.Student;
import com.oficina.educacional.domain.model.User;
import com.oficina.educacional.domain.repository.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.UUID;

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
        student.setStudentCode(UUID.randomUUID());
        student.setUser(user);

        Course course = courseService.findByIdOrFail(studentInputDTO.getCourseId());

        student.setStudentCourse(course);
        return studentRepository.save(student);
    }

    public Page<Student> index(int page, int perPage, Long courseId) {
        Pageable pageable = PageRequest.of(page, perPage);

        if(Objects.nonNull(courseId)) {
            return studentRepository.findAll(StudentRepository.course(courseId), pageable);
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
