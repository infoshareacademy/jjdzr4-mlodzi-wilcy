package com.infoshare.myfitwebapp.controller;

import com.infoshare.myfitwebapp.entity.User;
import com.infoshare.myfitwebapp.entity.UserLogin;
import com.infoshare.myfitwebapp.service.CPMService;
import com.infoshare.myfitwebapp.service.UserService;
import org.springframework.security.core.Authentication;
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
    final CPMService cpmService;

    public LoginController(UserService userService, CPMService cpmService) {
        this.userService = userService;
        this.cpmService = cpmService;
    }

    @GetMapping("/")
    public String hello(Authentication authentication, Model model) {
        if (authentication != null) {
            UserLogin userLogin = userService.load(authentication.getName());
            if (userLogin.getUser() == null) {
                return fillUserData(model);
            }
        }
        return "index";
    }

    @GetMapping("login")
    public String login() {
        return "login";
    }

    @GetMapping("register")
    public String register(Model model) {
        model.addAttribute("user", new UserLogin());
        return "register";
    }

    @PostMapping("register")
    public String addUser(Model model, @Valid @ModelAttribute("user") UserLogin userLogin, Errors errors) {
        if (noPasswordsMatch(userLogin)){
            return "redirect:register?mismatch";
        }
        if (errors.hasErrors()) {
            return "register";
        }
        try {
            userService.load(userLogin.getUsername()).getUsername();
        } catch (NullPointerException e) {
            userService.save(userLogin);
            userService.saveToFile();
            return "redirect:/";
        }
        return "redirect:register?error";
    }

    private boolean noPasswordsMatch(UserLogin userLogin) {
        return !userLogin.getPassword().equals(userLogin.getMatchingPassword());
    }

    @GetMapping("fillInfo")
    public String fillUserData(Model model) {
        model.addAttribute("user", new User());
        return "fillInfo";
    }

    @PostMapping("fillInfo")
    public String fillUserDataFinish(@Valid @ModelAttribute("user") User user, Errors errors, Authentication authentication) {
        if (errors.hasErrors()) {
            return "fillInfo";
        }
        UserLogin userLogin = userService.load(authentication.getName());
        user.setBasalMetabolicRate(cpmService.calculateBasalMetabolicRate(user));
        user.setCompleteMetabolism(cpmService.calculateCompleteMetabolism(user));
        userLogin.setUser(user);
        userService.save(userLogin);
        userService.saveToFile();
        return "redirect:/";
    }
}
