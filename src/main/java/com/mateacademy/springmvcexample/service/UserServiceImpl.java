package com.mateacademy.springmvcexample.service;

import com.mateacademy.springmvcexample.dto.User;
import com.mateacademy.springmvcexample.transform.UserTransformer;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {
    private UserTransformer transformer;

    @Override
    public void createUser(User user) {
        transformer.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        transformer.updateUser(user);
    }

    @Override
    public void deleteUser(Long id) {
        transformer.deleteUser(id);
    }

    @Override
    public User findUserById(Long id) {
        return transformer.findOne(id);
    }

    @Override
    public List<User> findAll() {
        return transformer.findAll();
    }
}
