package com.nortoncommander.designpatterns.creational.abstractfactory.impl;

import com.nortoncommander.designpatterns.creational.abstractfactory.api.Storage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents a concrete product in a concrete set/family of products in the Abstract Factory pattern
 *
 * NOTE: Here this class represents a product in the family "Amazon Web Services"
 */
public class S3Storage implements Storage {
  private static final Logger LOGGER = LoggerFactory.getLogger(S3Storage.class);

  public S3Storage(int capacityInMB) {
    LOGGER.info("Allocated {} MB on S3 storage", capacityInMB);
  }

  @Override
  public String getId() {
    return "S31";
  }

  @Override
  public String toString() {
    return "S3 storage";
  }
}
