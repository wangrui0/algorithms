package org.leetcode.leet2000.ch1700;

/**
 * <p>1662. 检查两个字符串数组是否相等
 *
 * <p>给你两个字符串数组 word1 和 word2 。如果两个数组表示的字符串相同，返回 true ；否则，返回 false 。
 *
 * <p>数组表示的字符串 是由数组中的所有元素 按顺序 连接形成的字符串。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：word1 = ["ab", "c"], word2 = ["a", "bc"]
 * <p>输出：true
 * <p>解释：
 * <p>word1 表示的字符串为 "ab" + "c" -> "abc"
 * <p>word2 表示的字符串为 "a" + "bc" -> "abc"
 * <p>两个字符串相同，返回 true
 *
 * <p>示例 2：
 *
 * <p>输入：word1 = ["a", "cb"], word2 = ["ab", "c"]
 * <p>输出：false
 *
 * <p>示例 3：
 *
 * <p>输入：word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
 * <p>输出：true
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= word1.length, word2.length <= 103
 * <p>    1 <= word1[i].length, word2[i].length <= 103
 * <p>    1 <= sum(word1[i].length), sum(word2[i].length) <= 103
 * <p>    word1[i] 和 word2[i] 由小写字母组成
 *
 * <p>通过次数16,702
 * <p>提交次数20,410
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/check-if-two-string-arrays-are-equivalent/
 * <p>@Author: shenpei
 * <p>@Date: 2021/4/25 7:30 下午
 */
public class NCh1662CheckIfTwoStringArraysAreEquivalent {

  public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
    return true;
  }
}
