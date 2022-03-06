package com.infoshare.myfitwebapp.enums;

import lombok.Getter;

@Getter
public enum Units {
    PIECE("pc."),
    MILLIGRAM("mg"),
    GRAM("g"),
    KILOGRAM("kg");
// TODO - implement Units in product entity

    private final String value;

    Units(String value) {
        this.value = value;
    }
}
