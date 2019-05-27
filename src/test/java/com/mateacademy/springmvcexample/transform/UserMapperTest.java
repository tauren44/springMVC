package com.mateacademy.springmvcexample.transform;

import com.mateacademy.springmvcexample.dto.User;
import com.mateacademy.springmvcexample.model.Role;
import com.mateacademy.springmvcexample.model.UserEntity;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class UserMapperTest {
    private UserMapper mapper = new UserMapper();

    @Test
    public void shouldMapUserEntityToUser() {
        UserEntity entity = new UserEntity()
                .setName("test")
                .setEmail("test@test.test")
                .setDateOfBirth(LocalDate.of(1990, 1, 1))
                .setRole(Role.ADMIN)
                .setSalary(800);
        User user = mapper.mapUserEntityToUser(entity);
        assertEquals(entity.getDateOfBirth(), user.getDateOfBirth());
        assertEquals(entity.getEmail(), user.getEmail());
        assertEquals(entity.getName(), user.getName());
        assertEquals(entity.getRole(), user.getRole());
        assertEquals(entity.getSalary(), user.getSalary());
    }

    @Test
    public void shouldMapUserToUserEntity() {
        User user = new User()
                .setName("test")
                .setEmail("test@test.test")
                .setDateOfBirth(LocalDate.of(1990, 1, 1))
                .setRole(Role.ADMIN)
                .setSalary(800);
        UserEntity entity = mapper.mapUserToUserEntity(user);
        assertEquals(entity.getDateOfBirth(), user.getDateOfBirth());
        assertEquals(entity.getEmail(), user.getEmail());
        assertEquals(entity.getName(), user.getName());
        assertEquals(entity.getRole(), user.getRole());
        assertEquals(entity.getSalary(), user.getSalary());
    }
}
