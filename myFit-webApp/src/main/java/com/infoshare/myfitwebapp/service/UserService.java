package com.infoshare.myfitwebapp.service;

import com.infoshare.myfitwebapp.entity.UserLogin;
import com.infoshare.myfitwebapp.repository.UserLoginRepository;
import com.infoshare.myfitwebapp.util.JsonMapper;
import org.springframework.stereotype.Service;

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

    public Iterable<UserLogin> save(List<UserLogin> users) {
        return userRepository.saveAll(users);
    }

    public UserLogin save(UserLogin userLogin) {
        return userRepository.save(userLogin);
    }

    public UserLogin load(String userName) {
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
}
