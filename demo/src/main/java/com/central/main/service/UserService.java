package com.central.main.service;

import com.central.main.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> findByEmail(String email);

    Optional<User> findById(Long id);

    List<User> findAll();

    User save(User user);

}
