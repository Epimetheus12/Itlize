package com.itlize.backend.demo.entities;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue
    private int id;

    //I made changes here Fangji
    // 2nd change made
    @Enumerated(EnumType.STRING)
    private Role role;
}
