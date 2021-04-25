package org.leetcode.leet500.ch300;

import java.util.HashMap;
import java.util.Map;

/**
 * <p> 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 *
 * <p> 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * <p> 示例1:
 *
 * <p> 输入: pattern = "abba", str = "dog cat cat dog"
 * <p> 输出: true
 *
 * <p> 示例 2:
 *
 * <p> 输入:pattern = "abba", str = "dog cat cat fish"
 * <p> 输出: false
 *
 * <p> 示例 3:
 *
 * <p> 输入: pattern = "aaaa", str = "dog cat cat dog"
 * <p> 输出: false
 *
 * <p> 示例 4:
 *
 * <p> 输入: pattern = "abba", str = "dog dog dog dog"
 * <p> 输出: false
 *
 * <p> 说明:
 * <p> 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
 * <p> 通过次数67,423
 * <p> 提交次数147,093
 *
 * <p> 来源：力扣（LeetCode）
 * <p> 链接：https://leetcode-cn.com/problems/word-pattern
 * <p> 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: wangrui
 * @date: 2021/2/28
 */
public class Ch0290WordPattern {

  /**
   * 思路及解法
   *
   *     时间复杂度：O(n+m)，其中 n 为 pattern 的长度，m 为 str 的长度。插入和查询哈希表的均摊时间复杂度均为 O(n+m)。每一个字符至多只被遍历一次。
   *
   *     空间复杂度：O(n+m)，其中 nnn 为 pattern 的长度，m 为 str 的长度。最坏情况下，我们需要存储 pattern 中的每一个字符和 str 中的每一个字符串。
   *
   * 作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/word-pattern/solution/dan-ci-gui-lu-by-leetcode-solution-6vqv/
   * 来源：力扣（LeetCode）
   * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   * @param pattern
   * @param s
   * @return
   */
  public boolean wordPattern(String pattern, String s) {
    Map<String, Character> str2ch = new HashMap<String, Character>();
    Map<Character, String> ch2str = new HashMap<Character, String>();
    int m = s.length();
    int i = 0;
    for (int p = 0; p < pattern.length(); ++p) {
      char ch = pattern.charAt(p);//要匹配的
      if (i >= m) {//不够要匹配的，直接返回false
        return false;
      }
      int j = i;
      while (j < m && s.charAt(j) != ' ') {//单词的末尾元素
        j++;
      }
      String tmp = s.substring(i, j);
      if (str2ch.containsKey(tmp) && str2ch.get(tmp) != ch) {
        return false;
      }
      if (ch2str.containsKey(ch) && !tmp.equals(ch2str.get(ch))) {
        return false;
      }
      str2ch.put(tmp, ch);
      ch2str.put(ch, tmp);
      i = j + 1;
    }
    return i >= m;
  }

  public static boolean wordPattern2(String pattern, String s) {
    Map<String, Character> strToChar = new HashMap<>();
    Map<Character, String> charToStr = new HashMap<>();

    int j = 0;
    int length = s.length();
    for (int i = 0; i < pattern.length(); i++) {
      char c = pattern.charAt(i);
      if (j > length) {
        return false;
      }
      int k = j;
      while (k < length && s.charAt(k) != ' ') {
        k++;
      }
      String sub = s.substring(j, k);
      if (strToChar.containsKey(sub) && strToChar.get(sub) != c) {
        return false;
      }

      if (charToStr.containsKey(c) && !charToStr.get(c).equals(sub)) {
        return false;
      }
      strToChar.put(sub,c);
      charToStr.put(c,sub);
      j=k+1;
    }
    return j >= length;
  }
}
