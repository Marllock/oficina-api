package com.oficina.educacional.domain.service;

import com.oficina.educacional.api.model.UserUpdateInputDTO;
import com.oficina.educacional.api.model.input.UserInputDTO;
import com.oficina.educacional.domain.model.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User create(UserInputDTO userInputDTO){

        return null;
    }

    public Page<User> index(long page, long perPage, long courseId){

        return null;
    }

    public User show(long userId) {

        return null;
    }

    public User update(long userId, UserUpdateInputDTO userUpdateInputDTO) {

        return null;
    }

    public void delete(long userId) {

    }
}
