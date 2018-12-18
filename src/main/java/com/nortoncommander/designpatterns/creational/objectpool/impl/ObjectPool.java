package com.nortoncommander.designpatterns.creational.objectpool.impl;

import com.nortoncommander.designpatterns.creational.objectpool.api.Reusable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Supplier;


/**
 * Represents the object pool. It contains a cache of objects which can be obtained/pooled by a client.
 *
 * NOTE: The cache has to be thread safe.
 */
public class ObjectPool<T extends Reusable> {
  private static final Logger LOGGER = LoggerFactory.getLogger(ObjectPool.class);

  /* Represents in-memory cache of objects. The cache needs to be thread safe! */
  private final BlockingQueue<T> availablePool;

  /**
   * When creating an object pool, you need to decide how the objects in the pool will be created.
   *
   * In this example a supplier of the objects is required
   */
  public ObjectPool(Supplier<T> creator, int count) {
    this.availablePool = new LinkedBlockingQueue<>();

    for (int i=0; i<count; i++) {
      availablePool.offer(creator.get());
    }
  }

  /**
   * Returns an available object from the object pool.
   *
   * NOTE: This method can be parametrised with argument(s) which represent selection criteria of the object
   * which is required. With this approach the object pool can contain objects of different classes and
   * the parametrised get() method will return the desired object.
   */
  public T get() {
    try {
      /* In a real situation you as a developer need to decide what happens when the pool is empty.
         You can create a new object or you can wait until one of the reusable objects is released and available
         for use by another client (e.g. if you have limited number of objects representing database connection).
       */
      return availablePool.take();
    } catch (InterruptedException ex) {
      // the exception is thrown either if the queue is empty or if the blocking operation is interrupted
      LOGGER.error("take() operation was interrupted");
    }

    return null;
  }

  /**
   * This method is called whenever a client doesn't need the reusable object anymore. It releases the object
   * and returns it to the object pool so it can be used by another client.
   */
  public void release(T object) {
    // reset the object's state, so there are no "leftover" values when it is used again
    object.reset();

    try {
      availablePool.put(object);
    } catch (InterruptedException e) {
      LOGGER.error("put() operation was interrupted while releasing an object into the object pool");
    }
  }
}
