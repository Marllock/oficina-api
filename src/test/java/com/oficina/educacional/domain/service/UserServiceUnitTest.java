package com.oficina.educacional.domain.service;

import com.oficina.educacional.api.model.UserUpdateInputDTO;
import com.oficina.educacional.api.model.input.UserInputDTO;
import com.oficina.educacional.domain.exception.EmptyResultException;
import com.oficina.educacional.domain.model.Address;
import com.oficina.educacional.domain.model.User;
import com.oficina.educacional.domain.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class UserServiceUnitTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    private Address address;

    void setAddress() {
        address = new Address();
        address.setUserStreet("rua");
        address.setUserStreetNumber("123");
        address.setUserCity("cidade");
        address.setUserDistrict("bairro");
        address.setUserState("estado");
        address.setUserZipCode("28960000");
    }

    @Order(1)
    @DisplayName("Testa Criação de usuário")
    @Test
    void shouldCreateUser() {
        UserInputDTO userInputDTO = new UserInputDTO();
        userInputDTO.setUserEmail("teste@gmail.com");
        userInputDTO.setUserName("teste");
        userInputDTO.setUserProfile(1L);
        setAddress();
        userInputDTO.setUserAddress(address);

        User user = new User();
        user.setUserName("teste");
        user.setUserIsActive(true);
        user.setUserEmail("teste@gmail.com");

        when(userRepository.save(any(User.class))).thenReturn(user);

        User newUser = userService.create(userInputDTO);
        assertThat(newUser).isNotNull().isInstanceOf(User.class);
        assertThat(newUser.getUserName()).isEqualTo("teste");
        assertThat(newUser.getUserEmail()).isEqualTo("teste@gmail.com");
    }

    @Order(2)
    @DisplayName("Testa atualização de usuario")
    @Test
    void shouldUpdateUser(){
        User user = new User();
        UserUpdateInputDTO userUpdateInputDTO = new UserUpdateInputDTO();
        userUpdateInputDTO.setUserEmail("teste@gmail.com");
        userUpdateInputDTO.setUserIsActive(false);
        userUpdateInputDTO.setUserName("teste");
        setAddress();
        userUpdateInputDTO.setUserAddress(address);

        user.setUserName("teste");
        user.setUserEmail("teste@gmail.com");
        user.setUserIsActive(false);

        when(userRepository.findById(anyLong())).thenReturn(Optional.of(user));
        when(userRepository.save(any(User.class))).thenReturn(user);

        User newUser = userService.update(1L, userUpdateInputDTO);

        assertThat(newUser).isNotNull().isInstanceOf(User.class);
        assertThat(newUser.getUserName()).isEqualTo("teste");
        assertThat(newUser.getUserEmail()).isEqualTo("teste@gmail.com");
    }

    @Order(3)
    @DisplayName("Testa falha ao atualização de usuario")
    @Test
    void shouldNotFindUserOnUpdateUser(){
        User user = new User();
        UserUpdateInputDTO userUpdateInputDTO = new UserUpdateInputDTO();
        userUpdateInputDTO.setUserEmail("teste@gmail.com");
        userUpdateInputDTO.setUserIsActive(false);
        userUpdateInputDTO.setUserName("teste");

        user.setUserName("teste");
        user.setUserEmail("teste@gmail.com");
        user.setUserIsActive(false);

        when(userRepository.findById(anyLong())).thenThrow(new NoSuchElementException("User not found"));

        assertThatThrownBy(() -> userService.update(1L, userUpdateInputDTO)).isInstanceOf(NoSuchElementException.class).hasMessage("User not found");
    }

    @Order(4)
    @DisplayName("Testa busca de um único usuário")
    @Test
    void shouldFindSingleUser() {
        User user = new User();
        user.setUserName("teste");
        user.setUserIsActive(true);
        user.setUserEmail("teste@gmail.com");
        Optional<User> opUser = Optional.of(user);

        when(userRepository.findById(anyLong())).thenReturn(opUser);

        assertThat(opUser.get().getUserName()).isEqualTo("teste");
        assertThat(opUser.get()).isInstanceOf(User.class);
    }

    @Order(5)
    @DisplayName("Testa deleção de usuario")
    @Test
    void shouldDeleteUser() {
        doNothing().when(userRepository).deleteById(anyLong());

        userService.delete(1L);
        verify(userRepository, times(1)).deleteById(anyLong());
    }

    @Order(6)
    @DisplayName("Testa falha na deleção de usuario")
    @Test
    void shouldFailOnDeleteUser() {
        doThrow(EmptyResultException.class).when(userRepository).deleteById(anyLong());

        assertThatThrownBy(() -> userService.delete(1L)).isInstanceOf(EmptyResultDataAccessException.class);
        verify(userRepository, times(1)).deleteById(anyLong());
    }
}
