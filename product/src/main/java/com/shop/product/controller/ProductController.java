package com.shop.product.controller;

import com.shop.product.model.Product;
import com.shop.product.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final IProductService productService;

    @GetMapping("/list")
    public ResponseEntity<List<Product>> getProdutos() {
        return ResponseEntity.ok(productService.getProdutos().products());
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Product> getProductById(@PathVariable String uuid) {
        return ResponseEntity.ok(productService.getProductById(uuid));
    }
}
