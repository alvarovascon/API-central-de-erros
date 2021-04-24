package com.central.main.service;

import com.central.main.entity.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findByEmail(String email);
}
