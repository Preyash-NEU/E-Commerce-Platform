package repository;

import entity.ShoppingCartItem;

import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartItemRepository extends JpaRepository<ShoppingCartItem, Long> {
    // Methods to handle shopping cart items, e.g., find all items in a user's cart
    List findByOrderId(Long orderId);
}
