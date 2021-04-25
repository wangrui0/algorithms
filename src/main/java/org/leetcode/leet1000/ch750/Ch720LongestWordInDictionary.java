package org.leetcode.leet1000.ch750;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>720. 词典中最长的单词
 *
 * <p>给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。若其中有多个可行的答案，则返回答案中字典序最小的单词。
 *
 * <p>若无答案，则返回空字符串。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：
 * <p>words = ["w","wo","wor","worl", "world"]
 * <p>输出："world"
 * <p>解释：
 * <p>单词"world"可由"w", "wo", "wor", 和 "worl"添加一个字母组成。
 *
 * <p>示例 2：
 *
 * <p>输入：
 * <p>words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
 * <p>输出："apple"
 * <p>解释：
 * <p>"apply"和"apple"都能由词典中的单词组成。但是"apple"的字典序小于"apply"。
 *
 *
 *
 * <p>提示：
 *
 * <p>    所有输入的字符串都只包含小写字母。
 * <p>    words数组长度范围为[1,1000]。
 * <p>    words[i]的长度范围为[1,30]。
 * https://leetcode-cn.com/problems/longest-word-in-dictionary/
 * <p>通过次数14,679
 * <p>提交次数30,469
 * <p>在真实的面试中遇到过这道题？
 * <p>@author: wangrui
 * <p>@date: 2021/3/23
 */
public class Ch720LongestWordInDictionary {

  public String longestWord(String[] words) {
    Set<String> set = new HashSet<>();
    for (String word : words) {
      set.add(word);
    }
    String ans = "";
    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      boolean flag = true;
      if (word.length() > ans.length() || word.length() == ans.length() && word.compareTo(ans) < 0) {
        for (int j = 1; j < word.length(); j++) {
          if (!set.contains(word.substring(0, j))) {
            flag = false;
            break;
          }
        }
        if (flag) {
          ans = word;
        }

      }
    }
    return ans;
  }

  /**
   * <p>复杂度分析
   *
   * <p>    时间复杂度：O(∑wi2​)。wi​ 指的是 words[i] 的长度，在 Set 中检查 words[i] 全部前缀是否均存在的时间复杂度是 O(∑wi2​)。
   * <p> 空间复杂度：O(∑wi2​) 用来存放子串的空间。
   *
   * @param words
   * @return
   */
  public String longestWord2(String[] words) {
    String ans = "";
    Set<String> wordset = new HashSet();
    for (String word : words) {
      wordset.add(word);
    }
    for (String word : words) {
      if (word.length() > ans.length() ||
          word.length() == ans.length() && word.compareTo(ans) < 0) {
        boolean good = true;
        for (int k = 1; k < word.length(); ++k) {
          if (!wordset.contains(word.substring(0, k))) {
            good = false;
            break;
          }
        }
        if (good) {
          ans = word;
        }
      }
    }
    return ans;
  }

}
