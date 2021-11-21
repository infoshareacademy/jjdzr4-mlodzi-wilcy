package com.infoshare.myfitwebapp.service;

import com.infoshare.myfitwebapp.model.UserData;
import org.springframework.stereotype.Service;

@Service
public class CPMService {
    private static final String MALE = "male";

    public double calculatePPM(UserData userData) {
        double ppm;

        if (userData.getGender().equals(MALE)) {
            ppm = calculateBasicPPM(userData) + 5;
        } else {
            ppm = calculateBasicPPM(userData) - 161;
        }
        return ppm; // todo
    }

    private double calculateBasicPPM(UserData userData) {
        return (10 * userData.getWeight()) + (6.25 * userData.getHeight()) - (5 * userData.getAge());
    }
}
