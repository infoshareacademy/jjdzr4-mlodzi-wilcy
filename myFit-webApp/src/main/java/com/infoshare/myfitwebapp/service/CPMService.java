package com.infoshare.myfitwebapp.service;

import com.infoshare.myfitwebapp.model.User;
import org.springframework.stereotype.Service;

@Service
public class CPMService {
    private static final String MALE = "male";

    public double calculateBasalMetabolicRate(User user) {
        double bmr;

        if (user.getGender().equals(MALE)) {
            bmr = calculateBasicBasalMetabolicRate(user) + 5;
        } else {
            bmr = calculateBasicBasalMetabolicRate(user) - 161;
        }
        return bmr; // todo
    }

    private double calculateBasicBasalMetabolicRate(User user) {
        return (10 * user.getWeight()) + (6.25 * user.getHeight()) - (5 * user.getAge());
    }
}
