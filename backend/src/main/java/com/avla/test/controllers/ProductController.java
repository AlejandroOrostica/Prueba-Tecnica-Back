package com.avla.test.controllers;

import com.avla.test.models.Product;
import com.avla.test.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping(value = "")
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @PostMapping(value = "")
    public Product createProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

    @GetMapping(value = "{productId}")
    public Product getProduct(@PathVariable(value = "productId") Long productId){
        return productRepository.findById(productId).get();
    }

    @PutMapping(value = "{productId}")
    public Product updateProduct(@PathVariable(value = "productId") Long productId, @RequestBody Product updatedProduct){
        Product product = productRepository.findById(productId).get();

        product.setName(updatedProduct.getName());
        product.setDescription(updatedProduct.getDescription());
        product.setState(updatedProduct.getState());

        return productRepository.save(product);
    }

    @DeleteMapping(value = "{productId}" )
    public ResponseEntity<Long> deleteProduct(@PathVariable(value = "productId") Long productId){
        Product product = productRepository.findById(productId).get();
        productRepository.delete(product);
        return new ResponseEntity<>(productId, HttpStatus.OK );

    }



}
