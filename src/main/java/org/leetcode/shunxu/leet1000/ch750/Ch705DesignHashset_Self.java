package org.leetcode.shunxu.leet1000.ch750;


import java.util.Iterator;
import java.util.LinkedList;

public class Ch705DesignHashset_Self {

  private static final int BASE = 769;
  private static LinkedList<Integer>[] lists;

  /**
   * Initialize your data structure here.
   */
  public Ch705DesignHashset_Self() {
    lists = new LinkedList[BASE];
    for (int i = 0; i < 769; i++) {
      lists[i] = new LinkedList<>();
    }
  }

  public void add(int key) {
    int mod = key % BASE;
    LinkedList<Integer> list = lists[mod];
    Iterator<Integer> iterator = list.iterator();
    while (iterator.hasNext()) {
      Integer num = iterator.next();
      if (num == key) {
        return;
      }
    }
    list.addLast(key);
  }

  public void remove(int key) {
    int mod = key % BASE;
    LinkedList<Integer> list = lists[mod];
    Iterator<Integer> iterator = list.iterator();
    while (iterator.hasNext()) {
      Integer num = iterator.next();
      if (num == key) {
        list.remove(num);
        return;
      }
    }
  }

  /**
   * Returns true if this set contains the specified element
   */
  public boolean contains(int key) {
    int mod = key % BASE;
    LinkedList<Integer> list = lists[mod];
    Iterator<Integer> iterator = list.iterator();
    int index = 0;
    while (iterator.hasNext()) {
      Integer num = iterator.next();
      if (num == key) {
        return true;
      }
    }
    return false;
  }
}
