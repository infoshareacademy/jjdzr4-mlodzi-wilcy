package com.infoshare.myfitwebapp.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = Product.TABLE_NAME)
public class Product {

    public static final String TABLE_NAME = "product";
    public static final String COLUMN_PREFIX = "p_";

    @Id
    @GeneratedValue()
    @Column(name = COLUMN_PREFIX + "id")
    @Setter(AccessLevel.NONE)
    private Long id;

    @NotBlank(message = "{message.notEmpty}")
    @Column(name = COLUMN_PREFIX + "name", nullable = false)
    private String name;

    @PositiveOrZero(message = "{message.positiveOrZero}")
    @Max(value = 1000, message = "{message.max1000}")
    @Column(name = COLUMN_PREFIX + "kcalPer100g", nullable = false)
    private int kcalPer100g;

    @PositiveOrZero(message = "{message.positiveOrZero}")
    @Max(value = 100, message = "{message.max100}")
    @Column(name = COLUMN_PREFIX + "fatPer100g", nullable = false)
    private double fatPer100g;

    @PositiveOrZero(message = "{message.positiveOrZero}")
    @Max(value = 100, message = "{message.max100}")
    @Column(name = COLUMN_PREFIX + "carbohydratesPer100g", nullable = false)
    private double carbohydratesPer100g;

    @PositiveOrZero(message = "{message.positiveOrZero}")
    @Max(value = 100, message = "{message.max100}")
    @Column(name = COLUMN_PREFIX + "proteinPer100g", nullable = false)
    private double proteinPer100g;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = Product.COLUMN_PREFIX + "dish", nullable = false)
    List<Dish> dishList;

}
