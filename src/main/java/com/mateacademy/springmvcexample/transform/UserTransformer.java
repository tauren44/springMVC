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
public class UserTransformer {
    private final UserRepository repository;

    public void addUser(User user) {
        repository.save(buildEntity(user));
    }

    public void updateUser(User user) {
        repository.save(buildEntity(user));
    }

    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

    public List<User> findAll() {
        List<UserEntity> entities = repository.findAll();
        return buildUsers(entities);
    }

    public User findOne(Long id) {
        return buildUser(repository.findById(id).orElseThrow(IllegalArgumentException::new));
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
        UserEntity entity;
        if(user.getId() == null) {
            entity = new UserEntity();
        } else entity = repository.findById(user.getId()).orElseThrow(IllegalArgumentException::new);
        entity
                .setAge(user.getAge())
                .setName(user.getName())
                .setSalary(user.getSalary())
                .setEmail(user.getEmail());
        user.setId(entity.getId());
        return entity;
    }
}
