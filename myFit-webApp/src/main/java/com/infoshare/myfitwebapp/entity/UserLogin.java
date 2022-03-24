package com.infoshare.myfitwebapp.entity;

import com.infoshare.myfitwebapp.enums.AuthenticationProvider;
import com.infoshare.myfitwebapp.validation.PasswordMatches;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;


@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = UserLogin.TABLE_NAME)
public class UserLogin {

    public static final String TABLE_NAME = "user_login";
    public static final String COLUMN_PREFIX = "u_l_";

    private static final String NOT_EMPTY_MESSAGE = "Pole nie może być puste";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = COLUMN_PREFIX + "id")
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = COLUMN_PREFIX + "username", nullable = false, unique = true)
    @NotBlank(message = NOT_EMPTY_MESSAGE)
    private String username;

    @Column(name = COLUMN_PREFIX + "password")
    @NotBlank(message = NOT_EMPTY_MESSAGE)
    private String password;

    private String matchingPassword;

    @Enumerated(EnumType.STRING)
    @Column(name = COLUMN_PREFIX + "auth_provider")
    private AuthenticationProvider authProvider;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserLogin userLogin = (UserLogin) o;
        return id != null && Objects.equals(id, userLogin.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
