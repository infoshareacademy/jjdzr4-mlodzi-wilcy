package com.infoshare.myfitwebapp;

import com.infoshare.myfitwebapp.model.UserData;
import com.infoshare.myfitwebapp.service.CPMService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

        UserData userData = new UserData();
        userData.setAge(15);
        userData.setHeight(167);
        userData.setWeight(90);
        userData.setGender("male");


        Assertions.assertThat(cpmService.calculatePPM(userData)).isEqualTo(1873.75);

    }

}
