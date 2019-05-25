package com.mateacademy.springmvcexample.transform;

import com.mateacademy.springmvcexample.dto.User;
import com.mateacademy.springmvcexample.model.UserEntity;
import com.mateacademy.springmvcexample.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserMapper {
    private final UserRepository repository;

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
        UserEntity entity;
        if(user.getId() == null) {
            entity = new UserEntity();
        } else entity = repository.findById(user.getId()).orElseThrow(IllegalArgumentException::new);
        entity
                .setDateOfBirth(user.getDateOfBirth())
                .setName(user.getName())
                .setSalary(user.getSalary())
                .setEmail(user.getEmail());
        user.setId(entity.getId());
        return entity;
    }
}
