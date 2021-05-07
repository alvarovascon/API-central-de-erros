package com.central.main.controllers;


import com.central.main.entity.User;
import com.central.main.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    private final String SUCCESS = "SUCCESS";

    @GetMapping
    @ApiOperation("Lista usuários cadastrados")
    @ApiResponses(value = {@ApiResponse(code = 200, message = SUCCESS)})
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation("Busca usuários por id")
    @ApiResponses(value = {@ApiResponse(code = 200, message = SUCCESS)})
    public Optional<User> findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping
    @ApiOperation("Registra novo usuário")
    @ApiResponses(value = {@ApiResponse(code = 201, message = SUCCESS)})
    public ResponseEntity<User> create(@Valid @RequestBody User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return new ResponseEntity<User>(this.userService.save(user), HttpStatus.CREATED);
    }

}
