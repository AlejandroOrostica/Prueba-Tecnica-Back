package com.avla.test.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "user_product_log")
@Data
public class UserProductLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name= "log")
    private String log;

    @Column(name= "created_at")
    @CreationTimestamp
    private Date created_at;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name= "user_id")
    User user;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name= "product_id")
    Product product;


    public UserProductLog(String log, User user, Product product) {
        this.log = log;
        this.user = user;
        this.product = product;
    }
    public UserProductLog(){}
}
