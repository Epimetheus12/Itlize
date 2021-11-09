package com.itlize.backend.demo.entities;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue
    private int id;

    @Enumerated(EnumType.STRING)
    private Role role;
}
