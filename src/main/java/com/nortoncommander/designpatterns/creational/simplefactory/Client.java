package com.nortoncommander.designpatterns.creational.simplefactory;

import com.nortoncommander.designpatterns.creational.simplefactory.api.Post;
import com.nortoncommander.designpatterns.creational.simplefactory.domain.PostType;
import com.nortoncommander.designpatterns.creational.simplefactory.impl.PostFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Client {
  private static final Logger LOGGER = LoggerFactory.getLogger(Client.class);

  public static void main(String[] args) {
    Post post1 = PostFactory.createPost(PostType.BLOG);
    LOGGER.info("Object class for the post type {}: {}", PostType.BLOG, post1.getClass());

    Post post2 = PostFactory.createPost(PostType.NEWS);
    LOGGER.info("Object class for the post type {}: {}", PostType.NEWS, post2.getClass());

    Post post3 = PostFactory.createPost(PostType.PRODUCT);
    LOGGER.info("Object class for the post type {}: {}", PostType.PRODUCT, post3.getClass());
  }
}
