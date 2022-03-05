package com.infoshare.myfitwebapp.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("diet")
public class DietController {

    private static final Logger LOGGER = LogManager.getLogger(DietController.class);

    @GetMapping("")
    public String getAllDishes() {
        LOGGER.info("Received request for all dishes");
        return "diet";
    }


}
