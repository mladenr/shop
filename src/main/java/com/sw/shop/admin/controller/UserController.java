package com.sw.shop.admin.controller;

import com.sw.shop.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "/admin")
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(path = "/users")
    public String findAllUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "admin/users";
    }
}
