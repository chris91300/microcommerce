package fr.simplon.inventory.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import fr.simplon.inventory.client.ProductClient;
import fr.simplon.inventory.dto.InventoryDto;
import fr.simplon.inventory.dto.ProductDto;
import fr.simplon.inventory.entity.Inventory;
import fr.simplon.inventory.repository.InventoryRepository;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;
    private final ProductClient productClient;

    public InventoryService(InventoryRepository inventoryRepository, ProductClient productClient) {
        this.inventoryRepository = inventoryRepository;
        this.productClient = productClient;
    }

    public InventoryDto getStock(UUID productId) {
        Inventory inventory = this.inventoryRepository.findByProductId(productId);

        if (inventory == null) {
            return null;
        }

        ProductDto productDto = this.productClient.getProduct(productId);
        InventoryDto inventoryDto = new InventoryDto(
                inventory.getProductId(),
                inventory.getQuantity(),
                productDto.getName(),
                productDto.getCategory());

        return inventoryDto;

    }

    public Inventory initializeStock(UUID productId) {
        Inventory newInventory = new Inventory(null, productId, 0);
        return this.inventoryRepository.save(newInventory);
    }

    public Inventory updateStock(UUID productId, Integer quantity) {
        Inventory inventory = this.inventoryRepository.findByProductId(productId);
        if (inventory == null) {
            return inventory;
        } else {
            inventory.setQuantity(quantity);
            Inventory updatedInventory = this.inventoryRepository.save(inventory);
            return updatedInventory;
        }
    }
}
