package org.company.meituan.all.week02.done;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>242. 有效的字母异位词
 *
 * <p>给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * <p>示例 1:
 *
 * <p>输入: s = "anagram", t = "nagaram"
 * <p>输出: true
 *
 * <p>示例 2:
 *
 * <p>输入: s = "rat", t = "car"
 * <p>输出: false
 *
 * <p>说明:
 * <p>你可以假设字符串只包含小写字母。
 *
 * <p>进阶:
 * <p>如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * <p>通过次数237,799
 * <p>提交次数372,109
 * <p>https://leetcode-cn.com/problems/valid-anagram/
 * <p>@author: wangrui
 * <p>@date: 2021/5/14
 */
public class Ch054_242ValidAnagram有效的字母异位词 {

  public static void main(String[] args) {
    System.out.println(isAnagram_self("aacc", "ccac"));
  }

  public static boolean isAnagram_self(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    for (int i = 0; i < t.length(); i++) {
      char c = t.charAt(i);
      if (!map.containsKey(c)) {
        return false;
      }
      if (map.get(c) == 1) {
        map.remove(c);
      } else {
        map.put(c, map.get(c) - 1);
      }
    }
    return true;
  }

  /**
   * <p>复杂度分析
   *
   * <p>  时间复杂度：O(nlog⁡n)O(n \log n)O(nlogn)，其中 nnn 为 sss 的长度。排序的时间复杂度为 O(nlog⁡n)O(n\log n)O(nlogn)，比较两个字符串是否相等时间复杂度为
   * O(n)O(n)O(n)，因此总体时间复杂度为 O(nlog⁡n+n)=O(nlog⁡n)O(n \log n+n)=O(n\log n)O(nlogn+n)=O(nlogn)。
   *
   * <p> 空间复杂度：O(log⁡n)O(\log n)O(logn)。排序需要 O(log⁡n)O(\log n)O(logn) 的空间复杂度。注意，在某些语言（比如 Java &
   * <p> JavaScript）中字符串是不可变的，因此我们需要额外的 O(n)O(n)O(n) 的空间来拷贝字符串。但是我们忽略这一复杂度分析，因为：
   * <p>     这依赖于语言的细节；
   * <p>     这取决于函数的设计方式，例如，可以将函数参数类型更改为 char[]。
   *
   * @param s
   * @param t
   * @return
   */
  public boolean isAnagram_1(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    char[] str1 = s.toCharArray();
    char[] str2 = t.toCharArray();
    Arrays.sort(str1);
    Arrays.sort(str2);
    return Arrays.equals(str1, str2);
  }

  public boolean isAnagram_2(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    int[] table = new int[26];
    for (int i = 0; i < s.length(); i++) {
      table[s.charAt(i) - 'a']++;
    }
    for (int i = 0; i < t.length(); i++) {
      table[t.charAt(i) - 'a']--;
      if (table[t.charAt(i) - 'a'] < 0) {
        return false;
      }
    }
    return true;
  }

  /**
   * <p>复杂度分析
   *
   * <p>   时间复杂度：O(n)O(n)O(n)，其中 nnn 为 sss 的长度。
   *
   * <p>  空间复杂度：O(S)O(S)O(S)，其中 SSS 为字符集大小，此处 S=26S=26S=26。
   *
   * @param s
   * @param t
   * @return
   */
  public boolean isAnagram_3(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    Map<Character, Integer> table = new HashMap<Character, Integer>();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      table.put(ch, table.getOrDefault(ch, 0) + 1);
    }
    for (int i = 0; i < t.length(); i++) {
      char ch = t.charAt(i);
      table.put(ch, table.getOrDefault(ch, 0) - 1);
      if (table.get(ch) < 0) {
        return false;
      }
    }
    return true;
  }


}
