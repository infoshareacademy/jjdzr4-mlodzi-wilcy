package com.infoshare.myfitwebapp.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = DishProductRow.TABLE_NAME)
public class DishProductRow {

    public static final String TABLE_NAME = "product_row";
    public static final String COLUMN_PREFIX = "pr_";

    @Id
    @GeneratedValue()
    @Column(name = COLUMN_PREFIX + "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "product_p_id", nullable = false)
    private Product product;

    private int amount;

    @ManyToOne
    @JoinColumn(name = "dish_d_id", nullable = false)
    private Dish dish;
}