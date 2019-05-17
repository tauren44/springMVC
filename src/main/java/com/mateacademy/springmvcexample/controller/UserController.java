package com.mateacademy.springmvcexample.controller;

import com.mateacademy.springmvcexample.dto.User;
import com.mateacademy.springmvcexample.transform.UserTransformer;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {
    private UserTransformer transformer;

    @RequestMapping(path = "/")
    public String index() {
        return "index";
    }

    @RequestMapping(path = "/users/add", method = RequestMethod.GET)
    public String createUser(Model model) {
        model.addAttribute("user", new User());
        return "edit";
    }

    @RequestMapping(path = "users", method = RequestMethod.POST)
    public String saveUser(User user) {
        transformer.addUser(user);
        return "redirect:/";
    }

    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public String getAllUsers(Model model) {
        model.addAttribute("users", transformer.findAll());
        return "users";
    }

    @RequestMapping(path = "/users/edit/{id}", method = RequestMethod.GET)
    public String editUser(Model model, @PathVariable(value = "id") Long id) {
        model.addAttribute("product", transformer.findOne(id));
        return "edit";
    }

    @RequestMapping(path = "/users/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable(name = "id") Long id) {
        transformer.deleteUser(id);
        return "redirect:/users";
    }
}
