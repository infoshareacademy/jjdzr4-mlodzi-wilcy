package com.infoshare.myfitwebapp.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

@Entity
@Data
@Table(name = User.TABLE_NAME)
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Product {

    public static final String TABLE_NAME = "product";
    public static final String COLUMN_PREFIX = "p_";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Setter(AccessLevel.NONE)
    private Long id;

    @NotBlank(message = "{message.notEmpty}")
    @Column(nullable = false)
    private String name;

    @PositiveOrZero(message = "{message.positiveOrZero}")
    @Max(value = 100, message = "{message.max100}")
    @Column(nullable = false)
    private int kcalPer100g;

    @PositiveOrZero(message = "{message.positiveOrZero}")
    @Max(value = 100, message = "{message.max100}")
    @Column(nullable = false)
    private double fatPer100g;

    @PositiveOrZero(message = "{message.positiveOrZero}")
    @Max(value = 100, message = "{message.max100}")
    @Column(nullable = false)
    private double carbohydratesPer100g;

    @PositiveOrZero(message = "{message.positiveOrZero}")
    @Max(value = 100, message = "{message.max100}")
    @Column(nullable = false)
    private double proteinPer100g;


}
