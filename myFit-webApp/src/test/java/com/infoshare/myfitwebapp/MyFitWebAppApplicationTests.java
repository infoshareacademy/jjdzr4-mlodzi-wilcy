package com.infoshare.myfitwebapp;

import com.infoshare.myfitwebapp.model.ActivityLevel;
import com.infoshare.myfitwebapp.model.Gender;
import com.infoshare.myfitwebapp.model.User;
import com.infoshare.myfitwebapp.service.CPMService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@SpringBootTest
@RunWith(SpringRunner.class)
class MyFitWebAppApplicationTests {
    @Autowired
    CPMService cpmService;

    @Test
    void contextLoads() {
    }

    /*@Test
    void shouldReturnPPM() {
        User user = new User();
        user.setBirthDate(LocalDateTime.of(2017,1,1,0,0));
        user.setHeight(167);
        user.setWeight(90);
        user.setGender(Gender.MALE);

        Assertions.assertThat(cpmService.calculateBasalMetabolicRate(user)).isEqualTo(1873.75);

    }
    @Test
    void shouldReturnCPM() {
        User user = new User();
        user.setBirthDate(LocalDateTime.of(2017,1,1,0,0));
        user.setHeight(167);
        user.setWeight(90);
        user.setGender(Gender.MALE);
        user.setLevelOfJobActivity(ActivityLevel.LOW);
        user.setLevelOfPrivateActivity(ActivityLevel.MEDIUM);
        user.setBasalMetabolicRate(cpmService.calculateBasalMetabolicRate(user));

        Assertions.assertThat(cpmService.calculateCompleteMetabolism(user)).isEqualTo(2998.0);
    }*/

}
