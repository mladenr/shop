package com.sw.shop.admin.controller;

import com.sw.shop.domain.ProductGroupEntity;
import com.sw.shop.domain.UserEntity;
import com.sw.shop.service.ProductGroupService;
import com.sw.shop.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping(path = "/admin")
public class ProductGroupController {

    private ProductGroupService productGroupService;
    private UserService userService;

    public ProductGroupController(ProductGroupService productGroupService, UserService userService) {
        this.productGroupService = productGroupService;
        this.userService = userService;
    }

    @GetMapping(path = "/product/groups")
    public String findAll(Model model) {
        model.addAttribute("productGroups", productGroupService.findAll());
        return "admin/productGroups";
    }

    @GetMapping(path = "/product/groups/add")
    public String displayAdd(Model model, Authentication authentication) {
        model.addAttribute("productGroup", new ProductGroupEntity());
        Optional<UserEntity> user = userService.findByUsername(authentication.getName());
        System.out.println("User " + authentication.getName());
        if (user.isPresent()) {
            System.out.println("User " + user);
            model.addAttribute("userHomes", user.get().getHomes());
            System.out.println("User " + user.get().getHomes());
        }
        return "admin/productGroup";
    }

    @PostMapping(path = "/product/groups/add")
    public String add(@ModelAttribute("productGroup") @Valid ProductGroupEntity productGroup, BindingResult bindingResult, Model model, Authentication authentication) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("productGroup", productGroup);
            return "admin/productGroup";
        }
        productGroup.setUc(authentication.getName());
        productGroupService.save(productGroup);
        return findAll(model);
    }

    @GetMapping(path = "/product/groups/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        productGroupService.deleteById(id);
        return findAll(model);
    }

    @GetMapping(path = "/product/groups/update/{id}")
    public String displayUpdate(@PathVariable Long id, Model model) {
        Optional<ProductGroupEntity> productGroup = productGroupService.findById(id);
        if (productGroup.isPresent()) {
            model.addAttribute("productGroup", productGroup.get());
        }
        return "admin/productGroup";
    }
}
