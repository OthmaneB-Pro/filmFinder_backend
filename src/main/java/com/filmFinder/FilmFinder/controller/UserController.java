package com.filmFinder.FilmFinder.controller;

import com.filmFinder.FilmFinder.entity.User;
import com.filmFinder.FilmFinder.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("user")
public class UserController {

    private UserService userService;

    @GetMapping
    public List<User> readAll(){
        return this.userService.readAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public User register(@RequestBody User user){
        return this.userService.register(user);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> login(@RequestBody User loginRequest) {
        User user = userService.login(loginRequest.getUsername(), loginRequest.getPassword());
        if (user != null) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.badRequest().body("Invalid credentials");
    }
}
