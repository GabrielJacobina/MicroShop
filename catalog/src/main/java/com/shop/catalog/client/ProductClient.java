package com.shop.catalog.client;

import com.shop.catalog.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "products", url = "${api.product}")
public interface ProductClient {

    @GetMapping("/list")
    List<Product> getProducts();

    @GetMapping("/{uuid}")
    Product getProductById(@PathVariable String uuid);
}
