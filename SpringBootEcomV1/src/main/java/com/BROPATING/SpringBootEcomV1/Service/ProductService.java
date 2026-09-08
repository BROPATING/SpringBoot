package com.BROPATING.SpringBootEcomV1.Service;

import com.BROPATING.SpringBootEcomV1.Model.Product;
import com.BROPATING.SpringBootEcomV1.Repository.ProductRepo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.net.http.HttpResponse;
import java.util.List;

@Service
public class ProductService {
    private ProductRepo productRepo;

    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }

    public Product getProdById(String prodId){
        return productRepo.findById(prodId).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Product Not Found"
        ));
    }

}
