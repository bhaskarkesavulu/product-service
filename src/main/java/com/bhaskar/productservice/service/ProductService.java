package com.bhaskar.productservice.service;


import com.bhaskar.productservice.model.Product;
import com.bhaskar.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public void createProduct(Product productRequest) {

        productRepository.save(productRequest);
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Optional <Product> getProductById(Long id){
        return productRepository.findById(id);
    }

    public Product update(Product product){
        return productRepository.save(product);
    }

    public void deleteById(Long id){
        productRepository.deleteById(id);
    }
}
