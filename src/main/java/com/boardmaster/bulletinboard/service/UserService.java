package com.boardmaster.bulletinboard.service;

import com.boardmaster.bulletinboard.repositry.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }
}
