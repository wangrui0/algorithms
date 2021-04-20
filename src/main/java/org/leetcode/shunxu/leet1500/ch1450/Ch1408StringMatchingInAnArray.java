package org.leetcode.shunxu.leet1500.ch1450;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>1408. 数组中的字符串匹配
 *
 * <p>给你一个字符串数组 words ，数组中的每个字符串都可以看作是一个单词。请你按 任意 顺序返回 words 中是其他单词的子字符串的所有单词。
 *
 * <p>如果你可以删除 words[j] 最左侧和/或最右侧的若干字符得到 word[i] ，那么字符串 words[i] 就是 words[j] 的一个子字符串。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：words = ["mass","as","hero","superhero"]
 * <p>输出：["as","hero"]
 * <p>解释："as" 是 "mass" 的子字符串，"hero" 是 "superhero" 的子字符串。
 * <p>["hero","as"] 也是有效的答案。
 *
 * <p>示例 2：
 *
 * <p>输入：words = ["leetcode","et","code"]
 * <p>输出：["et","code"]
 * <p>解释："et" 和 "code" 都是 "leetcode" 的子字符串。
 *
 * <p>示例 3：
 *
 * <p>输入：words = ["blue","green","bu"]
 * <p>输出：[]
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= words.length <= 100
 * <p>    1 <= words[i].length <= 30
 * <p>    words[i] 仅包含小写英文字母。
 * <p>    题目数据 保证 每个 words[i] 都是独一无二的。
 *
 * <p>通过次数11,538
 * <p>提交次数18,886
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/string-matching-in-an-array/
 * <p>@author: wangrui
 * <p>@date: 2021/4/18
 */
public class Ch1408StringMatchingInAnArray {

  public List<String> stringMatching(String[] words) {
    List<String> list = new ArrayList<>();
    for (int i = 0; i < words.length; i++) {
      for (int j = 0; j < words.length; j++) {
        if (i == j) {
          continue;
        }
        if (words[i].contains(words[j])) {
          if (!list.contains(words[j])) {
            list.add(words[j]);
          }

        }
      }
    }
    return list;
  }

  /**
   * 用kmp 算法是不是更快
   * @param words
   * @return
   */
  public List<String> stringMatching_2(String[] words) {
    List<String> list = new ArrayList<>();
    if (words.length == 0) {
      return list;
    }
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < words.length; i++) {
      String str = words[i];
      builder.append(str + ",");
    }

    for (int i = 0; i < words.length; i++) {
      String str = words[i];
      if (builder.toString().indexOf(str) != builder.toString().lastIndexOf(str)) {
        list.add(str);
      }
    }
    return list;
  }
}
