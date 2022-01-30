package com.infoshare.myfitwebapp.controller;

import com.infoshare.myfitwebapp.model.UserData;
import com.infoshare.myfitwebapp.model.UserLogin;
import com.infoshare.myfitwebapp.service.RegisterService;
import com.infoshare.myfitwebapp.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    private final RegisterService registerService;
    private final UserService userService;

    public LoginController(RegisterService registerService, UserService userService) {
        this.registerService = registerService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String hello() {
        return "index";
    }

    @GetMapping("login")
    public String login() {
        return "login";
    }

    @GetMapping("register")
    public String register() {
        registerService.addUser();
        return "register";
    }

    @PostMapping("goToUserEdit")
    public String goToEdit() {
        return "redirect:/user/edit";
    }

    @GetMapping("user/edit")
    public String getUserEdit(Authentication authentication, Model model) {
        if (authentication != null) {
            UserLogin userLogin = userService.load(authentication.getName());
            Long id = userLogin.getId();
            UserData userData = userService.loadUserData(id);
            model.addAttribute("user", userData);
        }
        return "edit-user";
    }
}
