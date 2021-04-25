package org.leetcode.leet500.ch300;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * <p> 题目  回文排列
 * <p> 描述
 * <p>给定一个字符串，判断该字符串中是否可以通过重新排列组合，形成一个回文字符串。
 *
 * <p> 样例
 *
 *
 * <p> 给定s = "code", 返回 False.
 * <p> 给定s = "aab", 返回 True.
 * <p> 给定s = "carerac", 返回 True.
 * <p>
 * <p> 思路 依次遍历,将前后对比,如果前或者后有一相等,或者前和后相等,则说明存在回文排列
 *
 * @author: wangrui
 * @date: 2021/2/18
 */
public class Ch0266CanPermutePalindrome {

  public static void main(String[] args) {
    Ch0266CanPermutePalindrome canPermutePalindrome = new Ch0266CanPermutePalindrome();
    System.out.println(canPermutePalindrome.canPermutePalindrome2("code"));

  }

  public boolean canPermutePalindrome2(String s) {
    char[] chars = s.toCharArray();
    Map<Character, Integer> map = new HashMap<>();
    for (Character character : chars) {
      Integer num = map.getOrDefault(character, 0);
      map.put(character, num + 1);
    }
    Set<Entry<Character, Integer>> entries = map.entrySet();
    int oddNum = 0;
    for (Entry<Character, Integer> entry : entries) {
      Integer value = entry.getValue();
      if (value % 2 != 0) {
        oddNum++;
      }
    }
    return oddNum < 2;
  }

  public boolean canPermutePalindrome(String s) {
    char[] chars = s.toCharArray();
    Map<Character, Integer> map = new HashMap<>();
    for (char c : chars) {
      if (map.containsKey(c)) {
        map.put(c, map.get(c) + 1);
      } else {
        map.put(c, 1);
      }
    }
    int oddCount = 0;   // 重复次数为奇数的字符的个数
    Set<Character> keySet = map.keySet();
    for (Character c : keySet) {
      if (map.get(c) % 2 != 0) {
        oddCount++;
      }
    }
    return oddCount < 2;
  }
}
