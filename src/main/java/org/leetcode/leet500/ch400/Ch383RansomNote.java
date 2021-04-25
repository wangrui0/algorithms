package org.leetcode.leet500.ch400;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>383. 赎金信
 *
 * <p> 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 *
 * <p> (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
 *
 *
 *
 * <p> 注意：
 *
 * <p>你可以假设两个字符串均只含有小写字母。
 *
 * <p>canConstruct("a", "b") -> false
 * <p>canConstruct("aa", "ab") -> false
 * <p>canConstruct("aa", "aab") -> true
 *
 * <p>通过次数39,215
 * <p> 提交次数69,616
 * <p>https://leetcode-cn.com/problems/ransom-note/
 *
 * @author: wangrui
 * @date: 2021/3/3
 */
public class Ch383RansomNote {

  /**
   * self
   *
   * @param ransomNote
   * @param magazine
   * @return
   */
  public boolean canConstruct(String ransomNote, String magazine) {
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < magazine.length(); i++) {
      char c = magazine.charAt(i);
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    for (int i = 0; i < ransomNote.length(); i++) {
      char c = ransomNote.charAt(i);
      Integer num = map.getOrDefault(c, 0);
      if (num == 0) {
        return false;
      } else {
        map.put(c, num - 1);
      }
    }
    return true;
  }

  public boolean canConstruct2(String ransom, String magazine) {
    if (magazine.length() < ransom.length()) {
      return false;
    }
    int caps[] = new int[26];
    for (char c : ransom.toCharArray()) {
      int index = magazine.indexOf(c, caps[c - 'a']);
      if (index == -1) {
        return false;
      }
      caps[c - 97] = index + 1;
    }
    return true;
  }

}
