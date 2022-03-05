package com.infoshare.myfitwebapp.controller;

import com.infoshare.myfitwebapp.entity.User;
import com.infoshare.myfitwebapp.entity.UserLogin;
import com.infoshare.myfitwebapp.service.CPMService;
import com.infoshare.myfitwebapp.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    private static final Logger LOGGER = LogManager.getLogger(LoginController.class);

    final UserService userService;
    final CPMService cpmService;

    public LoginController(UserService userService, CPMService cpmService) {
        this.userService = userService;
        this.cpmService = cpmService;
    }

    @GetMapping("/")
    public String hello(Authentication authentication, Model model) {
        LOGGER.info("Received request to authenticate user");
        if (authentication != null) {
            LOGGER.info("Authentication OK");
            UserLogin userLogin = userService.load(authentication.getName());
            if (userLogin.getUser() == null) {
                LOGGER.info("User data loaded");
                return fillUserData(model);
            }
        } else {
            LOGGER.error("Authentication failed");
        }
        return "index";
    }

    @GetMapping("login")
    public String login() {
        LOGGER.info("Received request to login user");
        return "login";
    }

    @GetMapping("register")
    public String register(Model model) {
        LOGGER.info("Received request to register user");
        model.addAttribute("user", new UserLogin());
        return "register";
    }

    @PostMapping("register")
    public String addUser(@Valid @ModelAttribute("user") UserLogin userLogin, Errors errors) {
        LOGGER.info("Received request to login user");
        if (errors.hasErrors()) {
            LOGGER.error("Adding user failure. Form contains errors");
            return "register";
        }
        try {
            userService.load(userLogin.getUsername()).getUsername();
        } catch (NullPointerException e) {
            userService.save(userLogin);
            LOGGER.info("New user saved");
            userService.saveToFile();
            LOGGER.info("New user saved to file");
            return "redirect:/";
        }
        return "redirect:register?error";
    }

    @GetMapping("fillInfo")
    public String fillUserData(Model model) {
        LOGGER.info("Received request to fill user data");
        model.addAttribute("user", new User());
        return "fillInfo";
    }

    @PostMapping("fillInfo")
    public String fillUserDataFinish(@Valid @ModelAttribute("user") User user, Errors errors, Authentication authentication) {
        if (errors.hasErrors()) {
            LOGGER.error("Filling user data failure. Form contains errors");
            return "fillInfo";
        }
        UserLogin userLogin = userService.load(authentication.getName());
        user.setBasalMetabolicRate(cpmService.calculateBasalMetabolicRate(user));
        user.setCompleteMetabolism(cpmService.calculateCompleteMetabolism(user));
        userLogin.setUser(user);
        userService.save(userLogin);
        LOGGER.info("User data saved");
        userService.saveToFile();
        LOGGER.info("User data saved to file");
        return "redirect:/";
    }
}
