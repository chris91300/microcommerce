package fr.simplon.order.dto;

public class QuantityDto {

    private final Integer quantity;

    public QuantityDto(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return this.quantity;
    }
}
