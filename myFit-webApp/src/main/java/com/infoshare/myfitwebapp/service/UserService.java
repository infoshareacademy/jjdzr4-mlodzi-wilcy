package com.infoshare.myfitwebapp.service;

import com.infoshare.myfitwebapp.entity.UserLogin;
import com.infoshare.myfitwebapp.enums.AuthenticationProvider;
import com.infoshare.myfitwebapp.repository.UserLoginRepository;
import com.infoshare.myfitwebapp.util.JsonMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class UserService {

    private final UserLoginRepository userRepository;
    private final JsonMapper jsonMapper;

    public UserService(UserLoginRepository userRepository, JsonMapper jsonMapper) {
        this.userRepository = userRepository;
        this.jsonMapper = jsonMapper;
    }

    @Transactional
    public Iterable<UserLogin> save(List<UserLogin> users) {
        return userRepository.saveAll(users);
    }

    @Transactional
    public UserLogin save(UserLogin userLogin) {
        return userRepository.save(userLogin);
    }

    public UserLogin findByUsername(String userName) {
        return userRepository.findByUsername(userName);
    }

    public void saveToFile() {
        List<UserLogin> users = userRepository.findAll();
        try {
            jsonMapper.getObjectMapper().writerWithDefaultPrettyPrinter().writeValue(new File("src/main/resources/loginData.json"), users);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Transactional
    public void createNewUserAfterOAuthLoginSuccess(String username, String email, String password, AuthenticationProvider authenticationProvider){
        UserLogin userLogin = new UserLogin();
        userLogin.setUsername(username);
        userLogin.setEmail(email);
        userLogin.setPassword(password);
        userLogin.setAuthProvider(authenticationProvider);
        save(userLogin);
    }

    @Transactional
    public void updateUserAfterOAuthLoginSuccess(UserLogin userLogin,String username, String email, AuthenticationProvider authenticationProvider){
        userLogin.setUsername(username);
        userLogin.setEmail(email);
        userLogin.setAuthProvider(authenticationProvider);
        save(userLogin);
    }
}
