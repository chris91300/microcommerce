package fr.simplon.inventory.client;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import fr.simplon.inventory.dto.ProductDto;

@Component
public class ProductClient {

    private final RestClient restClient;

    public ProductClient(RestClient.Builder builder, @Value("${product.base-url}") String baseUrl) {
        this.restClient = builder.baseUrl(baseUrl).build();
    }

    public ProductDto getProduct(UUID productId) {
        // Inventory utilise une quantité initiale de 0 par défaut. Le POST ne requiert
        // pas de corps.
        return restClient.get()
                .uri("/products/{productId}", productId)
                .retrieve()
                .body(ProductDto.class);
    }
}
