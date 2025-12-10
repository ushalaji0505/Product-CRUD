package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
    private ProductService service;

    @PostMapping("/create") 
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product savedProduct = service.saveProduct(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @GetMapping("/get/all")
    public List<Product> findAllProducts() {
        return service.getProducts();
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable Long id) {
        Product product = service.getProductById(id);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PutMapping("/update")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {

        Product updatedProduct = service.updateProduct(product); 
        if (updatedProduct != null) {
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        if (service.getProductById(id) != null) {
             String message = service.deleteProduct(id);

             return new ResponseEntity<>(message, HttpStatus.OK); 
        }
        return new ResponseEntity<>("Product not found.", HttpStatus.NOT_FOUND);
    }
}
