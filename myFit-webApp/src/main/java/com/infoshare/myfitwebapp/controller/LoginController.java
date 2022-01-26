package com.infoshare.myfitwebapp.controller;

import com.infoshare.myfitwebapp.model.UserLogin;
import com.infoshare.myfitwebapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class LoginController {

    final UserService userService;

    public LoginController(UserService userService) {
       this.userService = userService;
    }

    @GetMapping("/")
    public String hello(){
        return "index";
    }

    @GetMapping("login")
    public String login(){
        return "login";
    }

    @GetMapping("register")
    public String register(Model model){
       model.addAttribute("user", new UserLogin());
        return "register";
    }

    @PostMapping("register")
    public String addUser(@Valid @ModelAttribute("user") UserLogin userLogin, Errors errors){
        if (errors.hasErrors()){
            return "register";
        }
        userService.save(userLogin);
        userService.saveToFile();
        return "redirect:/";
    }
}
