package com.enigma.service.impl;

import com.enigma.entity.User;
import com.enigma.repository.UserRepository;
import com.enigma.service.LoginService;

import java.util.Optional;

public class LoginServiceImpl implements LoginService {
  private final UserRepository userRepository;

  public LoginServiceImpl() {
    this.userRepository = new UserRepository();
  }

  @Override
  public boolean login(String userId, String password) {
    Optional<User> user = userRepository.findByUserID(userId);
    return user.isPresent() && user.get().getPassword().equals(password);
  }
}
