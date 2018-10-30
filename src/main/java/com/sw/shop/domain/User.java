package com.sw.shop.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class User {

    @Id
    private String username;
    private String password;
    private String firstName;
    private String lastName;
}
