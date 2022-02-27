package com.infoshare.myfitwebapp.entity;

import com.infoshare.myfitwebapp.enums.ActivityLevel;
import com.infoshare.myfitwebapp.enums.Gender;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Data
@Table(name = User.TABLE_NAME)
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {

    public static final String TABLE_NAME = "user";
    public static final String COLUMN_PREFIX = "u_";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = COLUMN_PREFIX + "id")
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = COLUMN_PREFIX + "name", nullable = false)
    @NotBlank(message = "{message.notEmpty}")
    private String name;

    @Column(name = COLUMN_PREFIX + "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    @NotNull(message = "{message.notEmpty}")
    private Gender gender;

    @Column(name = COLUMN_PREFIX + "birthDate")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Past(message = "{message.past}")
    @NotNull(message = "{message.notEmpty}")
    private LocalDate birthDate;

    @Column(name = COLUMN_PREFIX + "height", nullable = false)
    @Positive(message = "{message.positive}")
    private int height;

    @Column(name = COLUMN_PREFIX + "weight", nullable = false)
    @Positive(message = "{message.positive}")
    private double weight;

    @Column(name = COLUMN_PREFIX + "levelOfJobActivity", nullable = false)
    @Enumerated(EnumType.STRING)
    private ActivityLevel levelOfJobActivity;

    @Column(name = COLUMN_PREFIX + "levelOfPrivateActivity", nullable = false)
    @Enumerated(EnumType.STRING)
    private ActivityLevel levelOfPrivateActivity;

    @Column(name = COLUMN_PREFIX + "weightGoal", nullable = false)
    @Positive(message = "{message.positive}")
    private double weightGoal;

    @Column(name = COLUMN_PREFIX + "basalMetabolicRate", nullable = false)
    private double basalMetabolicRate;

    @Column(name = COLUMN_PREFIX + "completeMetabolism", nullable = false)
    private double completeMetabolism;

    public int calculateAge() {
        LocalDate today = LocalDate.now();
        return Period.between(birthDate, today).getYears();
    }
}