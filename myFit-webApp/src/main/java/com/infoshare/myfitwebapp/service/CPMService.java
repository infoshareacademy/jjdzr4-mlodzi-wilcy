package com.infoshare.myfitwebapp.service;

import com.infoshare.myfitwebapp.model.User;
import org.springframework.stereotype.Service;

@Service
public class CPMService {
    private static final String MALE = "male";

    public double calculatePPM(User user) {
        double ppm;

        if (user.getGender().equals(MALE)) {
            ppm = calculateBasicPPM(user) + 5;
        } else {
            ppm = calculateBasicPPM(user) - 161;
        }
        return ppm; // todo
    }

    private double calculateBasicPPM(User user) {
        return (10 * user.getWeight()) + (6.25 * user.getHeight()) - (5 * user.getAge());
    }
}
