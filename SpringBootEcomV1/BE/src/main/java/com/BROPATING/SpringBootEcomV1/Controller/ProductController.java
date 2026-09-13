package com.BROPATING.SpringBootEcomV1.Controller;

import com.BROPATING.SpringBootEcomV1.Model.Product;
import com.BROPATING.SpringBootEcomV1.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/prod")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:5173"})
@RequiredArgsConstructor
public class ProductController {
    private final ProductService prodService;

    @GetMapping()
    public List<Product> getProd(){
        return prodService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProdById(@PathVariable String id){
        return prodService.getProdById(id);
    }

    @PostMapping("/addProd")
    public void addProd(@RequestBody Product prod){
        prodService.addProd(prod);
    }

    @DeleteMapping("/{id}")
    public void deleteProd(@PathVariable String id){
        prodService.deleteProd(id);
    }

}
