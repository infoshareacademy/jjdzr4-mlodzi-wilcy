package com.infoshare.myfitwebapp;

import com.infoshare.myfitwebapp.model.User;
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

        User user = new User();
        user.setAge(15);
        user.setHeight(167);
        user.setWeight(90);
        user.setGender("male");


        Assertions.assertThat(cpmService.calculateBasalMetabolicRate(user)).isEqualTo(1873.75);

    }

}
