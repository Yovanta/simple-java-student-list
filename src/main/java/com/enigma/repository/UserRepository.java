package com.enigma.repository;

import com.enigma.entity.User;

import java.util.Optional;

public class UserRepository {
  private final User user = new User("admin", "password");

  public Optional<User> findByUserID(String userID) {
    return user.getUserId().equals(userID) ? Optional.of(user) : Optional.empty();
  }
}
