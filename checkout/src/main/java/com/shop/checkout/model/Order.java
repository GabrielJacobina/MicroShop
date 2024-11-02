package com.shop.checkout.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String email;
    private String phone;
    private String productId;
}
