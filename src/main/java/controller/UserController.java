package controller;

import dto.UserLoginRequest;
import dto.UserRegistrationRequest;
import dto.UserProfileUpdateRequest;
import service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegistrationRequest registrationRequest) {
        userService.registerUser(registrationRequest);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserLoginRequest loginRequest) {
        return ResponseEntity.ok(userService.loginUser(loginRequest));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<?> updateUserProfile(@PathVariable Long userId, @RequestBody UserProfileUpdateRequest updateRequest) {
        userService.updateUserProfile(userId, updateRequest);
        return ResponseEntity.ok("User profile updated successfully");
    }
}

