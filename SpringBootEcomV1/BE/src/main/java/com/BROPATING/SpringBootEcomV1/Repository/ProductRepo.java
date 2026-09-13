package com.BROPATING.SpringBootEcomV1.Repository;

import com.BROPATING.SpringBootEcomV1.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, String> {

}
