package com.example.shipper.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String phone;

    @OneToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet_customer;

    /*@OneToOne(mappedBy = "customer")
    private Order order;*/



}
