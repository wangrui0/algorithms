package org.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * <p> 中心对称数
 * <p>A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 *
 * <p> Write a function to determine if a number is strobogrammatic. The number is represented as a string.
 *
 * <p> Example 1:
 *
 * <p> Input:  "69"
 * <p> Output: true
 * <p> Example 2:
 *
 * <p> Input:  "88"
 * <p> Output: true
 * <p> Example 3:
 *
 * <p> Input:  "962"
 * <p> Output: false
 * <p> 题解：
 *
 * <p> 把几种对应关系加到HashMap中，两个指针向中间夹逼.
 * <p>
 * Time Complexity: O(n). Space: O(1).
 *
 * @author: wangrui
 * @date: 2021/1/31
 */
public class Ch0246StrobogrammaticNumber {

  /**
   * <p>题解：
   *
   * <p>把几种对应关系加到HashMap中，两个指针向中间夹逼.
   *
   * <p>Time Complexity: O(n). Space: O(1).
   *
   * @param num
   * @return
   */
  public boolean isStrobogrammatic(String num) {
    if (num == null || num.length() == 0) {
      return true;

    }

    HashMap<Character, Character> hm = new HashMap<>();
    String cans = "0011886996";
    for (int i = 0; i < cans.length(); i += 2) {
      hm.put(cans.charAt(i), cans.charAt(i + 1));

    }
    int l = 0;
    int r = num.length() - 1;
    while (l <= r) {
      char left = num.charAt(l);
      char right = num.charAt(r);
      if (!hm.containsKey(left) || !hm.containsKey(right) || hm.get(left) != right || hm.get(right) != left) {
        return false;
      }
      l++;
      r--;
    }
    return true;

  }
}
