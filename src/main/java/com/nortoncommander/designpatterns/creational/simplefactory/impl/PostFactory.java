package com.nortoncommander.designpatterns.creational.simplefactory.impl;

import com.nortoncommander.designpatterns.creational.simplefactory.api.Post;
import com.nortoncommander.designpatterns.creational.simplefactory.domain.PostType;

/**
 * Represents a simple factory for creation of different objects.
 * Simple factory itself doesn't need any state tracking, so we can define a static method for creating objects.
 */
public class PostFactory {

  /**
   * Represents a method for creation of different objects. It expects argument(s) which serves as a criteria for
   * making decision which object will be created.
   */
  public static Post createPost(PostType type) {
    switch (type) {
      case BLOG:
        return new BlogPost();
      case NEWS:
        return new NewsPost();
      case PRODUCT:
        return new ProductPost();
      default:
        throw new IllegalArgumentException("Post type is unknown");
    }
  }
}
