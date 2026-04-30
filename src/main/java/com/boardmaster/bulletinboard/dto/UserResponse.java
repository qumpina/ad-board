package com.boardmaster.bulletinboard.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public class UserResponse {

  private Long id;
  private String username;
  private String email;
  private LocalDateTime createdAt;

  public UserResponse() {
  }

  public UserResponse(Long id, String username, String email,    LocalDateTime createdAt) {
    this.createdAt = createdAt;
    this.email = email;
    this.username = username;
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }
}
