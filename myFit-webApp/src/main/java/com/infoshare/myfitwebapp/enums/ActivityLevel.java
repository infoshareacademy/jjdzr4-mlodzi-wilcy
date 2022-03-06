package com.infoshare.myfitwebapp.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
public enum ActivityLevel {
    LOW("Low"),
    MEDIUM("Medium"),
    HIGH("High");

    private final String value;

    ActivityLevel(String value) {
        this.value = value;
    }
}
