package com.infoshare.myfitwebapp.service;

import com.infoshare.myfitwebapp.model.UserData;
import com.infoshare.myfitwebapp.model.UserLogin;
import com.infoshare.myfitwebapp.repository.UserDataRepository;
import com.infoshare.myfitwebapp.repository.UserLoginRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserLoginRepository userRepository;
    private final UserDataRepository userDataRepository;

    public UserService(UserLoginRepository userRepository, UserDataRepository userDataRepository) {
        this.userRepository = userRepository;
        this.userDataRepository = userDataRepository;
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

    public Iterable<UserData> saveUsersData(List<UserData> users) {
        return userDataRepository.saveAll(users);
    }

    public UserData loadUserData(Long id) {
        return userDataRepository.findById(id).get();
    }

}
