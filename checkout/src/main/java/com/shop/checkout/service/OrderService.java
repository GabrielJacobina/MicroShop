package com.shop.checkout.service;

import com.shop.checkout.client.ProductClient;
import com.shop.checkout.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService implements IOrderService {

    private final ProductClient productClient;

    private Product loadProduct(String uuid) {
        return productClient.getProductById(uuid);
    }

    @Override
    public Product getProductById(String uuid) {
        return this.loadProduct(uuid);
    }
}
