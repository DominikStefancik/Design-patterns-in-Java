package com.nortoncommander.designpatterns.creational.simplefactory.domain;

/**
 * Enumeration to distinguish the type of the Post "product". It is used to tell the simple factory
 * what object needs to be created.
 */
public enum PostType {
  BLOG,
  NEWS,
  PRODUCT
}
