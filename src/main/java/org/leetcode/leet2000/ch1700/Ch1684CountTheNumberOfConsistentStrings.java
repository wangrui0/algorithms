package org.leetcode.leet2000.ch1700;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>1684. 统计一致字符串的数目
 * <p>给你一个由不同字符组成的字符串 allowed 和一个字符串数组 words 。如果一个字符串的每一个字符都在 allowed 中，就称这个字符串是 一致字符串 。
 *
 * <p>请你返回 words 数组中 一致字符串 的数目。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
 * <p>输出：2
 * <p>解释：字符串 "aaab" 和 "baa" 都是一致字符串，因为它们只包含字符 'a' 和 'b' 。
 * <p>示例 2：
 *
 * <p>输入：allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]
 * <p>输出：7
 * <p>解释：所有字符串都是一致的。
 * <p>示例 3：
 *
 * <p>输入：allowed = "cad", words = ["cc","acd","b","ba","bac","bad","ac","d"]
 * <p>输出：4
 * <p>解释：字符串 "cc"，"acd"，"ac" 和 "d" 是一致字符串。
 *
 *
 * <p>提示：
 *
 * <p>1 <= words.length <= 104
 * <p>1 <= allowed.length <= 26
 * <p>1 <= words[i].length <= 10
 * <p>allowed 中的字符 互不相同 。
 * <p>words[i] 和 allowed 只包含小写英文字母。
 * <p>通过次数12,603提交次数15,225
 * <p>https://leetcode-cn.com/problems/count-the-number-of-consistent-strings/
 * <p>@Author: shenpei
 * <p>@Date: 2021/4/25 7:32 下午
 */
public class Ch1684CountTheNumberOfConsistentStrings {

  public static int countConsistentStrings_self(String allowed, String[] words) {
    Set<Character> set = new HashSet<>();
    for (int i = 0; i < allowed.length(); i++) {
      set.add(allowed.charAt(i));
    }
    int ans = 0;
    for (String word : words) {
      int i = 0;
      for (; i < word.length(); i++) {
        if (!set.contains(word.charAt(i))) {
          break;
        }
      }
      if (i == word.length()) {
        ans++;
      }
    }
    return ans;
  }

  public int countConsistentStrings_1(String allowed, String[] words) {
    Set<Character> set = new HashSet<>();
    int num = 0;
    for (int i = 0; i < allowed.length(); i++) {
      set.add(allowed.charAt(i));
    }
    for (int i = 0; i < words.length; i++) {
      for (int j = 0; j < words[i].length(); j++) {
        if (!set.contains(words[i].charAt(j))) {
          break;
        }
        if (j == words[i].length() - 1) {
          num++;
        }
      }
    }
    return num;
  }


  public int countConsistentStrings_2(String allowed, String[] words) {
    int ans = solve(allowed);
    int total = 0;
    for (String word : words) {
      int res = solve(word);
      if ((res & ans) == res) {
        total++;
      }
    }
    return total;
  }

  public int solve(String s) {
    int ans = 0;
    for (int i = 0; i < s.length(); i++) {
      int x = s.charAt(i) - 'a';
      ans |= (1 << x);
    }
    return ans;
  }

  public int countConsistentStrings_3(String allowed, String[] words) {
    int result = 0;
    //使用一个数组记录allowed 包含的字符，数组定位，效率较高
    int[] allow = new int[26];
    char[] chars = allowed.toCharArray();
    for (char aChar : chars) {
      allow[aChar - 'a'] = 1;
    }
    for (String word : words) {
      char[] arr = word.toCharArray();
      int index = 0;
      int length = arr.length;
      for (; index < length; index++) {
        //如果这个字符没有在allowed 中，直接结束
        if (allow[arr[index] - 'a'] == 0) {
          break;
        }
      }
      //如果相等说明这个字符有判断到最后，结果加1
      if (index == length) {
        result++;
      }
    }
    return result;
  }
}
