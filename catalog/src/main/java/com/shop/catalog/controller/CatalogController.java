package com.shop.catalog.controller;

import com.shop.catalog.model.Products;
import com.shop.catalog.service.ICatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CatalogController {

    private final ICatalogService catalogService;

    @GetMapping("/list")
    public ResponseEntity<Products> getProdutos() {
        return ResponseEntity.ok(catalogService.getProdutos());
    }
}
