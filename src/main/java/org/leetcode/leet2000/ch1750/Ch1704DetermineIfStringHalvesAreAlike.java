package org.leetcode.leet2000.ch1750;

import java.util.HashSet;

/**
 * <p>1704. 判断字符串的两半是否相似
 *
 * <p>给你一个偶数长度的字符串 s 。将其拆分成长度相同的两半，前一半为 a ，后一半为 b 。
 *
 * <p>两个字符串 相似 的前提是它们都含有相同数目的元音（'a'，'e'，'i'，'o'，'u'，'A'，'E'，'I'，'O'，'U'）。注意，s 可能同时含有大写和小写字母。
 *
 * <p>如果 a 和 b 相似，返回 true ；否则，返回 false 。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：s = "book"
 * <p>输出：true
 * <p>解释：a = "bo" 且 b = "ok" 。a 中有 1 个元音，b 也有 1 个元音。所以，a 和 b 相似。
 *
 * <p>示例 2：
 *
 * <p>输入：s = "textbook"
 * <p>输出：false
 * <p>解释：a = "text" 且 b = "book" 。a 中有 1 个元音，b 中有 2 个元音。因此，a 和 b 不相似。
 * <p>注意，元音 o 在 b 中出现两次，记为 2 个。
 *
 * <p>示例 3：
 *
 * <p>输入：s = "MerryChristmas"
 * <p>输出：false
 *
 * <p>示例 4：
 *
 * <p>输入：s = "AbCdEfGh"
 * <p>输出：true
 *
 *
 *
 * <p>提示：
 *
 * <p>    2 <= s.length <= 1000
 * <p>    s.length 是偶数
 * <p>    s 由 大写和小写 字母组成
 *
 * <p>通过次数9,600
 * <p>提交次数12,213
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/determine-if-string-halves-are-alike/
 * <p>@Author: shenpei
 * <p>@Date: 2021/4/25 7:35 下午
 */
public class Ch1704DetermineIfStringHalvesAreAlike {

  public static boolean halvesAreAlike_self(String s) {
    HashSet<Character> set = new HashSet<Character>() {{
      add('a');
      add('e');
      add('i');
      add('o');
      add('u');
      add('A');
      add('E');
      add('I');
      add('O');
      add('U');
    }};

    int length = s.length();
    int leftNum = 0;
    int rightNum = 0;
    for (int i = 0, j = length / 2; i < length / 2; i++, j++) {
      if (set.contains(s.charAt(i))) {
        leftNum++;
      }
      if (set.contains(s.charAt(j))) {
        rightNum++;
      }
    }
    return leftNum == rightNum;
  }

  /**
   * 这个效率更好
   *
   * @param s
   * @return
   */
  public boolean halvesAreAlike_2(String s) {
    int left = 0, right = s.length() - 1, count = 0;
    int[] arr = new int[128];
    arr['a'] = 1;
    arr['e'] = 1;
    arr['i'] = 1;
    arr['o'] = 1;
    arr['u'] = 1;
    arr['A'] = 1;
    arr['E'] = 1;
    arr['I'] = 1;
    arr['O'] = 1;
    arr['U'] = 1;
    while (left < right) {
      count += arr[s.charAt(left++)];
      count -= arr[s.charAt(right--)];
    }

    return count == 0;
  }

  public static boolean halvesAreAlike_3(String s) {
    int[] arr = new int[128];
    arr['a'] = 1;
    arr['e'] = 1;
    arr['i'] = 1;
    arr['o'] = 1;
    arr['u'] = 1;
    arr['A'] = 1;
    arr['E'] = 1;
    arr['I'] = 1;
    arr['O'] = 1;
    arr['U'] = 1;

    int count = 0;
    int mid = s.length() >> 1;
    for (int i = 0; i < mid; i++) {
      count += arr[s.charAt(i)];
      count -= arr[s.charAt(mid + i)];
    }
    return count == 0;
  }

}
