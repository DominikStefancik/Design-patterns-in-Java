package com.nortoncommander.designpatterns.creational.abstractfactory.api;

/**
 * Represents an abstract factory with methods defined for each object type.
 * The factory creates products which belong to the same set/family of products.
 */
public interface ResourceFactory {

  Instance createInstance(Instance.Capacity capacity);
  Storage createStorage(int capacityInMB);
}
