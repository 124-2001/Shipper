package com.example.shipper.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "shipper")
public class Shipper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String phone;

    @OneToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet_shipper;

    /*@OneToMany(mappedBy = "shipper")
    private List<Order> orders;*/

}
