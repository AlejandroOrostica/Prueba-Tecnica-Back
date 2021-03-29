package com.avla.test.models;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name= "name")
    private String name;

    @Column(name= "description")
    private String description;

    @Column(name= "state")
    private String state;

    @OneToMany(mappedBy = "product")
    List<UserProductLog> logs;


}
