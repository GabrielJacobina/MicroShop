package com.shop.checkout.controller;


import com.shop.checkout.model.Order;
import com.shop.checkout.model.Product;
import com.shop.checkout.service.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final IOrderService orderService;

    @GetMapping("/{uuid}")
    public String getProdutos(@PathVariable String uuid, Model model) {
        Product product = orderService.getProductById(uuid);
        model.addAttribute("product", product);

        Order order = new Order();
        order.setProductId(product.uuid());
        model.addAttribute("order", order);
        return "checkout";
    }

    @PostMapping("/submit")
    public String submitForm(@ModelAttribute Order order) {
        System.out.println("Nome: " + order.getName());
        System.out.println("email: " + order.getEmail());
        System.out.println("Telefone: " + order.getPhone());
        System.out.println("Product ID: " + order.getProductId());
        return "redirect:/" + order.getProductId();
    }
}
