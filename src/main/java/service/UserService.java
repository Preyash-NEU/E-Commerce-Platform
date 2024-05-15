package service;

import dto.UserLoginRequest;
import dto.UserRegistrationRequest;
import dto.UserProfileUpdateRequest;
import entity.User;
import repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerUser(UserRegistrationRequest registrationRequest) {
        User user = new User();
        user.setUsername(registrationRequest.getUsername());
        user.setEmail(registrationRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
        userRepository.save(user);
    }

    public User loginUser(UserLoginRequest loginRequest) {
        User user = userRepository.findByUsername(loginRequest.getUsername());
        if (user != null && passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            return user;
        }
        throw new RuntimeException("Invalid credentials");
    }

    public void updateUserProfile(Long userId, UserProfileUpdateRequest updateRequest) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        user.setEmail(updateRequest.getEmail());
        user.setPhoneNumber(updateRequest.getPhoneNumber());
        userRepository.save(user);
    }
}
