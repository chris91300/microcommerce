package fr.simplon.inventory.controller;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.simplon.inventory.dto.InventoryDto;
import fr.simplon.inventory.entity.Inventory;
import fr.simplon.inventory.service.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("/test")
    public String test() {
        return "ok";
    }

    @PostMapping("/{productId}")
    public ResponseEntity<Inventory> initializeStock(@PathVariable UUID productId) {
        Inventory inventory = this.inventoryService.initializeStock(productId);
        if (inventory == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(inventory);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<InventoryDto> getStock(@PathVariable UUID productId) {
        InventoryDto inventoryDto = this.inventoryService.getStock(productId);
        if (inventoryDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(inventoryDto);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Inventory> updateStock(@RequestBody Inventory inventory, @PathVariable UUID productId) {
        Inventory updatedInventory = this.inventoryService.updateStock(productId, inventory.getQuantity());
        if (updatedInventory == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedInventory);
    }

}
