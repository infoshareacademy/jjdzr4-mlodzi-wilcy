package com.infoshare.myfitwebapp.model;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = Dish.TABLE_NAME)
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Dish {

    public static final String TABLE_NAME = "dish";
    public static final String COLUMN_PREFIX = "d_";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Setter(AccessLevel.NONE)
    private Long id;
    @NotEmpty(message = "{message.notEmpty}")
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int sumOfKcalPer100g;
    @Column(nullable = false)
    private double sumOfFatPer100g;
    @Column(nullable = false)
    private double sumOfCarbohydratesPer100g;
    @Column(nullable = false)
    private double sumOfProteinPer100g;
    @ElementCollection
    private List<String> productsNameList = new ArrayList<>();
}
