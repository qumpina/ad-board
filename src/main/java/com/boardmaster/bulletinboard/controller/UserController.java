package com.boardmaster.bulletinboard.controller;


import com.boardmaster.bulletinboard.dto.UserRequest;
import com.boardmaster.bulletinboard.dto.UserResponse;
import com.boardmaster.bulletinboard.entity.User;
import com.boardmaster.bulletinboard.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

  private final UserService userService;
  public UserController (UserService userService){
    this.userService=userService;
  }

  @PostMapping
  public ResponseEntity<UserResponse> createUser(@RequestBody @Valid UserRequest userRequest){
    UserResponse userResponse= userService.createUser(userRequest);
    return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserResponse> getUserById(@PathVariable Long id){
    UserResponse userResponse= userService.getUserById(id);
    return ResponseEntity.status(HttpStatus.OK).body(userResponse);
  }

  @GetMapping("/all")
  public ResponseEntity<List<UserResponse>> getAllUsers(){
    List<UserResponse> userResponseList=userService.getAllUsers();
    return ResponseEntity.status(HttpStatus.OK).body(userResponseList);
  }
}
