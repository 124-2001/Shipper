package com.example.shipper.service;

import com.example.shipper.model.DTO.ProductDTO;
import com.example.shipper.model.Product;
import com.example.shipper.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductService {
    @Autowired
    ProductRepository productRepository;


/*    public void insertProduct(List<ProductDTO> productDTOS){
        ModelMapper mapper = new ModelMapper();

        for (ProductDTO productDTO : productDTOS) {
            Product product = mapper.map(productDTO,Product.class);
            productRepository.save(product);
        }
    }*/

}
