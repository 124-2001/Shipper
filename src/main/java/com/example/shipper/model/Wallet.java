package com.example.shipper.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "wallet")
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "account_num")
    private String accountNum;
    private float balance;

    /*@OneToOne(mappedBy = "wallet_customer")
    private Customer customerWallet;

    @OneToOne(mappedBy = "wallet_shipper")
    private Shipper customerShipper;*/
}
