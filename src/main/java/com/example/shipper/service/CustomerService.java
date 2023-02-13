package com.example.shipper.service;

import com.example.shipper.model.Customer;
import com.example.shipper.model.Order;
import com.example.shipper.model.Product;
import com.example.shipper.model.Wallet;
import com.example.shipper.model.eNum.StatusOrder;
import com.example.shipper.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CustomerService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    VoteRepository voteRepository;
    @Autowired
    WalletRepository walletRepository;
    @Autowired
    OrderService orderService;
    //thay cho authenticate bang tim customer bang id
    public boolean findCustomer(int idCustomer){
        if(customerRepository.findById(idCustomer).isPresent()){
            return true;
        }
        return false;
    }
    //tao don order moi voi trang thai waiting de cho shipper giao
    public void makeOrderWithNewProduct(int idCustomer, List<Product> products){
        if(findCustomer(idCustomer)){
            Order order = new Order();
            order.setCustomer(customerRepository.findById(idCustomer).get());
            order.setProducts(products);
            order.setPrice(orderService.getPriceInOrder(order));
            order.setStatus(StatusOrder.WAITING);
            orderRepository.save(order);
            //tru tien sau khi tao don hang
            Customer customer = customerRepository.findById(idCustomer).get();
            customer.getWallet_customer().setBalance(customer.getWallet_customer().getBalance()-orderService.getPriceInOrder(order));
            customerRepository.save(customer);
        }
    }

    public void voteForShipperInOrder(int idCustomer,int idOrder,int voteRate){
        if(findCustomer(idCustomer)){
            Order order = orderRepository.findById(idOrder).get();
            order.getVote().setRate(voteRate);
            if(voteRate<3){
                order.getShipper().getWallet_shipper().setBalance(order.getShipper().getWallet_shipper().getBalance()-(order.getPrice()/20));
            }
            voteRepository.save(order.getVote());
            walletRepository.save(order.getShipper().getWallet_shipper());
        }
    }
}
