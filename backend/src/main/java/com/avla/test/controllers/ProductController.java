package com.avla.test.controllers;

import com.avla.test.models.Product;
import com.avla.test.models.User;
import com.avla.test.models.UserProductLog;
import com.avla.test.repositories.ProductRepository;
import com.avla.test.repositories.UserProductLogRepository;
import com.avla.test.repositories.UserRepository;
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

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProductLogRepository userProductLogRepository;

    @GetMapping(value = "")
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @PostMapping(value = "{userId}/add")
    public Product createProduct(@RequestBody Product product, @PathVariable(value = "userId") Long userId){
        Product createdProduct = productRepository.save(product);
        User user = userRepository.findUserById(userId);
        String log = "El usuario " + user.getName() + " ingresó el item " + product.getName();
        UserProductLog productLog = new UserProductLog(log, user, product);
        userProductLogRepository.save(productLog);
        return createdProduct;
    }

    @GetMapping(value = "{productId}")
    public Product getProduct(@PathVariable(value = "productId") Long productId){
        return productRepository.findById(productId).get();
    }

    @PutMapping(value = "/{userId}/update/{productId}")
    public Product updateProduct(@PathVariable(value = "productId") Long productId,@PathVariable(value = "userId") Long userId, @RequestBody Product updatedProduct){
        Product product = productRepository.findById(productId).get();
        User user = userRepository.findUserById(userId);

        String log = "El usuario " + user.getName() + " actualizó el estado del item " +
                product.getName() + " de " + product.getState() + " a " + updatedProduct.getState();
        product.setName(updatedProduct.getName());
        product.setDescription(updatedProduct.getDescription());
        product.setState(updatedProduct.getState());

        UserProductLog productLog = new UserProductLog(log, user, product);
        userProductLogRepository.save(productLog);



        return productRepository.save(product);
    }

    @DeleteMapping(value = "{productId}" )
    public ResponseEntity<Long> deleteProduct(@PathVariable(value = "productId") Long productId){
        Product product = productRepository.findById(productId).get();
        productRepository.delete(product);
        return new ResponseEntity<>(productId, HttpStatus.OK );

    }



}
