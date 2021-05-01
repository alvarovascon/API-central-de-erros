package com.central.main.controllers;


import com.central.main.entity.User;
import com.central.main.repository.UserRepository;
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

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping
    @ApiOperation("Register new user")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "New user successfully registered")})
    public ResponseEntity<User> create(@Valid @RequestBody User user) {
        return new ResponseEntity<User>(this.userService.save(user), HttpStatus.CREATED);
    }

//    @ApiOperation("Cria um novo livro")
//    @ApiResponses(value = {@ApiResponse(code = 201, message = "Livro criado com sucesso")})
//    public ResponseEntity<Livro> create(@Valid @RequestBody Livro livro) {
//        return new ResponseEntity<Livro>(this.livroService.save(livro), HttpStatus.CREATED);
//    }

}
