package org.leetcode.shunxu.leet1500.ch1400;

/**
 * <p>1370. 上升下降字符串
 *
 * <p>给你一个字符串 s ，请你根据下面的算法重新构造字符串：
 *
 * <p>    从 s 中选出 最小 的字符，将它 接在 结果字符串的后面。
 * <p>    从 s 剩余字符中选出 最小 的字符，且该字符比上一个添加的字符大，将它 接在 结果字符串后面。
 * <p>    重复步骤 2 ，直到你没法从 s 中选择字符。
 * <p>    从 s 中选出 最大 的字符，将它 接在 结果字符串的后面。
 * <p>    从 s 剩余字符中选出 最大 的字符，且该字符比上一个添加的字符小，将它 接在 结果字符串后面。
 * <p>    重复步骤 5 ，直到你没法从 s 中选择字符。
 * <p>    重复步骤 1 到 6 ，直到 s 中所有字符都已经被选过。
 *
 * <p>在任何一步中，如果最小或者最大字符不止一个 ，你可以选择其中任意一个，并将其添加到结果字符串。
 *
 * <p>请你返回将 s 中字符重新排序后的 结果字符串 。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：s = "aaaabbbbcccc"
 * <p>输出："abccbaabccba"
 * <p>解释：第一轮的步骤 1，2，3 后，结果字符串为 result = "abc"
 * <p>第一轮的步骤 4，5，6 后，结果字符串为 result = "abccba"
 * <p>第一轮结束，现在 s = "aabbcc" ，我们再次回到步骤 1
 * <p>第二轮的步骤 1，2，3 后，结果字符串为 result = "abccbaabc"
 * <p>第二轮的步骤 4，5，6 后，结果字符串为 result = "abccbaabccba"
 *
 * <p>示例 2：
 *
 * <p>输入：s = "rat"
 * <p>输出："art"
 * <p>解释：单词 "rat" 在上述算法重排序以后变成 "art"
 *
 * <p>示例 3：
 *
 * <p>输入：s = "leetcode"
 * <p>输出："cdelotee"
 *
 * <p>示例 4：
 *
 * <p>输入：s = "ggggggg"
 * <p>输出："ggggggg"
 *
 * <p>示例 5：
 *
 * <p>输入：s = "spo"
 * <p>输出："ops"
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= s.length <= 500
 * <p>    s 只包含小写英文字母。
 *
 * <p>通过次数45,363
 * <p>提交次数57,274
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/increasing-decreasing-string/
 * <p>@author: wangrui
 * <p>@date: 2021/4/18
 */
public class Ch1370IncreasingDecreasingString {

  public String sortString_self(String s) {
    StringBuilder sb = new StringBuilder();
    int[] character = new int[26];
    for (int i = 0; i < s.length(); i++) {
      character[s.charAt(i) - 'a']++;
    }
    boolean flag = true;
    while (flag) {
      flag = false;
      for (int i = 0; i < character.length; i++) {
        if (character[i] != 0) {
          sb.append((char) (i + 'a'));
          character[i]--;
          flag = true;
        }
      }
      for (int i = character.length - 1; i >= 0; i--) {
        if (character[i] != 0) {
          sb.append((char) (i + 'a'));
          character[i]--;
          flag = true;
        }
      }
    }
    return sb.toString();
  }

  /**
   * <p>  复杂度分析
   *
   * <p>    时间复杂度：O(∣Σ∣×∣s∣)，其中 Σ 为字符集，s 为传入的字符串，在这道题中，字符集为全部小写字母，∣Σ∣=26。最坏情况下字符串中所有字符都相同，那么对于每一个字符，我们需要遍历一次整个桶。
   *
   * <p>   空间复杂度：O(∣Σ∣)，其中 Σ 为字符集。我们需要和 ∣Σ∣ 等大的桶来记录每一类字符的数量。
   *
   * @param s
   * @return
   */
  public String sortString(String s) {
    int[] num = new int[26];
    for (int i = 0; i < s.length(); i++) {
      num[s.charAt(i) - 'a']++;
    }

    StringBuffer ret = new StringBuffer();
    while (ret.length() < s.length()) {
      for (int i = 0; i < 26; i++) {
        if (num[i] > 0) {
          ret.append((char) (i + 'a'));
          num[i]--;
        }
      }
      for (int i = 25; i >= 0; i--) {
        if (num[i] > 0) {
          ret.append((char) (i + 'a'));
          num[i]--;
        }
      }
    }
    return ret.toString();
  }
}
