package com.shop.catalog.controller;

import com.shop.catalog.model.Products;
import com.shop.catalog.service.ICatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class CatalogController {

    private final ICatalogService catalogService;

    @GetMapping
    public String getProdutos(Model model) {
        Products products = catalogService.getProdutos();
        model.addAttribute("products", products);
        return "catalog";
    }
}
