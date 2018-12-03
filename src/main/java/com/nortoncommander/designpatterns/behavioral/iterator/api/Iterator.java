package com.nortoncommander.designpatterns.behavioral.iterator.api;

/**
 * Iterator interface allowing a client to iterate over values of an aggregate/collection
 */
public interface Iterator<T> {

  boolean hasNext();
  T next();
}
