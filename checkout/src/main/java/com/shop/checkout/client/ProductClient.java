package com.shop.checkout.client;

import com.shop.checkout.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "products", url = "${api.product}")
public interface ProductClient {

    @GetMapping("/{uuid}")
    Product getProductById(@PathVariable String uuid);
}
