package com.nortoncommander.designpatterns.creational.simplefactory.impl;

import com.nortoncommander.designpatterns.creational.simplefactory.api.Post;

import java.time.LocalDate;

/**
 * Represents a concrete "Product" in the Simple Factory pattern
 */
public class NewsPost extends Post {

  private String headline;
  private LocalDate newsTime;

  public String getHeadline() {
    return headline;
  }

  public void setHeadline(String headline) {
    this.headline = headline;
  }

  public LocalDate getNewsTime() {
    return newsTime;
  }

  public void setNewsTime(LocalDate newsTime) {
    this.newsTime = newsTime;
  }
}
