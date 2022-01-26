package com.infoshare.myfitwebapp.model;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;


@Entity
@Data
public class UserLogin {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Getter
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    @OneToOne(cascade = CascadeType.ALL)
    private UserData userData;
}
