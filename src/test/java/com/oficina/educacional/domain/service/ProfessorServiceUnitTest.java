package com.oficina.educacional.domain.service;

import com.oficina.educacional.api.model.input.ProfessorInputDTO;
import com.oficina.educacional.api.model.input.ProfessorUpdateInputDTO;
import com.oficina.educacional.api.model.input.UserInputDTO;
import com.oficina.educacional.domain.model.Address;
import com.oficina.educacional.domain.model.Course;
import com.oficina.educacional.domain.model.Professor;
import com.oficina.educacional.domain.model.User;
import com.oficina.educacional.domain.repository.ProfessorRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.DataIntegrityViolationException;

import java.time.LocalDate;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class ProfessorServiceUnitTest {

    @MockBean
    private ProfessorRepository professorRepository;

    @MockBean
    private UserService userService;

    @MockBean
    private CourseService courseService;

    @Autowired
    private ProfessorService professorService;

    private Address address;
    private User user;
    private Course course;
    private Professor professor;


    @Order(1)
    @DisplayName("Testa criação de professor")
    @Test
    void shouldCreateProfessor() {
        ProfessorInputDTO professorInputDTO = new ProfessorInputDTO();

        professorInputDTO.setCourseId(1L);
        professorInputDTO.setUserBirthDate(LocalDate.now());
        professorInputDTO.setUserName("teste");
        professorInputDTO.setUserEmail("rafa@gmail.com");
        professorInputDTO.setUserDocument("000.000.000-00");
        professorInputDTO.setUserProfile(2L);
        professorInputDTO.setUserTelephone("22999303392");

        setBaseUser();
        professorInputDTO.setUserAddress(address);
        BeanUtils.copyProperties(user, address);
        BeanUtils.copyProperties(user, professorInputDTO);
        course = new Course();
        course.setCourseId(1L);
        when(userService.create(any(UserInputDTO.class))).thenReturn(user);
        when(courseService.findByIdOrFail(1L)).thenReturn(course);
        professor = new Professor();
        professor.setProfessorCourse(course);
        professor.setUser(user);
        when(professorRepository.save(any(Professor.class))).thenReturn(professor);

        assertThat(professorService.create(professorInputDTO).getUser().getUserName())
                .isEqualTo(professor.getUser().getUserName());
    }

    private void setBaseUser(){
        address = new Address();
        user = new User();
        address.setUserStreet("Rua 1");
        address.setUserCity("Cidade");
        address.setUserState("MG");
        address.setUserDistrict("Bairro");
        address.setUserZipCode("00000");
        address.setUserStreetNumber("123");
    }

    @Order(2)
    @DisplayName("Testa falha de criação de usuário por violção de integridade")
    @Test
    void shouldThrowExceptionWhenCreateUser() {
        ProfessorInputDTO professorInputDTO = new ProfessorInputDTO();

        when(userService.create(any(UserInputDTO.class))).thenThrow(DataIntegrityViolationException.class);

        assertThatThrownBy(() -> {
            professorService.create(professorInputDTO);
        }).isInstanceOf(DataIntegrityViolationException.class);
    }

    @Order(3)
    @DisplayName("Testa falha ao buscar curso por id")
    @Test
    void shouldThrowExceptionWhenCourseNotFound() {
        ProfessorInputDTO professorInputDTO = new ProfessorInputDTO();

        when(courseService.findByIdOrFail(anyLong())).thenThrow(NoSuchElementException.class);

        assertThatThrownBy(() -> {
            professorService.create(professorInputDTO);
        }).isInstanceOf(NoSuchElementException.class);
    }

    @Order(4)
    @DisplayName("Testa falha ao salvar professor por erro de integridade")
    @Test
    void shouldFailWHenSaveProfessor() {
        ProfessorInputDTO professorInputDTO = new ProfessorInputDTO();

        when(professorRepository.save(any(Professor.class))).thenThrow(DataIntegrityViolationException.class);

        assertThatThrownBy(() -> {
            professorService.create(professorInputDTO);
        }).isInstanceOf(DataIntegrityViolationException.class);
    }

    @Order(2)
    @DisplayName("Testa atualização de professor")
    @Test
    void shouldUpdateProfessor() {
        ProfessorUpdateInputDTO professorUpdateInputDTO = new ProfessorUpdateInputDTO();
        setBaseUser();
        professorUpdateInputDTO.setCourseId(1L);
        professorUpdateInputDTO.setUserName("teste");
        professorUpdateInputDTO.setUserAddress(address);
        course = new Course();
        course.setCourseId(1L);
        professor = new Professor();
        professor.setProfessorCourse(course);
        user.setUserName("teste");
        professor.setUser(user);
        when(courseService.findByIdOrFail(anyLong())).thenReturn(course);
        when(professorRepository.save(any(Professor.class))).thenReturn(professor);

        assertThat(professorService.update(professorUpdateInputDTO).getUser().getUserName()).isEqualTo("teste");

    }

    @Order(8)
    @DisplayName("Testa deleção de professor")
    @Test
    void shouldDeleteProfessor() {
        doNothing().when(userService).delete(anyLong());
        doNothing().when(professorRepository).deleteById(anyLong());

        professorService.delete(1L);

        verify(userService, times(1)).delete(anyLong());
        verify(professorRepository,times(1)).deleteById(anyLong());
    }

    @Order(9)
    @DisplayName("Testa falha deleção de professor")
    @Test
    void shouldFailDeleteProfessor() {
        doThrow(DataIntegrityViolationException.class).when(professorRepository).deleteById(anyLong());
        doNothing().when(userService).delete(anyLong());

        assertThatThrownBy(() -> {
            professorService.delete(1L);
        }).isInstanceOf(DataIntegrityViolationException.class);
    }

    @DisplayName("Testa falha deleção de professor")
    @Test
    void shouldFailDeleteProfessorWithUser() {
        doThrow(DataIntegrityViolationException.class).when(userService).delete(anyLong());
        doNothing().when(professorRepository).deleteById(anyLong());

        assertThatThrownBy(() -> {
            professorService.delete(1L);
        }).isInstanceOf(DataIntegrityViolationException.class);
    }
}
