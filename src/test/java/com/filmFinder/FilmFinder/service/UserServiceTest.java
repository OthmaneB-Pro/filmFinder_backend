package com.filmFinder.FilmFinder.service;

import com.filmFinder.FilmFinder.entity.User;
import com.filmFinder.FilmFinder.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    @Test
    void readAll() {

        User userOne = User.builder().id(1).username("Othmane").password("AZERTY").build();
        User userTwo = User.builder().id(2).username("QSDFGH").password("WXCVBN").build();

        this.userRepository.saveAll(List.of(userOne, userTwo));
        //Act

        final List<User> userList = this.userRepository.findAll();
        final User user = this.userRepository.findByUsername("Othmane");

        //Asserts

        assertEquals(2, userList.size());
        Assertions.assertEquals(user.getUsername(), userOne.getUsername());

    }
}