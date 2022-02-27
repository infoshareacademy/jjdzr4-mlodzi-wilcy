package com.infoshare.myfitwebapp.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class JsonMapper {

    private final ObjectMapper objectMapper;

    public JsonMapper() {
        objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
    }
}
