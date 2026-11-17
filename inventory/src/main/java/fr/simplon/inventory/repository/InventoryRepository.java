package fr.simplon.inventory.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.simplon.inventory.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, UUID> {

    public Inventory findByProductId(UUID productId);
}
