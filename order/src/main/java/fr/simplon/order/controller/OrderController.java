package fr.simplon.order.controller;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.simplon.order.dto.QuantityDto;
import fr.simplon.order.entity.Order;
import fr.simplon.order.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/{productId}")
    public ResponseEntity<Object> create(@PathVariable UUID productId, @RequestBody QuantityDto quantityDto) {
        Order order = this.orderService.createOrder(productId, quantityDto.getQuantity());
        if (order == null) {
            return ResponseEntity.badRequest().body("stock insuffisant");
        }

        return ResponseEntity.ok(order);
    }
}
