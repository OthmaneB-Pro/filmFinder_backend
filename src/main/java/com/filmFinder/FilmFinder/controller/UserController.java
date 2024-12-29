package com.filmFinder.FilmFinder.controller;

import com.filmFinder.FilmFinder.entity.User;
import com.filmFinder.FilmFinder.security.JwtUtil;
import com.filmFinder.FilmFinder.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("user")
public class UserController {

    private UserService userService;
    private JwtUtil jwtUtil;

    @GetMapping
    public List<User> readAll(){
        List<User> users = this.userService.readAll();
        if (users.isEmpty()) {
            throw new EntityNotFoundException("No users found");
        }
        return users;

    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public User register(@RequestBody User user){
        if (userService.existsByUsername(user.getUsername())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Username already exists");
        }
        return this.userService.register(user);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> login(@RequestBody User loginRequest) {
        User user = userService.login(loginRequest.getUsername(), loginRequest.getPassword());
        if (user != null) {

            String token = jwtUtil.generateToken(userService.loadUserByUsername(user.getUsername()));


            Map<String, Object> response = new HashMap<>();
            response.put("user", user);
            response.put("token", token);

            return ResponseEntity.ok(response);
        }
        throw new IllegalArgumentException("Invalid Credential");
    }
}
