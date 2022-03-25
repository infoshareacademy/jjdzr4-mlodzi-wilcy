package com.infoshare.myfitwebapp.security.oauth2;

import com.infoshare.myfitwebapp.controller.DishController;
import com.infoshare.myfitwebapp.entity.UserLogin;
import com.infoshare.myfitwebapp.enums.AuthenticationProvider;
import com.infoshare.myfitwebapp.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class OAuth2LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private static final Logger LOGGER = LogManager.getLogger(DishController.class);
    private final UserService userService;

    public OAuth2LoginSuccessHandler(UserService userService) {
        this.userService = userService;
    }


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        CustomerOAuth2User oAuth2User = (CustomerOAuth2User) authentication.getPrincipal();
        String email = oAuth2User.getEmail();
        LOGGER.info("User's email: {}", email);
        String name = oAuth2User.getName();
        LOGGER.info("User's name: {}", name);
        String username = oAuth2User.getUsername();
        String password = "123"; //FIXME
        try {
            UserLogin user = userService.findByUsername(name);
            userService.updateUserAfterOAuthLoginSuccess(user, email, name, AuthenticationProvider.GOOGLE);
        } catch (NullPointerException e) {
            userService.createNewUserAfterOAuthLoginSuccess(name, email, password, AuthenticationProvider.GOOGLE);
            LOGGER.info("New user created");
        }
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
