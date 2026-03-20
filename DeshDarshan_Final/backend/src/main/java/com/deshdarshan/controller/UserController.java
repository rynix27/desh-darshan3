package com.deshdarshan.controller;

import com.deshdarshan.model.User;
import com.deshdarshan.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    // POST register a new user
    // URL: POST http://localhost:8080/api/users/register
    // Body: { "fullName": "Raj Kumar", "email": "raj@email.com", "password": "pass123", "phone": "9876543210" }
    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody User user) {
        try {
            User saved = userService.registerUser(user);
            saved.setPassword(null); // never return password
            return ResponseEntity.status(HttpStatus.CREATED).body(saved);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    // POST login
    // URL: POST http://localhost:8080/api/users/login
    // Body: { "email": "raj@email.com", "password": "pass123" }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        String email    = credentials.get("email");
        String password = credentials.get("password");
        Optional<User> user = userService.loginUser(email, password);
        if (user.isPresent()) {
            User u = user.get();
            u.setPassword(null); // never return password
            return ResponseEntity.ok(Map.of(
                "message", "Login successful",
                "user", u
            ));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
            .body(Map.of("error", "Invalid email or password"));
    }

    // GET all users (admin only)
    // URL: GET http://localhost:8080/api/users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        users.forEach(u -> u.setPassword(null));
        return ResponseEntity.ok(users);
    }

    // GET user by ID
    // URL: GET http://localhost:8080/api/users/1
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
            .map(u -> { u.setPassword(null); return ResponseEntity.ok(u); })
            .orElse(ResponseEntity.notFound().build());
    }

    // DELETE user
    // URL: DELETE http://localhost:8080/api/users/1
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }
}
