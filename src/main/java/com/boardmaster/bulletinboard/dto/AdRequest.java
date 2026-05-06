package com.boardmaster.bulletinboard.dto;

import com.boardmaster.bulletinboard.entity.AdStatus;
import com.boardmaster.bulletinboard.entity.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public class AdRequest {

  @NotBlank
  @Size(min=3,max=200)
  private String name;
  @PositiveOrZero
  private int price;
  private String description;
  private Category category;
  @NotNull
  private AdStatus status;
  @NotBlank
  private Long userId;

  public AdRequest(String name, int price, String description, Category category, AdStatus status, Long userId) {
    this.name = name;
    this.price = price;
    this.description = description;
    this.category = category;
    this.status = status;
    this.userId = userId;
  }

  public AdRequest() {
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

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }
}
