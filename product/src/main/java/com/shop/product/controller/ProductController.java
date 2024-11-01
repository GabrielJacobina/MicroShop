package com.shop.product.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("product")
public class ProductController {

    @GetMapping
    public ResponseEntity<String> buscarProdutos() {
        return ResponseEntity.ok("Hello World");
    }
}
