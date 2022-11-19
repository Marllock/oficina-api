package com.oficina.educacional.api.assembler;

import com.oficina.educacional.api.model.UserDTO;
import com.oficina.educacional.domain.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDisassembler {
    @Autowired
    private ModelMapper modelMapper;

    public User toModel(UserDTO user) {
        return modelMapper.map(user, User.class);
    }

    public List<User> toModel(List<UserDTO> users) {
        return users.stream().map(this::toModel).collect(Collectors.toList());
    }

    public Page<User> toModel(Page<UserDTO> user) {
        return user.map(this::toModel);
    }
}
