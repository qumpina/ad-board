package com.boardmaster.bulletinboard.controller;


import com.boardmaster.bulletinboard.dto.UserRequest;
import com.boardmaster.bulletinboard.dto.UserResponse;
import com.boardmaster.bulletinboard.entity.User;
import com.boardmaster.bulletinboard.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@Tag(name="Users", description = "Управление пользователями")
public class UserController {

  private final UserService userService;
  public UserController (UserService userService){
    this.userService=userService;
  }

  @PostMapping
  @Operation(summary = "Создать пользователя", description = "Регистрация нового пользователя в системе")
  @ApiResponse(responseCode = "201", description = "Пользователь создан")
  @ApiResponse(responseCode = "400", description = "Ошибка валидации")
  public ResponseEntity<UserResponse> createUser(@RequestBody @Valid UserRequest userRequest){
    UserResponse userResponse= userService.createUser(userRequest);
    return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
  }

  @GetMapping("/{id}")
  @Operation(summary = "Поиск по ID", description = "Поиск пользователя по указанному ID")
  @ApiResponse(responseCode = "200", description = "Пользователь найден")
  @ApiResponse(responseCode = "404", description = "Пользователь не найден")
  public ResponseEntity<UserResponse> getUserById(@Parameter(description = "ID пользователя") @PathVariable Long id){
    UserResponse userResponse= userService.getUserById(id);
    return ResponseEntity.status(HttpStatus.OK).body(userResponse);
  }

  @GetMapping
  @Operation(summary = "Все пользователи", description = "Поиск всех пользователей")
  @ApiResponse(responseCode = "200", description = "Пользователи найдены")
  public ResponseEntity<List<UserResponse>> getAllUsers(){
    List<UserResponse> userResponseList=userService.getAllUsers();
    return ResponseEntity.status(HttpStatus.OK).body(userResponseList);
  }
}
