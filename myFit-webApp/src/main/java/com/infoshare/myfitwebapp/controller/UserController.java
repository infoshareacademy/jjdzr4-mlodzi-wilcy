package com.infoshare.myfitwebapp.controller;

import com.infoshare.myfitwebapp.model.UserData;
import com.infoshare.myfitwebapp.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.Collection;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService service) {
        this.userService = service;
    }

    @GetMapping("user")
    public String getUser() {
        return "user";
    }

    @PostMapping("goToUserEdit")
    public String goToEdit() {
        return "redirect:/user/edit";
    }

/*    @GetMapping("user/edit")
    public String getUserEdit(Model model, Principal principal) {
        model.addAttribute("user", getUserName(principal));
        return "edit-user";
    }*/

    @GetMapping("user/edit")
    public String getUserEdit(Model model, @AuthenticationPrincipal UserData user) {
        model.addAttribute("user", user);
        return "edit-user";
    }

    private String getUserName(Principal principal) {
        if (principal == null) {
            return "anonymous";
        } else {

            final UserDetails currentUser = (UserDetails) ((Authentication) principal).getPrincipal();
            Collection<? extends GrantedAuthority> authorities = currentUser.getAuthorities();
            for (GrantedAuthority grantedAuthority : authorities) {
                System.out.println(grantedAuthority.getAuthority());
            }

            ((Authentication) principal).getPrincipal();

            return principal.getName();
        }
    }

    /*@GetMapping("editUser")
    public String getUserCurrentData(Model model, Principal principal) {
        String userName = principal.getName();
        model.addAttribute("user", userService.getByName(userName));
        return "edit-user";
    }

    @PutMapping("edit-user")
    public String updateUserData() {

        return "redirect:/user";
    }*/

}

