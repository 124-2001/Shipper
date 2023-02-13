package com.example.shipper;

import com.example.shipper.model.*;
import com.example.shipper.model.eNum.Quantity;
import com.example.shipper.model.eNum.StatusOrder;
import com.example.shipper.repository.*;
import com.example.shipper.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class ShipperApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ShipperApplication.class, args);
    }
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ShipperRepository shipperRepository;
    @Autowired
    VoteRepository voteRepository;
    @Autowired
    WalletRepository walletRepository;
    @Autowired
    OrderService orderService;
    @Override
    public void run(String... args) throws Exception {


        /*Wallet walletCustomer = new Wallet();
        Wallet walletShipper = new Wallet();

        walletCustomer.setAccountNum("001");
        walletCustomer.setBalance(100000);

        walletShipper.setAccountNum("002");
        walletShipper.setBalance(0);

        Customer customer = new Customer();
        customer.setName("Hoang Nam");
        customer.setPhone("0912351241");
        customer.setWallet_customer(walletCustomer);

        Shipper shipper = new Shipper();
        shipper.setName("Tien");
        shipper.setPhone("078235367");
        shipper.setWallet_shipper(walletShipper);

        walletRepository.save(walletCustomer);
        walletRepository.save(walletShipper);
        customerRepository.save(customer);
        shipperRepository.save(shipper);
*/

    }
}
