package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	
	@Id // Specifies the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment for Postgres
    private Long id;
    
    private String name;
    
    private Double price;
    
    private Integer quantity;

}
