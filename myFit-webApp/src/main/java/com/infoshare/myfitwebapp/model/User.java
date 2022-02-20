package com.infoshare.myfitwebapp.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "{message.notEmpty}")
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

//    @Column(nullable = false)
    @Column
//    @Past(message = "{message.past}")
//    @JsonFormat(pattern = "yyyy-MM-dd")
//    @JsonSerialize(using = LocalDateSerializer.class)
//    @JsonDeserialize(using = LocalDateDeserializer.class)
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthDate;

    @Column(nullable = false)
    @PositiveOrZero(message = "{message.positiveOrZero}")
    private int height;

    @Column(nullable = false)
    @PositiveOrZero(message = "{message.positiveOrZero}")
    private double weight;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ActivityLevel levelOfJobActivity;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ActivityLevel levelOfPrivateActivity;

    @Column(nullable = false)
    @PositiveOrZero(message = "{message.positiveOrZero}")
    private double weightGoal;

    @Column(nullable = false)
    private double basalMetabolicRate;

    @Column(nullable = false)
    private double completeMetabolism;

    public int calculateAge() {
/*        LocalDate today = LocalDate.now();
//        LocalDate today = LocalDate.now();
        LocalDate bday = LocalDate.of(birthDate);
//        return Period.between(birthDate, today).getYears();
        return Period.between(bday, today).getYears();*/
        return 0;
    }
}