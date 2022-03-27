package com.infoshare.myfitwebapp.controller;

import com.infoshare.myfitwebapp.entity.User;
import com.infoshare.myfitwebapp.entity.UserLogin;
import com.infoshare.myfitwebapp.security.oauth2.OAuth2LoginSuccessHandler;
import com.infoshare.myfitwebapp.service.CPMService;
import com.infoshare.myfitwebapp.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
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
    final ModelMapper modelMapper;


    public LoginController(UserService userService, CPMService cpmService, ModelMapper modelMapper) {
        this.userService = userService;
        this.cpmService = cpmService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/")
    public String hello(Authentication authentication, Model model) {
        LOGGER.info("Received request to authenticate user");
        if (authentication != null) {
            LOGGER.info("Authentication OK");
            UserLogin userLogin = userService.findByUsername(authentication.getName());
            if (userLogin.getUser() == null) {
                LOGGER.info("User data loaded");
                return fillUserData(authentication, model);
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
    public String addUser(Model model, @Valid @ModelAttribute("user") UserLogin userLogin, Errors errors) {
        if (noPasswordsMatch(userLogin)) {
            return "redirect:register?mismatch";
        }
        if (errors.hasErrors()) {
            LOGGER.error("Adding user failure. Form contains errors");
            return "register";
        }
        try {
            userService.findByUsername(userLogin.getUsername()).getUsername();
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
    public String fillUserData(Authentication authentication, Model model) {
        LOGGER.info("Received request to fill user data");
        UserLogin userLogin = userService.findByUsername(authentication.getName());
        User user = new User();
        user.setName(authentication.getName());
        model.addAttribute("userLogin", userLogin);
        model.addAttribute("user", user);
        LOGGER.info("User: {}",userLogin.getUsername());
        return "fillInfo";
    }

    @PostMapping("fillInfo")
    public String fillUserDataFinish(@Valid @ModelAttribute("user") User user, @Valid @ModelAttribute("userLogin") UserLogin userLogin,Errors errors, Authentication authentication) {
        if (errors.hasErrors()) {
            LOGGER.error("Filling user data failure. Form contains errors");
            return "fillInfo";
        }
        UserLogin userFromDatabase = userService.findByEmail(userLogin.getEmail());
        user.setBasalMetabolicRate(cpmService.calculateBasalMetabolicRate(user));
        user.setCompleteMetabolism(cpmService.calculateCompleteMetabolism(user));
        //FIXME - refactor
        userFromDatabase.setUser(user);
        userFromDatabase.setUsername(userLogin.getUsername());
        userFromDatabase.setEmail(userLogin.getEmail());
        userFromDatabase.setPassword(userLogin.getPassword());
        userService.save(userFromDatabase);
        LOGGER.info("User data saved");
        userService.saveToFile();
        LOGGER.info("User data saved to file");
        return "redirect:/";
    }

    private boolean noPasswordsMatch(UserLogin userLogin) {
        return !userLogin.getPassword().equals(userLogin.getMatchingPassword());
    }
}
