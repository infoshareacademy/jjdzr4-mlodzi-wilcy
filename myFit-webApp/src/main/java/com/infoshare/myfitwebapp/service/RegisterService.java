package com.infoshare.myfitwebapp.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.infoshare.myfitwebapp.model.UserData;
import com.infoshare.myfitwebapp.model.UserLogin;
import com.infoshare.myfitwebapp.repository.UserDataRepository;
import com.infoshare.myfitwebapp.repository.UserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

@Service
public class RegisterService {

    @Autowired
    UserLoginRepository userLoginRepository;
    @Autowired
    UserDataRepository userDataRepository;


    public void addUser(){
        UserLogin userLogin = new UserLogin();
        userLogin.setUsername("abc");
        userLogin.setPassword("123");
        UserData userData = new UserData();
        userData.setAge(10);
        userData.setGender("male");
        userData.setHeight(100);
        userData.setWeight(50);
        userData.setName("name");
        userData.setCpm(10);
        userData.setLevelOfJobActivity("low");
        userData.setLevelOfPrivateActivity("low");
        userData.setPpm(10);
        userData.setWeightGoal(60);
        userLogin.setUserData(userData);
        userLoginRepository.save(userLogin);
        UserLogin userLogin1 = new UserLogin();
        userLogin1.setUsername("aaaa");
        userLogin1.setPassword("123");
        userLoginRepository.save(userLogin1);
        saveToFile();
        saveToFile2();
    }

    public void saveToFile(){
       List<UserLogin> list = userLoginRepository.findAll();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            Writer fileWriter = new FileWriter("loginData.json");
            gson.toJson(list, fileWriter);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void saveToFile2(){
        List<UserData> list = userDataRepository.findAll();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            Writer fileWriter = new FileWriter("userData.json");
            gson.toJson(list, fileWriter);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
