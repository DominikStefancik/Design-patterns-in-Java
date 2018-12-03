package com.nortoncommander.designpatterns.behavioral.iterator.impl;

import com.nortoncommander.designpatterns.behavioral.iterator.api.Iterator;

/**
 * This enum represents the aggregate/collection from the Iterator pattern
 */
public enum ThemeColor {
  RED,
  ORANGE,
  GREEN,
  BLACK,
  WHITE;

  public static Iterator<ThemeColor> getIterator() {
    // a client has to return always a new instance of the iterator
    return new ThemeColorIterator();
  }

  /**
   * We declare an Iterator implementation as an inner class in the aggregate class, so the Iterator class
   * has access to internal data of the the aggregate class (otherwise we would have to expose this data
   * and we don't want that).
   * The inner class has to be private so no other class has access to it.
   */
  private static class ThemeColorIterator implements Iterator<ThemeColor> {

    // The iterator needs to remember the position (index) it is currently in
    private int position;

    @Override
    public boolean hasNext() {
      return position < ThemeColor.values().length;
    }

    @Override
    public ThemeColor next() {
      // DON'T FORGET to increase the value of the position after the method "next()" is finished
      return ThemeColor.values()[position++];
    }
  }
}
