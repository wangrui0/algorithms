package org.leetcode.shunxu.ch750;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * <p> 705. 设计哈希集合
 *
 * <p>不使用任何内建的哈希表库设计一个哈希集合（HashSet）。
 *
 * <p>实现 MyHashSet 类：
 *
 * <p>    void add(key) 向哈希集合中插入值 key 。
 * <p>    bool contains(key) 返回哈希集合中是否存在这个值 key 。
 * <p>    void remove(key) 将给定值 key 从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 *
 *
 *
 * <p>示例：
 *
 * <p>输入：
 * <p>["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
 * <p>[[], [1], [2], [1], [3], [2], [2], [2], [2]]
 * <p>输出：
 * <p>[null, null, null, true, false, null, true, null, false]
 *
 * <p>解释：
 * <p>MyHashSet myHashSet = new MyHashSet();
 * <p>myHashSet.add(1);      // set = [1]
 * <p>myHashSet.add(2);      // set = [1, 2]
 * <p>myHashSet.contains(1); // 返回 True
 * <p>myHashSet.contains(3); // 返回 False ，（未找到）
 * <p>myHashSet.add(2);      // set = [1, 2]
 * <p>myHashSet.contains(2); // 返回 True
 * <p>myHashSet.remove(2);   // set = [1]
 * <p>myHashSet.contains(2); // 返回 False ，（已移除）
 *
 *
 *
 * <p>提示：
 *
 * <p>    0 <= key <= 106
 * <p>    最多调用 104 次 add、remove 和 contains 。
 * <p>
 * <p>
 * https://leetcode-cn.com/problems/design-hashset/
 * <p>进阶：你可以不使用内建的哈希集合库解决此问题吗？
 * <p>通过次数53,972
 * <p>提交次数82,840
 * <p>在真实的面试中遇到过这道题？
 * <p>@author: wangrui
 * <p>@date: 2021/3/23
 */
public class Ch705DesignHashset {

  private static final int BASE = 769;
  private LinkedList[] data;

  /**
   * Initialize your data structure here.
   */
  public Ch705DesignHashset() {
    data = new LinkedList[BASE];
    for (int i = 0; i < BASE; ++i) {
      data[i] = new LinkedList<Integer>();
    }
  }

  public void add(int key) {
    int h = hash(key);
    Iterator<Integer> iterator = data[h].iterator();
    while (iterator.hasNext()) {
      Integer element = iterator.next();
      if (element == key) {
        return;
      }
    }
    data[h].offerLast(key);
  }

  public void remove(int key) {
    int h = hash(key);
    Iterator<Integer> iterator = data[h].iterator();
    while (iterator.hasNext()) {
      Integer element = iterator.next();
      if (element == key) {
        data[h].remove(element);
        return;
      }
    }
  }

  /**
   * Returns true if this set contains the specified element
   */
  public boolean contains(int key) {
    int h = hash(key);
    Iterator<Integer> iterator = data[h].iterator();
    while (iterator.hasNext()) {
      Integer element = iterator.next();
      if (element == key) {
        return true;
      }
    }
    return false;
  }

  private static int hash(int key) {
    return key % BASE;
  }
}
