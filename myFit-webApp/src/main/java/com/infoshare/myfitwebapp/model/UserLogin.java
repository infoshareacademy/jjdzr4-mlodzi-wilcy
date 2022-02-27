package com.infoshare.myfitwebapp.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Data
@Table(name = UserLogin.TABLE_NAME)
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserLogin {

    public static final String TABLE_NAME = "user_login";
    public static final String COLUMN_PREFIX = "u_l_";

    private static final String NOT_EMPTY_MESSAGE = "Pole nie może być puste";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Setter(AccessLevel.NONE)
    private Long id;
    @Column(nullable = false, unique = true)
    @NotBlank(message = NOT_EMPTY_MESSAGE)
    private String username;
    @Column(nullable = false)
    @NotBlank(message = NOT_EMPTY_MESSAGE)
    private String password;
    @OneToOne(cascade = CascadeType.ALL)
    private User user;
}
