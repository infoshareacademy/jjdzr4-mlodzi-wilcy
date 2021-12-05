package com.infoshare.myfitwebapp.service;

import com.infoshare.myfitwebapp.model.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    final CPMService cpmService;

    public UserService(CPMService cpmService) {
        this.cpmService = cpmService;
    }

    public UserData createUser(){
        UserData userData = new UserData();
        userData.setName("user");
        userData.setGender("male");
        userData.setAge(20);
        userData.setHeight(170);
        userData.setWeight(70);
        userData.setLevelOfJobActivity("medium");
        userData.setLevelOfPrivateActivity("medium");
        userData.setPPM(cpmService.calculatePPM(userData));
        return userData;
    }
}
