package com.infoshare.myfitwebapp;

import com.infoshare.myfitwebapp.enums.ActivityLevel;
import com.infoshare.myfitwebapp.enums.Gender;
import com.infoshare.myfitwebapp.entity.User;
import com.infoshare.myfitwebapp.service.CPMService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

@SpringBootTest
@RunWith(SpringRunner.class)
class MyFitWebAppApplicationTests {

    @Autowired
    CPMService cpmService;

    @Test
    void contextLoads() {
    }

    @Test
    void shouldReturnPPM() {
        User user = new User();
        user.setBirthDate(LocalDate.of(2007,1,1));
        user.setHeight(167);
        user.setWeight(90);
        user.setGender(Gender.MALE);

        Assertions.assertThat(cpmService.calculateBasalMetabolicRate(user)).isEqualTo(1873.75);

    }
    @Test
    void shouldReturnCPM() {
        User user = new User();
        user.setBirthDate(LocalDate.of(2007,1,1));
        user.setHeight(167);
        user.setWeight(90);
        user.setGender(Gender.MALE);
        user.setLevelOfJobActivity(ActivityLevel.LOW);
        user.setLevelOfPrivateActivity(ActivityLevel.MEDIUM);
        user.setBasalMetabolicRate(cpmService.calculateBasalMetabolicRate(user));

        Assertions.assertThat(cpmService.calculateCompleteMetabolism(user)).isEqualTo(2998.0);
    }

}
