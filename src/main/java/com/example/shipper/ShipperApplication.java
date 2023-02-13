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
        Customer customer= new Customer();
        Customer customer1 = new Customer();
        Order order = new Order();
        Order order1 = new Order();
        Product product = new Product();
        Product product1= new Product();
        Shipper shipper = new Shipper();
        Vote vote = new Vote();
        Wallet walletCustomer = new Wallet();
        Wallet walletCustomer1 = new Wallet();
        Wallet walletShipper = new Wallet();


        //product
        product.setName("Hoa qua");
        product.setWeight(20);
        product.setQuantity(Quantity.GOOD);
        product.setOrder(order);

        product1.setName("Quan ao");
        product1.setWeight(0.5f);
        product1.setQuantity(Quantity.GOOD);
        product1.setOrder(order);
        //save product
        /*productRepository.save(product);*/
        productRepository.save(product1);
        //order
        order.setStatus(StatusOrder.SUCCESSFULLY);
        order.setShipper(shipper);
        order.setProducts(Arrays.asList(product));
        order.setPrice(orderService.getPriceInOrder(order));

        order1.setStatus(StatusOrder.SUCCESSFULLY);
        order1.setShipper(shipper);
        order1.setProducts(Arrays.asList(product,product1));
        order1.setPrice(orderService.getPriceInOrder(order1));
        //vote
        vote.setRate(4);
        vote.setMessage("Rat la ok");
        //save vote
       /* voteRepository.save(vote);*/

        //add vote in order
        order.setVote(vote);
        order1.setVote(vote);
        //wallet
        walletCustomer.setAccountNum("001");
        walletCustomer.setBalance(100000);

        walletCustomer1.setAccountNum("003");
        walletCustomer1.setBalance(100000);

        walletShipper.setAccountNum("002");
        walletShipper.setBalance(0);
        //save wallet
        /*walletRepository.save(walletCustomer);
        walletRepository.save(walletCustomer1);
        walletRepository.save(walletShipper);*/

        //customer shipper
        customer.setName("Nam");
        customer.setPhone("+012345678");
        customer.setWallet_customer(walletCustomer);

        customer1.setName("Tien");
        customer1.setPhone("+012456752");
        customer1.setWallet_customer(walletCustomer);

        shipper.setName("Trong");
        shipper.setPhone("+02341565");
        /*shipperRepository.save(shipper);*/
        shipper.setWallet_shipper(walletShipper);
        //save customer shipper
        /*customerRepository.save(customer);
        customerRepository.save(customer1);*/
        /*shipperRepository.save(shipper);*/

        //save order
        order.setCustomer(customer);
        order1.setCustomer(customer1);
        order.setShipper(shipper);
        order1.setShipper(shipper);
        /*orderRepository.save(order);
        orderRepository.save(order1);*/


    }
}
