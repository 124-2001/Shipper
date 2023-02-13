package com.example.shipper.service;

import com.example.shipper.model.Order;
import com.example.shipper.model.Shipper;
import com.example.shipper.model.eNum.Quantity;
import com.example.shipper.model.eNum.StatusOrder;
import com.example.shipper.repository.OrderRepository;
import com.example.shipper.repository.ShipperRepository;
import com.example.shipper.repository.WalletRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ShipperService {
    @Autowired
    ShipperRepository shipperRepository;

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    WalletRepository walletRepository;
    @Autowired
    OrderService orderService;

    public float getSalaryInOrder(Shipper shipper){
        List<Order> orders = orderRepository.findByShipper(shipper);
        float salary =0;
        for (Order order : orders) {
            if(order.getStatus()==StatusOrder.COMPLETE){
                break;
            }
            if(order.getStatus()== StatusOrder.SUCCESSFULLY){
                salary += orderService.getPriceInOrder(order)+orderService.getPriceInOrder(order)/10;
            }else {
                salary+=orderService.getPriceInOrder(order);
            }
            if(order.getVote().getRate()<3){
                salary-=orderService.getPriceInOrder(order)/20;
            }
        }
        return salary;
    }
    public List<Order> getListOrdersWaiting(){
        return orderRepository.findByStatus(StatusOrder.WAITING);
    }

    //nhan don hang moi voi idOrder
    public Order getNewOrderById(int idOrder,int idShipper){
        List<Order> orders= getListOrdersWaiting();
        for (Order order : orders) {
            if(order.getId()==idOrder){
                order.setShipper(shipperRepository.findById(idOrder).get());
                order.setStatus(StatusOrder.OK);
                //luu shiper nhan don vao order
                orderRepository.save(order);
                break;
            }
        }
        return orderRepository.findById(idOrder).get();
    }

    public Order updateOrderAndSalary(int idOrder,int idShipper){
        Order order =orderRepository.findById(idOrder).get();
        order.setStatus(StatusOrder.SUCCESSFULLY);
        Shipper shipper = shipperRepository.findById(idShipper).get();
        shipper.getWallet_shipper().setBalance(shipper.getWallet_shipper().getBalance()+order.getPrice());
        walletRepository.save(shipper.getWallet_shipper());
        orderRepository.save(order);
        return order;
    }

}
