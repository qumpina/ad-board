package com.boardmaster.bulletinboard.dto;

import com.boardmaster.bulletinboard.entity.AdStatus;
import com.boardmaster.bulletinboard.entity.Category;

import java.time.LocalDateTime;

public class AdResponse {

  private Long id;
  private String name;
  private int price;
  private String description;
  private Category category;
  private AdStatus status;
  private LocalDateTime createdAt;
  private String authorUsername;

  // TODO: Builder
  public AdResponse() {
  }

  public AdResponse(Long id, String name, int price, String description, Category category, AdStatus status, LocalDateTime createdAt, String authorUsername) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.description = description;
    this.category = category;
    this.status = status;
    this.createdAt = createdAt;
    this.authorUsername = authorUsername;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public AdStatus getStatus() {
    return status;
  }

  public void setStatus(AdStatus status) {
    this.status = status;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public String getAuthorUsername() {
    return authorUsername;
  }

  public void setAuthorUsername(String authorUsername) {
    this.authorUsername = authorUsername;
  }
}
