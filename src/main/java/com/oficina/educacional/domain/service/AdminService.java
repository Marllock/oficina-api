package com.oficina.educacional.domain.service;

import com.oficina.educacional.api.model.UserUpdateInputDTO;
import com.oficina.educacional.api.model.input.UserInputDTO;
import com.oficina.educacional.domain.model.Admin;
import com.oficina.educacional.domain.model.User;
import com.oficina.educacional.domain.repository.AdminRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private UserService userService;

    public Admin create(UserInputDTO userInputDTO) {
        User user = userService.create(userInputDTO);
        Admin admin = new Admin();

        admin.setUser(user);
        return adminRepository.save(admin);
    }

    public Admin update(UserUpdateInputDTO userUpdateInputDTO, long adminId) {
        User user = userService.show(adminId);
        BeanUtils.copyProperties(userUpdateInputDTO, user);
        BeanUtils.copyProperties(userUpdateInputDTO.getUserAddress(), user);
        Admin admin = show(adminId);
        admin.setUser(user);
        return adminRepository.save(admin);
    }

    public Admin show(long adminId) {
        return adminRepository.findById(adminId).orElseThrow(NoSuchElementException::new);
    }
}
