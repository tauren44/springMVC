package com.mateacademy.springmvcexample.controller;

import com.mateacademy.springmvcexample.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public String login(User user) {
        return "login";
    }
}
