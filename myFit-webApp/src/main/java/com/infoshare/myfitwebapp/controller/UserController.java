package com.infoshare.myfitwebapp.controller;

import com.infoshare.myfitwebapp.model.UserData;
import com.infoshare.myfitwebapp.model.UserLogin;
import com.infoshare.myfitwebapp.model.UserPrincipal;
import com.infoshare.myfitwebapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    final
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String getUser() {
        return "user";
    }

    @GetMapping("fillInfo")
    public String fillUserData(Model model){
        model.addAttribute("userData", new UserData());
        return "fillInfo";
    }

    @PostMapping("fillInfo")
    public String fillUserDataFinish(@Valid @ModelAttribute("userData") UserData userData, Errors errors, Authentication authentication){
        if(errors.hasErrors()){
            return "fillInfo";
        }
        UserLogin userLogin = userService.load(authentication.getName());
        userLogin.setUserData(new UserData());
        userService.save(userLogin);
        userService.saveToFile();
        return "redirect:/";
    }

    }
