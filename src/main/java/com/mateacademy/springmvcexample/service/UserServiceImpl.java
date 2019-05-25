package com.mateacademy.springmvcexample.service;

import com.mateacademy.springmvcexample.dto.User;
import com.mateacademy.springmvcexample.repository.UserRepository;
import com.mateacademy.springmvcexample.transform.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Override
    public void createUser(User user) {
        userRepository.save(userMapper.mapUserToUserEntity(user));
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(userMapper.mapUserToUserEntity(user));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findUserById(Long id) {
        return userMapper.mapUserEntityToUser(userRepository.findById(id)
                                .orElseThrow(IllegalArgumentException::new));
    }

    @Override
    public List<User> findAll() {
        return userMapper.mapUserEntitiesToUsers(userRepository.findAll());
    }
}
