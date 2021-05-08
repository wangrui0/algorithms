package org.company.meituan.Collect;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: wangrui
 * @date: 2021/5/8
 */
public class Ch018_146LruCacheLRu extends LinkedHashMap<Integer, Integer> {

  private int capacity;

  public Ch018_146LruCacheLRu(int capacity) {
    super(capacity, 0.75F, true);
    this.capacity = capacity;
  }

  public int get(int key) {
    return super.getOrDefault(key, -1);
  }

  public void put(int key, int value) {
    super.put(key, value);
  }

  @Override
  protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
    return size() > capacity;
  }
}
