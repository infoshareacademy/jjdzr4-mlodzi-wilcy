package com.infoshare.myfitwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @GetMapping("user")
    public String getUser() {
        return "user";
    }

    @PostMapping("goToUserEdit")
    public String goToEdit(){
        return "redirect:/user/edit";
    }

    @GetMapping("user/edit")
    public String getUserEdit() {
        return "edit-user";
    }

}

