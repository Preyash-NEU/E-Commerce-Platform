package service;

import dto.AddToCartRequest;
import entity.Product;
import entity.ShoppingCartItem;
import repository.ProductRepository;
import repository.ShoppingCartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartService {
    @Autowired
    private ShoppingCartItemRepository cartItemRepository;

    @Autowired
    private ProductRepository productRepository;

    public void addItemToCart(AddToCartRequest addToCartRequest) {
        Product product = productRepository.findById(addToCartRequest.getProductId()).orElseThrow(() -> new RuntimeException("Product not found"));
        ShoppingCartItem item = new ShoppingCartItem();
        item.setProduct(product);
        item.setQuantity(addToCartRequest.getQuantity());
        cartItemRepository.save(item);
    }

    public void removeItemFromCart(Long cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }
}
