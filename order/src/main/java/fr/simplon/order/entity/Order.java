package fr.simplon.order.entity;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "micro_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private UUID productId;
    private String name;
    private String category;
    private Integer quantity;

    // public Order(UUID productId, String name, String category, Integer quantity)
    // {
    // this.productId = productId;
    // this.name = name;
    // this.category = category;
    // this.quantity = quantity;
    // }
}
