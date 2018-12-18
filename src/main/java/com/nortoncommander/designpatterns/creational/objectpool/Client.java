package com.nortoncommander.designpatterns.creational.objectpool;

import com.nortoncommander.designpatterns.creational.objectpool.impl.Bitmap;
import com.nortoncommander.designpatterns.creational.objectpool.impl.ObjectPool;
import javafx.geometry.Point2D;

public class Client {

  private static final ObjectPool<Bitmap> bitmapPool = new ObjectPool<>(() -> new Bitmap("Logo.bmp"), 5);

  public static void main(String[] args) {
    Bitmap bitmap1 = bitmapPool.get();
    bitmap1.setLocation(new Point2D(10, 10));

    Bitmap bitmap2 = bitmapPool.get();
    bitmap2.setLocation(new Point2D(-10, -10));

    bitmap1.draw();
    bitmap2.draw();

    // if we don't need the reusable objects no longer, we will release them
    bitmapPool.release(bitmap1);
    bitmapPool.release(bitmap2);
  }
}
