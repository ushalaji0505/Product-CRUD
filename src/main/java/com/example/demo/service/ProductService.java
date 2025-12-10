package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {

	
	@Autowired 
    private ProductRepository repository;

    
    public Product saveProduct(Product product) {
        return repository.save(product);
    }
    
    public List<Product> getProducts() {
        return repository.findAll();
    }

    public Product getProductById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Product updateProduct(Product product) {
        Product existingProduct = repository.findById(product.getId()).orElse(null);
        
        if (existingProduct != null) {
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setQuantity(product.getQuantity());
            return repository.save(existingProduct);
        }
        return null;
    }

    public String deleteProduct(Long id) {
        repository.deleteById(id);
        return "Product removed successfully: " + id;
    }
}
