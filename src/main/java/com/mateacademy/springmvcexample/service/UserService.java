package com.mateacademy.springmvcexample.service;

import com.mateacademy.springmvcexample.model.UserEntity;

import java.util.List;

public interface UserService {
    void createUser(UserEntity user);

    void updateUser(UserEntity user);

    void deleteUser(Long id);

    UserEntity findUserById(Long id);

    List<UserEntity> findAll();
}
