package fr.simplon.order.client;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import fr.simplon.order.dto.InventoryDto;
import fr.simplon.order.dto.QuantityDto;

@Component
public class InventoryClient {

    private final RestClient restClient;

    public InventoryClient(RestClient.Builder builder, @Value("${inventory.base-url}") String baseUrl) {
        this.restClient = builder.baseUrl(baseUrl).build();
    }

    public InventoryDto getStock(UUID productId) {
        // Inventory utilise une quantité initiale de 0 par défaut. Le POST ne requiert
        // pas de corps.
        return restClient.get()
                .uri("/inventory/{productId}", productId)
                .retrieve()
                .body(InventoryDto.class);
    }

    public InventoryDto updateStock(UUID productId, Integer quantity) {
        // Inventory utilise une quantité initiale de 0 par défaut. Le POST ne requiert
        // pas de corps.
        QuantityDto quantityDto = new QuantityDto(quantity);
        return restClient.put()
                .uri("/inventory/{productId}", productId)
                .body(quantityDto)
                .retrieve()
                .body(InventoryDto.class);
    }
}
