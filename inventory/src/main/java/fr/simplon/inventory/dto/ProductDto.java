package fr.simplon.inventory.dto;

// import org.springframework.stereotype.Component;

// @Component
public class ProductDto {

    private final String name;
    private final String category;

    public ProductDto(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return this.name;
    }

    public String getCategory() {
        return this.category;
    }
}