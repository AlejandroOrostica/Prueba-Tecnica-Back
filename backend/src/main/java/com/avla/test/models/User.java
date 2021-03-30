package com.avla.test.models;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name= "email", unique = true)
    private String email;

    @Column(name= "password")
    private String password;

    @Column(name= "rol")
    private String rol;

    @Column(name= "name")
    private String name;

    @OneToMany(mappedBy = "user")
    List<UserProductLog> logs;
}
