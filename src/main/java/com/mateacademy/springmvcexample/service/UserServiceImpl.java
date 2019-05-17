package com.mateacademy.springmvcexample.service;

import com.mateacademy.springmvcexample.model.UserEntity;
import com.mateacademy.springmvcexample.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {
    private UserRepository repository;

    @Override
    public void createUser(UserEntity user) {
        repository.save(user);
    }

    @Override
    public void updateUser(UserEntity user) {
        repository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

    @Override
    public UserEntity findUserById(Long id) {
        return repository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public List<UserEntity> findAll() {
        return repository.findAll();
    }
}
