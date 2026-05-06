package com.boardmaster.bulletinboard.service;

import com.boardmaster.bulletinboard.dto.UserRequest;
import com.boardmaster.bulletinboard.dto.UserResponse;
import com.boardmaster.bulletinboard.entity.User;
import com.boardmaster.bulletinboard.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  private User getUserFromRequest(UserRequest userRequest) {
    User user = new User();
    user.setEmail(userRequest.getEmail());
    user.setPassword(userRequest.getPassword());
    user.setUsername(userRequest.getUsername());
    return user;
  }

  private UserResponse getUserResponse(User user) {
    UserResponse userResponse = new UserResponse();
    userResponse.setId(user.getId());
    userResponse.setEmail(user.getEmail());
    userResponse.setUsername(user.getUsername());
    userResponse.setCreatedAt(user.getCreatedAt());
    return userResponse;
  }

  public UserResponse createUser(UserRequest userRequest) {
    User user = getUserFromRequest(userRequest);
    user.setCreatedAt(LocalDateTime.now());
    userRepository.save(user);
    return getUserResponse(user);
  }

  public UserResponse getUserById(Long id) {

    User user = userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found"));
    return getUserResponse(user);


  }

  public List<UserResponse> getAllUsers() {
    return userRepository.findAll().stream().map(this::getUserResponse).toList();
  }
}
