package org.leetcode.leet1000.ch750;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * <p>706. 设计哈希映射
 *
 * <p>不使用任何内建的哈希表库设计一个哈希映射（HashMap）。
 *
 * <p>实现 MyHashMap 类：
 *
 * <p>    MyHashMap() 用空映射初始化对象
 * <p>    void put(int key, int value) 向 HashMap 插入一个键值对 (key, value) 。如果 key 已经存在于映射中，则更新其对应的值 value 。
 * <p>    int get(int key) 返回特定的 key 所映射的 value ；如果映射中不包含 key 的映射，返回 -1 。
 * <p>    void remove(key) 如果映射中存在 key 的映射，则移除 key 和它所对应的 value 。
 *
 *
 *
 * <p>示例：
 *
 * <p>输入：
 * <p>["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
 * <p>[[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
 * <p>输出：
 * <p>[null, null, null, 1, -1, null, 1, null, -1]
 *
 * <p>解释：
 * <p>MyHashMap myHashMap = new MyHashMap();
 * <p>myHashMap.put(1, 1); // myHashMap 现在为 [[1,1]]
 * <p>myHashMap.put(2, 2); // myHashMap 现在为 [[1,1], [2,2]]
 * <p>myHashMap.get(1);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,2]]
 * <p>myHashMap.get(3);    // 返回 -1（未找到），myHashMap 现在为 [[1,1], [2,2]]
 * <p>myHashMap.put(2, 1); // myHashMap 现在为 [[1,1], [2,1]]（更新已有的值）
 * <p>myHashMap.get(2);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,1]]
 * <p>myHashMap.remove(2); // 删除键为 2 的数据，myHashMap 现在为 [[1,1]]
 * <p>myHashMap.get(2);    // 返回 -1（未找到），myHashMap 现在为 [[1,1]]
 *
 *
 *
 * <p>提示：
 *
 * <p>    0 <= key, value <= 106
 * <p>    最多调用 104 次 put、get 和 remove 方法
 *
 *
 * <p> https://leetcode-cn.com/problems/design-hashmap/
 * <p>进阶：你能否不使用内置的 HashMap 库解决此问题？
 * <p>通过次数45,432
 * <p>提交次数70,370
 * <p>在真实的面试中遇到过这道题？
 * <p>@author: wangrui
 * <p>@date: 2021/3/23
 */
public class Ch706DesignHashmap_Self {

  private static final int BASE = 769;
  private static LinkedList<Pair>[] lists;

  class Pair {

    private Integer key;
    private Integer value;

    public Pair() {
    }

    public Pair(Integer key, Integer value) {
      this.key = key;
      this.value = value;
    }

    public Integer getKey() {
      return key;
    }

    public void setKey(Integer key) {
      this.key = key;
    }

    public Integer getValue() {
      return value;
    }

    public void setValue(Integer value) {
      this.value = value;
    }
  }

  public Ch706DesignHashmap_Self() {
    lists = new LinkedList[BASE];
    for (int i = 0; i < 769; i++) {
      lists[i] = new LinkedList<>();
    }
  }

  public void put(int key, int value) {
    int hash = hash(key);

    LinkedList<Pair> list = lists[hash];

    Iterator<Pair> iterator = list.iterator();
    while (iterator.hasNext()) {
      Pair next = iterator.next();
      if (next.key == key) {
        next.setValue(value);
        return;
      }
    }
    list.addLast(new Pair(key, value));

  }

  public int get(int key) {
    int hash = hash(key);

    LinkedList<Pair> list = lists[hash];

    Iterator<Pair> iterator = list.iterator();
    while (iterator.hasNext()) {
      Pair next = iterator.next();
      if (next.key == key) {
        return next.value;
      }
    }
    return -1;
  }

  public void remove(int key) {
    int hash = hash(key);

    LinkedList<Pair> list = lists[hash];

    Iterator<Pair> iterator = list.iterator();
    while (iterator.hasNext()) {
      Pair next = iterator.next();
      if (next.key == key) {
        list.remove(next);
        return;
      }
    }
  }

  private static int hash(int key) {
    return key % BASE;
  }

}

