package com.mateacademy.springmvcexample.transform;

import com.mateacademy.springmvcexample.dto.User;
import com.mateacademy.springmvcexample.model.UserEntity;
import com.mateacademy.springmvcexample.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserTransformer {
    private UserService userService;

    public void addUser(User user) {
        userService.createUser(buildEntity(user));
    }

    public void updateUser(User user) {
        userService.updateUser(buildEntity(user));
    }

    public void deleteUser(Long id) {
        userService.deleteUser(id);
    }

    public List<User> findAll(){
        List<UserEntity> entities = userService.findAll();
        return buildUsers(entities);
    }

    public User findOne(Long id) {
        return buildUser(userService.findUserById(id));
    }

    private User buildUser(UserEntity entity) {
        return new User()
                .setId(entity.getId())
                .setAge(entity.getAge())
                .setName(entity.getName())
                .setSalary(entity.getSalary())
                .setEmail(entity.getEmail());
    }
    private List<User> buildUsers(List<UserEntity> entities) {
        return entities.stream()
                .map(this::buildUser)
                .collect(toList());
    }

    private UserEntity buildEntity(User user) {
        return new UserEntity()
                .setAge(user.getAge())
                .setName(user.getName())
                .setSalary(user.getSalary())
                .setEmail(user.getEmail());
    }
}
