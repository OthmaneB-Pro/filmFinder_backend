package com.filmFinder.FilmFinder.repository;

import com.filmFinder.FilmFinder.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void shouldReturnAllUsers(){
        //Arrange

        User userOne = User.builder().id(1).username("Othmane").password("AZERTY").build();
        User userTwo = User.builder().id(2).username("QSDFGH").password("WXCVBN").build();

        this.userRepository.saveAll(List.of(userOne, userTwo));
        //Act

        final List<User> userList = this.userRepository.findAll();

        //Asserts

        assertEquals(2, userList.size());

    }
}