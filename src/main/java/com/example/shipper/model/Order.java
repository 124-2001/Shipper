package com.example.shipper.model;

import com.example.shipper.model.eNum.StatusOrder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @OneToOne()
    @JoinColumn(name = "order_customer")
    private Customer customer;

    private float price;
    private StatusOrder status;

    @ManyToOne()
    @JoinColumn(name = "order_shipper_id")
    private Shipper shipper;

    private String address;
    private Date time_order;
    private int estimate_time;
    @OneToMany(mappedBy = "order")
    private List<Product> products;


    @OneToOne()
    @JoinColumn(name = "vote_id")
    private Vote vote;
}
