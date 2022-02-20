package com.infoshare.myfitwebapp.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.infoshare.myfitwebapp.model.UserLogin;
import com.infoshare.myfitwebapp.repository.UserLoginRepository;
import com.infoshare.myfitwebapp.util.JsonMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
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
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();



        try {
            jsonMapper.getObjectMapper().writerWithDefaultPrettyPrinter().writeValue(new File("src/main/resources/loginData.json"), users);
 /*           Writer fileWriter = new FileWriter("src/main/resources/loginData.json");
            gson.toJson(users, fileWriter);
            fileWriter.flush();
            fileWriter.close();*/
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
