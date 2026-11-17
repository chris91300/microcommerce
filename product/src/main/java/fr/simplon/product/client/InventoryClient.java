package fr.simplon.product.client;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class InventoryClient {

    private final RestClient restClient;

    public InventoryClient(RestClient.Builder builder, @Value("${inventory.base-url}") String baseUrl) {
        this.restClient = builder.baseUrl(baseUrl).build();
        System.out.println("on affiche inventory.base-url");
        System.out.println(baseUrl);
    }

    public void initializeStock(UUID productId) {
        // Inventory utilise une quantité initiale de 0 par défaut. Le POST ne requiert
        // pas de corps.

        restClient.post()
                .uri("/inventory/{productId}", productId)
                .retrieve()
                .toBodilessEntity();
    }
}
