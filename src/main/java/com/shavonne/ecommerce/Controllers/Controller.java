package com.shavonne.ecommerce.Controllers;

import com.shavonne.ecommerce.Model.Product;
import com.shavonne.ecommerce.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class Controller {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping(path = "/")
    public @ResponseBody
    Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/product/{productId}")
    public Product getProductById(@PathVariable Integer productId) {
        return productRepository.findById(productId).get();
    }

    @PostMapping("/")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product savedProduct = productRepository.save(product);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/products")
                .buildAndExpand(savedProduct.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/products/{productId}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        Product savedProduct = productRepository.save(product);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{productId}")
                .buildAndExpand(savedProduct.getId()).toUri();
        return ResponseEntity.created(location).build();
    }


    @DeleteMapping("/delete/{productId}")
    public void deleteProduct(@PathVariable("productId") Integer id) {
        Product deletedProduct = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Product Id:" + id));
        productRepository.delete(deletedProduct);
    }
}
