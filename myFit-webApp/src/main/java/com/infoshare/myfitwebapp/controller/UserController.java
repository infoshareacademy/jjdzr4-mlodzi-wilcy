package com.infoshare.myfitwebapp.controller;

import com.infoshare.myfitwebapp.entity.User;
import com.infoshare.myfitwebapp.entity.UserLogin;
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
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
@RequestMapping("user")
public class UserController {

    private static final Logger LOGGER = LogManager.getLogger(UserController.class);

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String getUser() {
        LOGGER.info("Received request for user");
        return "user";
    }

    @PostMapping("/goToUserEdit")
    public String goToEdit() {
        return "redirect:edit";
    }

    @GetMapping("/edit")
    public String getUpdate(Authentication authentication, Model model) {
        LOGGER.info("Received request to edit user");
        if (authentication != null) {
            LOGGER.info("Authentication OK");
            UserLogin userLogin = userService.findByUsername(authentication.getName());
            User user = userLogin.getUser();
            LOGGER.info("User data loaded");
            model.addAttribute("user", user);
        } else {
            LOGGER.error("Authentication failed");
        }
        return "user-edit";
    }

    @GetMapping("/edit-user-form")
    public String getUpdateUserForm(Authentication authentication) {
        return "user-edit";
    }

    @PostMapping(value = "/edit-user-form", params = "update")
    public String updateUser(Authentication authentication,
                             @Valid @ModelAttribute("user") User user,
                             Errors errors) {
        if (authentication != null) {
            if (errors.hasErrors()) {
                LOGGER.error("Editing user failure. Form contains errors");
                return "user-edit";
            }
            LOGGER.info("Authentication OK");
            UserLogin userLogin = userService.findByUsername(authentication.getName());
            userLogin.setUser(user);
            userService.save(userLogin);
            LOGGER.info("User saved");
            userService.saveToFile();
            LOGGER.info("User saved to file");
        } else {
            LOGGER.error("Authentication failed");
        }
        return "redirect:/";
    }
}
