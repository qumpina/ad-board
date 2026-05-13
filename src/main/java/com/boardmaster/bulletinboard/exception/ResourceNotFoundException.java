package com.boardmaster.bulletinboard.exception;

public class ResourceNotFoundException extends RuntimeException {
  private String resourceName;
  private Long id;

  public String getResourceName() {
    return resourceName;
  }

  public Long getId() {
    return id;
  }

  public ResourceNotFoundException(String resourceName, Long id) {
    this.resourceName = resourceName;
    this.id = id;
    super(resourceName + " Not found: " + id);
  }

}
