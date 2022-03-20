package com.infoshare.myfitwebapp.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = Dish.TABLE_NAME)
public class Dish {

    public static final String TABLE_NAME = "dish";
    public static final String COLUMN_PREFIX = "d_";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = COLUMN_PREFIX + "id")
    private Long id;

    @NotEmpty(message = "{message.notEmpty}")
    @Column(name = COLUMN_PREFIX + "name", nullable = false)
    private String name;

    @Column(name = COLUMN_PREFIX + "sumOfKcalPer100g", nullable = false)
    private int sumOfKcalPer100g;

    @Column(name = COLUMN_PREFIX + "sumOfFatPer100g", nullable = false)
    private double sumOfFatPer100g;

    @Column(name = COLUMN_PREFIX + "sumOfCarbohydratesPer100g", nullable = false)
    private double sumOfCarbohydratesPer100g;

    @Column(name = COLUMN_PREFIX + "sumOfProteinPer100g", nullable = false)
    private double sumOfProteinPer100g;

    @ElementCollection
    private List<String> productsNameList = new ArrayList<>();

    @OneToMany(mappedBy = "dish")
    private List<ProductRow> productRows = new ArrayList<>();
}
