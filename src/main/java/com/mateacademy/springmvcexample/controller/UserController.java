package com.mateacademy.springmvcexample.controller;

import com.mateacademy.springmvcexample.dto.User;
import com.mateacademy.springmvcexample.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {
    private UserService userService;

    @GetMapping(path = "/")
    public String index() {
        return "index";
    }

    @GetMapping(path = "/users/add")
    public String createUser(Model model) {
        model.addAttribute("user", new User());
        return "edit";
    }

    @PostMapping(path = "users")
    public String saveUser(User user) {
        userService.createUser(user);
        return "redirect:/users";
    }

    @GetMapping(path = "/users")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @GetMapping(path = "/users/edit/{id}")
    public String editUser(Model model, @PathVariable(value = "id") Long id) {
        model.addAttribute("user", userService.findUserById(id));
        return "edit";
    }

    @GetMapping(path = "/users/delete/{id}")
    public String deleteUser(@PathVariable(name = "id") Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
