package com.example.shipper.service;

import com.example.shipper.model.Order;
import com.example.shipper.model.Shipper;
import com.example.shipper.model.eNum.Quantity;
import com.example.shipper.model.eNum.StatusOrder;
import com.example.shipper.repository.OrderRepository;
import com.example.shipper.repository.ShipperRepository;
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
    public void getNewOrderById(int idOrder,int idShipper){
        List<Order> orders= orderRepository.findByStatus(StatusOrder.WAITING);
        for (Order order : orders) {
            if(order.getId()==idOrder){
                order.setShipper(shipperRepository.findById(idOrder).get());
                order.setStatus(StatusOrder.OK);
                //luu shiper nhan don vao order
                orderRepository.save(order);
                break;
            }
        }
    }

}
