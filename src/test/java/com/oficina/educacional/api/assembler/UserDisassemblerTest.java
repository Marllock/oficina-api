package com.oficina.educacional.api.assembler;

import com.oficina.educacional.api.model.UserDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UserDisassemblerTest {
    @Autowired
    private UserDisassembler userDisassembler;


    @DisplayName("Testa conversão de DTO para entidade")
    @Test
    void toModel() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName("Test1");
        assertThat(userDisassembler.toModel(userDTO).getUserName()).isEqualTo("Test1");
    }

    @DisplayName("Testa conversão para listagem de user")
    @Test
    void testToModelList() {
        UserDTO userDTO = new UserDTO();
        List<UserDTO> userDTOList = new ArrayList<>();

        userDTO.setUserName("Test1");
        userDTOList.add(userDTO);

        assertThat(userDisassembler.toModel(userDTOList)).hasSize(1);
        assertThat(userDisassembler.toModel(userDTOList).get(0).getUserName()).isEqualTo("Test1");
    }

    @DisplayName("Testa conversão para página de user")
    @Test
    void testToModelPage() {
        UserDTO user = new UserDTO();
        List<UserDTO> userList = new ArrayList<>();

        user.setUserName("Test1");

        userList.add(user);
        Pageable pageable = PageRequest.of(1, 1);
        Page<UserDTO> userPage = new PageImpl<>(userList, pageable, 1);

        assertThat(userDisassembler.toModel(userPage)).hasSize(1);
        assertThat(userDisassembler.toModel(userPage).getContent().get(0).getUserName()).isEqualTo("Test1");
    }
}