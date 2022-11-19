package com.oficina.educacional.domain.service;

import com.oficina.educacional.api.model.UserUpdateInputDTO;
import com.oficina.educacional.api.model.input.UserInputDTO;
import com.oficina.educacional.api.utils.StringUtils;
import com.oficina.educacional.domain.exception.EmptyResultException;
import com.oficina.educacional.domain.model.User;
import com.oficina.educacional.domain.model.enums.ProfileTypeEnum;
import com.oficina.educacional.domain.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StringUtils stringUtils;

    public User create(UserInputDTO userInputDTO){
        User user = new User();

        BeanUtils.copyProperties(userInputDTO, user);
        BeanUtils.copyProperties(userInputDTO.getUserAddress(), user);
        user.setUserIsActive(true);
        user.setUserNormalizedName(stringUtils.normalizeString(userInputDTO.getUserName()));
        user.setUserProfileType(ProfileTypeEnum.valueOf(userInputDTO.getUserProfile()));

        return userRepository.save(user);
    }

    public User show(long userId) {
        return userRepository.findById(userId).orElseThrow(NoSuchElementException::new);
    }

    public User update(long userId, UserUpdateInputDTO userUpdateInputDTO) {
        User user = userRepository.findById(userId).orElseThrow(NoSuchElementException::new);
        BeanUtils.copyProperties(userUpdateInputDTO, user);
        BeanUtils.copyProperties(userUpdateInputDTO.getUserAddress(), user);

        return userRepository.save(user);
    }

    public void delete(long userId) {
        try{
            userRepository.deleteById(userId);
        } catch (EmptyResultException e){
            throw new EmptyResultDataAccessException("Usuário não encontrado", 1);
        }
    }
}
