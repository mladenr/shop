package com.sw.shop.admin.controller;

import com.sw.shop.domain.HomeEntity;
import com.sw.shop.service.HomeService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class HomeController {

    private final HomeService homeService;

    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping(path = "/homes")
    public String findAll(Model model) {
        model.addAttribute("homes", homeService.findAll());
        return "homes";
    }

    @GetMapping(path = "/homes/add")
    public String displayAdd(Model model) {
        model.addAttribute("home", new HomeEntity());
        return "home";
    }

    @PostMapping(path = "/homes/add")
    public String add(@ModelAttribute("home") @Valid HomeEntity home, BindingResult bindingResult, Model model, Authentication authentication) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("home", home);
            return "home";
        }
        home.setUc(authentication.getName());
        homeService.save(home);
        return findAll(model);
    }

    @GetMapping(path = "/homes/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        homeService.deleteById(id);
        return findAll(model);
    }

    @GetMapping(path = "/homes/update/{id}")
    public String displayUpdate(@PathVariable Long id, Model model) {
        Optional<HomeEntity> home = homeService.findById(id);
        if (home.isPresent()) {
            model.addAttribute("home", home.get());
        }
        return "home";
    }
}
