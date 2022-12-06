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
public class UserAssembler {
    @Autowired
    private ModelMapper modelMapper;

    public UserDTO toModel(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    public List<UserDTO> toModel(List<User> users) {
        return users.stream().map(this::toModel).collect(Collectors.toList());
    }

    public Page<UserDTO> toModel(Page<User> user) {
        return user.map(this::toModel);
    }
}
