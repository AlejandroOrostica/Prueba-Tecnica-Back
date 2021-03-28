package com.avla.test.models;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name= "email")
    private String email;

    @Column(name= "password")
    private String password;

    @Column(name= "rol")
    private String rol;

    @Column(name= "name")
    private String name;


}