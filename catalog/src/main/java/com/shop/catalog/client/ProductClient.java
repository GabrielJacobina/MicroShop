package com.shop.catalog.client;

import com.shop.catalog.model.Products;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "products", url = "${api.product}")
public interface ProductClient {

    @GetMapping("/list")
    Products getProducts();
}
