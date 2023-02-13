package com.example.shipper.service;

import com.example.shipper.model.Order;
import com.example.shipper.model.Product;
import com.example.shipper.model.Shipper;
import com.example.shipper.model.eNum.StatusOrder;
import com.example.shipper.repository.OrderRepository;
import com.example.shipper.repository.ProductRepository;
import com.example.shipper.repository.ShipperRepository;
import com.example.shipper.repository.WalletRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ShipperRepository shipperRepository;
    @Autowired
    WalletRepository walletRepository;

    public float getPriceInOrder(Order order){
        List<Product> products = order.getProducts();
        float weight=0;
        for (Product product : products) {
            weight+=product.getWeight();
        }
        if(weight<10){
            return 15000;
        } else if (10<weight&&weight<=20) {
            return 20000;
        }else {
            return 30000;
        }
    }

    //tim order(idOrder) trong list don hang trang thai ok cua shipper(idShipper) de update thanh SUCCES va cong tien cho shipper do



}
