package com.shop.product.controller;

import com.shop.product.model.Products;
import com.shop.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public ResponseEntity<Products> buscarProdutos() {
        return ResponseEntity.ok(productService.getProdutos());
    }
}
