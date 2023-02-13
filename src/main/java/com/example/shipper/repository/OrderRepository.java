package com.example.shipper.repository;

import com.example.shipper.model.Customer;
import com.example.shipper.model.Order;

import com.example.shipper.model.Shipper;
import com.example.shipper.model.eNum.StatusOrder;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
    List<Order> findByShipper(Shipper shipper);

    List<Order> findByStatus(StatusOrder statusOrder);

    Order findByStatusAndIdAAndShipper(StatusOrder statusOrder,int idOrder,Shipper shipper);

    Order findByCustomerAndStatus(Optional<Customer> customer, StatusOrder statusOrder);
}
