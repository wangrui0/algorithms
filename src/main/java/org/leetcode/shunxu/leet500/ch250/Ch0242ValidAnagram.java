package org.leetcode.shunxu.leet500.ch250;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>242. 有效的字母异位词
 *
 * <p>给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>分析：
 * <p>字母异位词就是各字母数量相同但排列顺序不同的词。用map<char,int>记录各字母数量，并判断两个map是否相同
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
 * <p>https://leetcode-cn.com/problems/valid-anagram/
 *
 * @author: wangrui
 * @date: 2021/1/31
 */
public class Ch0242ValidAnagram {

  /**
   * <p> 时间复杂度：O(nlogn)，其中 n 为 s 的长度。排序的时间复杂度为 O(nlogn)，比较两个字符串是否相等时间复杂度为 O(n)，因此总体时间复杂度为 O(nlogn)。
   *
   * <p> 空间复杂度：O(logn)。排序需要 O(logn) 的空间复杂度。注意，在某些语言（比如 Java & JavaScript）中字符串是不可变的，因此我们需要额外的 O(n)
   * 的空间来拷贝字符串。但是我们忽略这一复杂度分析，因为：
   *
   * <p>     这依赖于语言的细节；
   * <p>     这取决于函数的设计方式，例如，可以将函数参数类型更改为 char[]。
   *
   * <p> 作者：LeetCode-Solution
   * <p> 链接：https://leetcode-cn.com/problems/valid-anagram/solution/you-xiao-de-zi-mu-yi-wei-ci-by-leetcode-solution/
   * <p> 来源：力扣（LeetCode）
   * <p> 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param s
   * @param t
   * @return
   */
  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    char[] str1 = s.toCharArray();
    char[] str2 = t.toCharArray();
    Arrays.sort(str1);
    Arrays.sort(str2);
    return Arrays.equals(str1, str2);
  }

  /**
   * <p> 复杂度分析
   *
   * <p>     时间复杂度：O(n)，其中 n 为 s 的长度。
   *
   * <p>     空间复杂度：O(S)，其中 S 为字符集大小，此处 S=26。
   *
   * <p> 作者：LeetCode-Solution
   * <p> 链接：https://leetcode-cn.com/problems/valid-anagram/solution/you-xiao-de-zi-mu-yi-wei-ci-by-leetcode-solution/
   * <p> 来源：力扣（LeetCode）
   * <p> 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param s
   * @param t
   * @return
   */
  public boolean isAnagram2(String s, String t) {
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
