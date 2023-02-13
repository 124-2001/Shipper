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
        for (Product product : products) {
            if(product.getWeight()<=10){
                order.setPrice(order.getPrice()+15);
            }
            else if(product.getWeight()<=20){
                order.setPrice(order.getPrice()+20);
            }
            else {
                order.setPrice(order.getPrice()+30);
            }
        }
        return order.getPrice();
    }

    //tim order(idOrder) trong list don hang trang thai ok cua shipper(idShipper) de update thanh SUCCES va cong tien cho shipper do
    public void updateOrderAndSalary(int idShipper,int idOrder){
        Order order =orderRepository.findByStatusAndIdAAndShipper(StatusOrder.OK,idOrder,shipperRepository.findById(idShipper).get());
        order.setStatus(StatusOrder.SUCCESSFULLY);
        Shipper shipper = shipperRepository.findById(idShipper).get();
        shipper.getWallet_shipper().setBalance(shipper.getWallet_shipper().getBalance()+order.getPrice());
        walletRepository.save(shipper.getWallet_shipper());
        orderRepository.save(order);
    }

}
