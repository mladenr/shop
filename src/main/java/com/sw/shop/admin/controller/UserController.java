package com.sw.shop.admin.controller;

import com.sw.shop.domain.User;
import com.sw.shop.repository.UserRepository;
import com.sw.shop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/admin")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/users")
    public String findAll(Model model) {
        model.addAttribute("users", userService.findAll());
        return "admin/users";
    }

    @GetMapping(path = "/users/add")
    public String displayAdd(Model model) {
        model.addAttribute("user", new User());
        return "admin/user";
    }

    @PostMapping(path = "/users/add")
    public String add(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            System.out.println("adasdadss");
            model.addAttribute("user", user);
            return "admin/user";
        }
        userService.save(user);
        return "redirect:/admin/users";
    }

    @DeleteMapping(path = "/users/{id}")
    public String delete(@PathVariable Long id) {
        userService.deleteById(id);
        return "admin/users";
    }
}
