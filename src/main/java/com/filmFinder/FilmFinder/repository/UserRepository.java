package com.filmFinder.FilmFinder.repository;

import com.filmFinder.FilmFinder.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
