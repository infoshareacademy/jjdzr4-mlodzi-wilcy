package com.infoshare.myfitwebapp.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
public @Data
class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Setter(AccessLevel.NONE)
    private Long id;
    @NotEmpty(message = "{message.notEmpty}")
    @Column(nullable = false)
    private String name;
}
