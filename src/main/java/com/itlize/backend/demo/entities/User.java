package com.itlize.backend.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.EntityGraph;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;


@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name="user_sequence", sequenceName = "next_val")
    private int id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Timestamp createdTime;
    private Timestamp updatedTime;

    @Column(name = "username",nullable = false,unique = true)
    private String username;

    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    @CreationTimestamp
    private Timestamp createdTime;
    @UpdateTimestamp
    private Timestamp updatedTime;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Project> projects = new ArrayList<>();

    public int getId( ) {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getUsername( ) {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword( ) {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName( ) {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName( ) {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getEmail( ) {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPhone( ) {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Timestamp getCreatedTime( ) {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    public Timestamp getUpdatedTime( ) {
        return updatedTime;
    }

    public void setUpdatedTime(Timestamp updatedTime) {
        this.updatedTime = updatedTime;
    }


    public Role getRole( ) {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Project> getProjects( ) {
        return projects;
    }

    public void setProjects(Project project) {
        this.projects.add(project);
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString( ) {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", createdTime=" + createdTime +
                ", updatedTime=" + updatedTime +
                ", role=" + role +
                ", projects=" + projects.stream().map(Project::getId).collect(Collectors.toList()) +
                '}';
    }
}
