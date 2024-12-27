package com.filmFinder.FilmFinder.service;

import com.filmFinder.FilmFinder.entity.User;
import com.filmFinder.FilmFinder.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserService {

    private UserRepository userRepository;

    public List<User> readAll(){
        return this.userRepository.findAll();
    }
}

