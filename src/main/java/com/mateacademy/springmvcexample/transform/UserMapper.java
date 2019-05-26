package com.mateacademy.springmvcexample.transform;

import com.mateacademy.springmvcexample.dto.User;
import com.mateacademy.springmvcexample.model.UserEntity;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class UserMapper {

    public User mapUserEntityToUser(UserEntity entity) {
        return new User()
                .setId(entity.getId())
                .setDateOfBirth(entity.getDateOfBirth())
                .setName(entity.getName())
                .setSalary(entity.getSalary())
                .setEmail(entity.getEmail());
    }

    public List<User> mapUserEntitiesToUsers(List<UserEntity> entities) {
        return entities.stream()
                .map(this::mapUserEntityToUser)
                .collect(toList());
    }

    public UserEntity mapUserToUserEntity(User user) {
        return (UserEntity) new UserEntity()
                .setDateOfBirth(user.getDateOfBirth())
                .setName(user.getName())
                .setSalary(user.getSalary())
                .setEmail(user.getEmail()).setId(user.getId());
    }
}
