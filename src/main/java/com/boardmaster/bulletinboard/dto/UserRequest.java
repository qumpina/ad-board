package com.boardmaster.bulletinboard.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRequest {
  @NotBlank
  @Email
  @Schema(description = "Почта пользователя", example = "example@example.com")
  private String email;
  @NotBlank
  @Size(min=3, max=50)
  @Schema(description = "Пароль пользователя", example = "123")
  private String password;
  @NotBlank
  @Size(min=3, max=100)
  @Schema(description = "Уникальное имя пользователя ", example = "Ivan Ivanov")
  private String username;

  public UserRequest(){
  }
  public UserRequest( String username,String email, String password) {
    this.email = email;
    this.password = password;
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public String getUsername() {
    return username;
  }

}
