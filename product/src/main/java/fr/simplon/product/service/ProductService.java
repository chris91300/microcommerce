package fr.simplon.product.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import fr.simplon.product.client.InventoryClient;
import fr.simplon.product.entity.Product;
import fr.simplon.product.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final InventoryClient inventoryClient;

    public ProductService(ProductRepository productRepository, InventoryClient inventoryClient) {
        this.productRepository = productRepository;
        this.inventoryClient = inventoryClient;
    }

    public List<Product> getAllProduct() {
        return this.productRepository.findAll();
    }

    public Product createProduct(Product product) {
        Product newProduct = this.productRepository.save(product);
        this.inventoryClient.initializeStock(newProduct.getId());
        return newProduct;
    }

    public Product getProduct(UUID productId) {
        return this.productRepository.findById(productId).orElse(null);
    }
}
