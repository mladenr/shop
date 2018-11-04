package com.sw.shop.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Entity(name = "homes")
public class HomeEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(max = 20)
    private String alias;

    @NotEmpty
    @Size(max = 30)
    private String streetName;

    @NotNull
    private Integer streetNumber;

    private Integer homeNumber;

    @NotEmpty
    @Size(max = 20)
    private String city;

    @NotEmpty
    @Size(max = 10)
    private String postalCode;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @NotNull
    private UserEntity user;

    @OneToMany
    private List<ProductGroupEntity> productGroups;
}
