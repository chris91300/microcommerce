package fr.simplon.order.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import fr.simplon.order.client.InventoryClient;
import fr.simplon.order.dto.InventoryDto;
import fr.simplon.order.entity.Order;
import fr.simplon.order.repository.OrderRepository;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;

    public OrderService(OrderRepository orderRepository, InventoryClient inventoryClient) {
        this.orderRepository = orderRepository;
        this.inventoryClient = inventoryClient;
    }

    public Order createOrder(UUID productID, Integer quantity) {
        InventoryDto inventoryDto = this.inventoryClient.getStock(productID);
        if (quantity <= inventoryDto.getQuantity()) {
            Order order = new Order(
                    null,
                    productID,
                    inventoryDto.getName(),
                    inventoryDto.getCategory(),
                    quantity);
            Order newOrder = this.orderRepository.save(order);
            Integer rest = inventoryDto.getQuantity() - quantity;
            this.inventoryClient.updateStock(productID, rest);
            return newOrder;
        } else {
            return null;
        }

    }
}
