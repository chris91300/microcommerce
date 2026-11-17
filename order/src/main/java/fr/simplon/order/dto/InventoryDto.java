package fr.simplon.order.dto;

import java.util.UUID;

public class InventoryDto {

    private final UUID productId;
    private final String name;
    private final String category;
    private final Integer quantity;

    public InventoryDto(UUID productId, Integer quantity, String name, String category) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
    }

    public String getName() {
        return this.name;
    }

    public String getCategory() {
        return this.category;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public UUID getProductId() {
        return this.productId;
    }
}
