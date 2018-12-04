package com.nortoncommander.designpatterns.creational.simplefactory.impl;

import com.nortoncommander.designpatterns.creational.simplefactory.api.Post;

/**
 * Represents a concrete "Product" in the Simple Factory pattern
 */
public class ProductPost extends Post {

  private String name;
  private String imageUrl;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }
}
