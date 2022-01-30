package com.infoshare.myfitwebapp.model;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@Entity
@Data
public class UserLogin {

    private static final String NOT_EMPTY_MESSAGE = "Pole nie może być puste";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Setter(AccessLevel.NONE)
    private Long id;
    @Column(nullable = false, unique = true)
    @NotEmpty(message = NOT_EMPTY_MESSAGE)
    private String username;
    @Column(nullable = false)
    @NotEmpty(message = NOT_EMPTY_MESSAGE)
    private String password;
    @OneToOne(cascade = CascadeType.ALL)
    private User user;
}
