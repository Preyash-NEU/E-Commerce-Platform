package controller;

import dto.CheckoutRequest;
import service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/checkout")
public class CheckoutController {

    @Autowired
    private CheckoutService checkoutService;

    @PostMapping
    public ResponseEntity<?> checkout(@RequestBody CheckoutRequest checkoutRequest) {
        checkoutService.performCheckout(checkoutRequest);
        return ResponseEntity.ok("Checkout successful");
    }
}
