package com.itlize.backend.demo.entities;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue
    private int id;

    //I made changes here Fangji

    @Enumerated(EnumType.STRING)
    private Role role;
}
