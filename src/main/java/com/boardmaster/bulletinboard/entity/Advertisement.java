package com.boardmaster.bulletinboard.entity;

import jakarta.persistence.*;

import javax.swing.plaf.nimbus.State;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "advertisements")
public class Advertisement {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "advertisement_id")
  private Long id;
  @Column(name = "name", nullable = false, length = 200)
  private String name;
  @Column(name = "price",nullable = true)
  private int price;
  @Column(name = "description", nullable = true)
  private String description;

  @Enumerated(EnumType.STRING)
  @Column(name = "category")
  private Category category;

  @Enumerated(EnumType.STRING)
  @Column(name = "status")
  private AdStatus status;

  @Column(name = "created_at",nullable = false,updatable = false)
  private LocalDateTime createdAt;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "author_id")
  private User author;

  @PrePersist
  private void onCreate(){
    this.createdAt=LocalDateTime.now();
    if(this.status == null){
      this.status=AdStatus.ACTIVE;
    }
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public AdStatus getStatus() {
    return status;
  }

  public void setStatus(AdStatus status) {
    this.status = status;
  }

  public User getAuthor() {
    return author;
  }

  public void setAuthor(User author) {
    this.author = author;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
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


}
