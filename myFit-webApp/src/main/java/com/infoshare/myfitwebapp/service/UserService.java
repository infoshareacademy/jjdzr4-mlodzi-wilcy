package com.infoshare.myfitwebapp.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.infoshare.myfitwebapp.model.UserData;
import com.infoshare.myfitwebapp.model.UserLogin;
import com.infoshare.myfitwebapp.repository.UserDataRepository;
import com.infoshare.myfitwebapp.repository.UserLoginRepository;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
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

    public UserLogin load(String userName){
        return userRepository.findByUsername(userName);
    }

    public void saveToFile(){
        List<UserLogin> list = userRepository.findAll();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            Writer fileWriter = new FileWriter("myFit-webApp/src/main/resources/loginData.json");
            gson.toJson(list, fileWriter);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
