package com.BROPATING.SpringBootEcomV1.Service;

import com.BROPATING.SpringBootEcomV1.Model.Product;
import com.BROPATING.SpringBootEcomV1.Repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.net.http.HttpResponse;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepo productRepo;

    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }

    public Product getProdById(String prodId){
        return productRepo.findById(prodId).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Product Not Found"
        ));
    }

    public void addProd(Product prod){
        if(productRepo.existsById(prod.getId())){
            throw new ResponseStatusException(HttpStatus.FOUND, "Product is already exist");
        }
        System.out.println("Product Added Successfully");
        productRepo.save(prod);
    }

    public void deleteProd(String id){
        if(!productRepo.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product with "+id+" not exits");
        }
        System.out.println("Product Remove Successfully");
        productRepo.deleteById(id);
    }
}
