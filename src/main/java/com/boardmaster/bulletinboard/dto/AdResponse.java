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

  public AdResponse(){}

  public AdResponse(AdBuilder adBuilder) {
    this.id=adBuilder.id;
    this.name= adBuilder.name;
    this.price= adBuilder.price;
    this.description= adBuilder.description;
    this.category=adBuilder.category;
    this.status=adBuilder.status;
    this.createdAt=adBuilder.createdAt;
    this.authorUsername=adBuilder.authorUsername;
  }

  private AdResponse(Long id, String name, int price, String description, Category category, AdStatus status, LocalDateTime createdAt, String authorUsername) {
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


  public String getName() {
    return name;
  }

  public int getPrice() {
    return price;
  }

  public String getDescription() {
    return description;
  }


  public Category getCategory() {
    return category;
  }

  public AdStatus getStatus() {
    return status;
  }


  public LocalDateTime getCreatedAt() {
    return createdAt;
  }


  public String getAuthorUsername() {
    return authorUsername;
  }

  public static class AdBuilder{
    private Long id;
    private String name;
    private int price;
    private String description;
    private Category category;
    private AdStatus status;
    private LocalDateTime createdAt;
    private String authorUsername;

    public AdBuilder(Long id, String name, AdStatus status, String authorUsername) {
      this.id = id;
      this.name = name;
      this.status = status;
      this.authorUsername = authorUsername;
    }

    public AdBuilder setPrice(int price) {
      this.price = price;
      return this;
    }

    public AdBuilder setDescription(String description) {
      this.description = description;
      return this;
    }

    public AdBuilder setCategory(Category category) {
      this.category = category;
      return this;
    }
    public AdBuilder setCreatedAt(LocalDateTime time){
      this.createdAt= time;
      return this;
    }
    public AdResponse build(){
      return new AdResponse(this);
    }
  }

}
