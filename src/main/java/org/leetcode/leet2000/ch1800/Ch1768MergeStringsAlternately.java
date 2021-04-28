package org.leetcode.leet2000.ch1800;

/**
 * <p>1768. 交替合并字符串
 *
 * <p>给你两个字符串 word1 和 word2 。请你从 word1 开始，通过交替添加字母来合并字符串。如果一个字符串比另一个字符串长，就将多出来的字母追加到合并后字符串的末尾。
 *
 * <p>返回 合并后的字符串 。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：word1 = "abc", word2 = "pqr"
 * <p>输出："apbqcr"
 * <p>解释：字符串合并情况如下所示：
 * <p>word1：  a   b   c
 * <p>word2：    p   q   r
 * <p>合并后：  a p b q c r
 *
 * <p>示例 2：
 *
 * <p>输入：word1 = "ab", word2 = "pqrs"
 * <p>输出："apbqrs"
 * <p>解释：注意，word2 比 word1 长，"rs" 需要追加到合并后字符串的末尾。
 * <p>word1：  a   b
 * <p>word2：    p   q   r   s
 * <p>合并后：  a p b q   r   s
 *
 * <p>示例 3：
 *
 * <p>输入：word1 = "abcd", word2 = "pq"
 * <p>输出："apbqcd"
 * <p>解释：注意，word1 比 word2 长，"cd" 需要追加到合并后字符串的末尾。
 * <p>word1：  a   b   c   d
 * <p>word2：    p   q
 * <p>合并后：  a p b q c   d
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= word1.length, word2.length <= 100
 * <p>    word1 和 word2 由小写英文字母组成
 *
 * <p>通过次数8,446
 * <p>提交次数10,890
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/merge-strings-alternately/
 * <p>@Author: shenpei
 * <p>@Date: 2021/4/25 10:06 下午
 */
public class Ch1768MergeStringsAlternately {

  public String mergeAlternately(String word1, String word2) {
    StringBuilder sb = new StringBuilder();
    int i = 0;
    for (; i < word1.length() && i < word2.length(); i++) {
      sb.append(word1.charAt(i)).append(word2.charAt(i));
    }
    if (i < word1.length()) {
      for (; i < word1.length(); i++) {
        sb.append(word1.charAt(i));
      }
    } else {
      for (; i < word2.length(); i++) {
        sb.append(word2.charAt(i));
      }
    }
    return sb.toString();
  }

  public String mergeAlternately_2(String word1, String word2) {
    int len1 = word1.length(), len2 = word2.length();
    char[] letters = new char[len1 + len2];
    int i = 0, j = 0;
    while (i + j < len1 + len2) {
      if (i < len1) {
        letters[i + j] = word1.charAt(i);
        i++;
      }
      if (j < len2) {
        letters[i + j] = word2.charAt(j);
        j++;
      }
    }
    return new String(letters);
  }


}
