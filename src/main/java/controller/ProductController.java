package controller;

import entity.Product;
import service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.listAllProducts();
    }

    @PostMapping
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        productService.addProduct(product);
        return ResponseEntity.ok("Product added successfully");
    }

    @PutMapping("/{productId}")
    public ResponseEntity<?> updateProduct(@PathVariable Long productId, @RequestBody Product product) {
        productService.updateProduct(productId, product);
        return ResponseEntity.ok("Product updated successfully");
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.ok("Product deleted successfully");
    }
}
