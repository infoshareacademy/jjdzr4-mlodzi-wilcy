package com.infoshare.myfitwebapp.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
public enum Gender {
    FEMALE("Female"),
    MALE("Male");

    private final String value;

    Gender(String value) {
        this.value = value;
    }
}
