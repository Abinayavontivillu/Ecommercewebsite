package com.example.product.demoprojectproduct.Service;


import com.example.product.demoprojectproduct.Model.Product;
import com.example.product.demoprojectproduct.Repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);


    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        logger.info("Fetching all products");
        return productRepository.findAll();
    }

    public Product getProductById(String id) {
        logger.info("Fetching product with id:{}", id);
        return productRepository.findById(id).orElse(null);

    }

    public Product addProduct(Product product)
    {
        logger.info("Adding new product:{}",product.getBrand());
        return productRepository.save(product);
    }
    public Product updateProduct(String id ,Product product)
    {
        logger.info("Updating product with id: {}",id);
        product.setId(id);
        return productRepository.save(product);
    }

    public void deleteProduct(String id)
    {
        logger.info("Deleting product with id:{}",id);
        productRepository.deleteById(id);
    }

}




