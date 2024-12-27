package com.filmFinder.FilmFinder.controller;

import com.filmFinder.FilmFinder.entity.User;
import com.filmFinder.FilmFinder.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
