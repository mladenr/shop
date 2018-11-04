package com.sw.shop.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Entity(name = "product_groups")
public class ProductGroupEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(max = 30)
    private String name;

    @NotEmpty
    @Size(max = 100)
    private String description;

    @ManyToOne
    @JoinColumn(name = "home_id")
    private HomeEntity home;
}
