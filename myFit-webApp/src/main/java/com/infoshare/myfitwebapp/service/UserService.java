package com.infoshare.myfitwebapp.service;

import com.infoshare.myfitwebapp.model.UserLogin;
import com.infoshare.myfitwebapp.repository.UserLoginRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserLoginRepository userRepository;

    public UserService(UserLoginRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<UserLogin> save(List<UserLogin> users) {
        return userRepository.saveAll(users);
    }

    public UserLogin save(UserLogin userLogin) {
        return userRepository.save(userLogin);
    }
}
