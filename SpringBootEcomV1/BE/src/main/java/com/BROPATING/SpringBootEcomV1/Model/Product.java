package com.BROPATING.SpringBootEcomV1.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
    @Id
    private String id;
    private String name;
    private String brand;
    private String available;
    private Double price;
    private int quantity;
}
