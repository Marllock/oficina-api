package com.oficina.educacional.api.controller;

import com.oficina.educacional.api.model.UserDTO;
import com.oficina.educacional.api.model.UserUpdateInputDTO;
import com.oficina.educacional.api.model.input.UserInputDTO;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("v1/users")
public class UserController {

    @PostMapping
    public UserDTO create(@RequestBody @Valid UserInputDTO userInputDTO) {

        return null;
    }

    @GetMapping
    public Page<UserDTO> index(@RequestParam long page, @RequestParam long perPage, @RequestParam long courseId) {

        return null;
    }

    @GetMapping("/{userId}")
    public UserDTO show(@PathVariable long userId) {

        return null;
    }

    @PutMapping("{userId}")
    public UserDTO update(@PathVariable long userId, @RequestBody @Valid UserUpdateInputDTO userUpdateInputDTO) {

        return null;
    }

    @DeleteMapping("{userId}")
    public ResponseEntity<String> delete(@PathVariable long userId) {

        return null;
    }
}
