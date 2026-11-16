package fr.simplon.product.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.simplon.product.entity.Product;

//  extends JpaRepository<Product, UUID>

public interface ProductRepository extends JpaRepository<Product, UUID> {

}
