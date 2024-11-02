package com.shop.order.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@RedisHash("Order")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private UUID uuid;
    private String name;
    private String email;
    private String phone;
    private String productId;
    private String status;
    private LocalDateTime time;
}
