package com.sw.shop.admin.controller;

import com.sw.shop.domain.UserEntity;
import com.sw.shop.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Optional;

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
        model.addAttribute("user", new UserEntity());
        return "admin/user";
    }

    @PostMapping(path = "/users/add")
    public String add(@ModelAttribute("user") @Valid UserEntity user, BindingResult bindingResult, Model model, Authentication authentication) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("user", user);
            return "admin/user";
        }
        user.setUc(authentication.getName());
        userService.save(user);
        return findAll(model);
    }

    @GetMapping(path = "/users/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        userService.deleteById(id);
        return findAll(model);
    }

    @GetMapping(path = "/users/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        Optional<UserEntity> user = userService.findById(id);
        if (user.isPresent()) {
            model.addAttribute("user", user.get());
        }
        return "admin/user";
    }
}
