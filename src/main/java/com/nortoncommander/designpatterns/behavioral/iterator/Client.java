package com.nortoncommander.designpatterns.behavioral.iterator;

import com.nortoncommander.designpatterns.behavioral.iterator.api.Iterator;
import com.nortoncommander.designpatterns.behavioral.iterator.impl.ThemeColor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Client {

  private static final Logger LOGGER = LoggerFactory.getLogger(Client.class);

  public static void main(String[] args) {
    Iterator<ThemeColor> iterator = ThemeColor.getIterator();

    while (iterator.hasNext()) {
      ThemeColor themeColor = iterator.next();

      LOGGER.info(themeColor.name());
    }
  }
}
