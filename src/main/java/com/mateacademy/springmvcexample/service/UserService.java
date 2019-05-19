package com.mateacademy.springmvcexample.service;

import com.mateacademy.springmvcexample.dto.User;

import java.util.List;

public interface UserService {
    void createUser(User user);

    void updateUser(User user);

    void deleteUser(Long id);

    User findUserById(Long id);

    List<User> findAll();
}
