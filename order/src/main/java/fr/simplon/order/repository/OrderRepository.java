package fr.simplon.order.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.simplon.order.entity.Order;

public interface OrderRepository extends JpaRepository<Order, UUID> {

}
