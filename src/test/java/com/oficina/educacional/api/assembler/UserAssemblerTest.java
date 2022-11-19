package com.oficina.educacional.api.assembler;

import com.oficina.educacional.domain.model.User;
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
class UserAssemblerTest {
    @Autowired
    private UserAssembler userAssembler;

    @DisplayName("Testa conversão de DTO para entidade")
    @Test
    void toModel() {
        User user = new User();
        user.setUserName("Test1");
        assertThat(userAssembler.toModel(user).getUserName()).isEqualTo("Test1");
    }

    @DisplayName("Testa conversão para listagem de user")
    @Test
    void testToModelList() {
        User user = new User();
        List<User> userList = new ArrayList<>();

        user.setUserName("Test1");
        userList.add(user);

        assertThat(userAssembler.toModel(userList)).hasSize(1);
        assertThat(userAssembler.toModel(userList).get(0).getUserName()).isEqualTo("Test1");
    }

    @DisplayName("Testa conversão para página de user")
    @Test
    void testToModelPage() {
        User user = new User();
        List<User> userList = new ArrayList<>();

        user.setUserName("Test1");

        userList.add(user);
        Pageable pageable = PageRequest.of(1, 1);
        Page<User> userPage = new PageImpl<>(userList, pageable, 1);

        assertThat(userAssembler.toModel(userPage)).hasSize(1);
        assertThat(userAssembler.toModel(userPage).getContent().get(0).getUserName()).isEqualTo("Test1");
    }
}