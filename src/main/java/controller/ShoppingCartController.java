package controller;

import dto.AddToCartRequest;
import service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService cartService;

    @PostMapping
    public ResponseEntity<?> addItemToCart(@RequestBody AddToCartRequest addToCartRequest) {
        cartService.addItemToCart(addToCartRequest);
        return ResponseEntity.ok("Item added to cart");
    }

    @DeleteMapping("/{cartItemId}")
    public ResponseEntity<?> removeItemFromCart(@PathVariable Long cartItemId) {
        cartService.removeItemFromCart(cartItemId);
        return ResponseEntity.ok("Item removed from cart");
    }
}
