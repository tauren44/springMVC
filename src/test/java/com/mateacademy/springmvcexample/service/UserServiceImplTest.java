package com.mateacademy.springmvcexample.service;

import com.mateacademy.springmvcexample.dto.User;
import com.mateacademy.springmvcexample.model.Role;
import lombok.AllArgsConstructor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImplTest {
    private final UserService service;

    @Before
    public void setUp() throws Exception {
        User user = new User();
        user.setDateOfBirth(LocalDate.of(1994, 5, 12))
                .setEmail("test@test.net")
                .setSalary(1500)
                .setRole(Role.ADMIN)
                .setName("TEST");
        service.createUser(user);
    }

    @After
    public void tearDown() throws Exception {
        service.deleteUser(1L);
    }

    @Test
    public void shouldCreateUser() {
        assertTrue(service.findAll().contains(service.findUserById(1L)));
    }

    @Test
    public void shouldUpdateUser() {
        String expectedName = "updated";
        Integer expectedSalary = 50000;
        String expectedEmail = "updated@update.com";
        Role expectedRole = Role.USER;

        User user = service.findUserById(1L);
        user
                .setEmail(expectedEmail)
                .setSalary(expectedSalary)
                .setRole(expectedRole)
                .setName(expectedName);
        service.updateUser(user);
        assertEquals(user, service.findUserById(1L));
    }

    @Test
    public void shouldDeleteUser() {
        service.deleteUser(1L);
        assertTrue(service.findAll().isEmpty());
    }

    @Test
    public void shouldFindUserById() {
        String expectedName = "TEST";
        Integer expectedSalary = 1500;
        String expectedEmail = "test@test.net";
        Role expectedRole = Role.ADMIN;
        User user = service.findUserById(1L);

        assertEquals(user.getEmail(), expectedEmail);
        assertEquals(user.getName(), expectedName);
        assertEquals(user.getSalary(), expectedSalary);
        assertEquals(user.getRole(), expectedRole);
    }

    @Test
    public void shouldFindAllUsers() {
        User user = new User()
                .setDateOfBirth(LocalDate.of(1999, 8, 1))
                .setName("new")
                .setEmail("new@new.new")
                .setRole(Role.ANONYMOUS)
                .setSalary(600);
        int expectedSize = 2;

        assertEquals(service.findAll().size(), expectedSize);
    }
}
