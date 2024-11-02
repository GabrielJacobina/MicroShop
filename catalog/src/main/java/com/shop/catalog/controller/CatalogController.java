package com.shop.catalog.controller;

import com.shop.catalog.model.Product;
import com.shop.catalog.service.ICatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CatalogController {

    private final ICatalogService catalogService;

    @GetMapping
    public String getProdutos(Model model) {
        List<Product> products = catalogService.getProdutos();
        model.addAttribute("products", products);
        return "catalog";
    }

    @GetMapping("/{uuid}")
    public String getProductById(@PathVariable String uuid, Model model) {
        Product product = catalogService.getProductById(uuid);
        model.addAttribute("product", product);
        return "view";
    }
}
