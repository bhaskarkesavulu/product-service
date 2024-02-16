package com.bhaskar.productservice.controller;


import com.bhaskar.productservice.model.Product;
import com.bhaskar.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
@Slf4j
public class ProductController {

    private final ProductService productService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody Product product){

        productService.createProduct(product);

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getAllProducts(){

        return productService.getAllProducts();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public Optional<Product> getProduct(@PathVariable("id")Long id)
    {
        log.info("Finding Product by ID is :" + id);
        return productService.getProductById(id);
    }

    @PutMapping("/update/{id}")
    public Product product(@RequestBody Product product){
        return productService.update(product);
    }

    @DeleteMapping(value = "/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById( @PathVariable("id") Long id){
        System.out.println("Id is"+id);
        productService.deleteById(id);

    }
}

