package com.nortoncommander.designpatterns.behavioral.iterator;

import com.nortoncommander.designpatterns.creational.builder.version2.Client2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Client {

  private static final Logger LOGGER = LoggerFactory.getLogger(Client2.class);

  public static void main(String[] args) {
    Iterator<ThemeColor> iterator = ThemeColor.getIterator();

    while (iterator.hasNext()) {
      ThemeColor themeColor = iterator.next();

      LOGGER.info(themeColor.name());
    }
  }
}
