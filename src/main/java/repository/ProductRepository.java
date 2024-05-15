package repository;

import entity.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Here you can add custom queries if needed, e.g., find by part of the name
    List<Product> findByNameContaining(String name);
}
