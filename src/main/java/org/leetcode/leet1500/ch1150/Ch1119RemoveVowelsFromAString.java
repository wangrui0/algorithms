package org.leetcode.leet1500.ch1150;

/**
 * <p>删去字符中的元音
 * <p>1. 题目
 * <p>给你一个字符串 S，请你删去其中的所有元音字母（ ‘a’，‘e’，‘i’，‘o’，‘u’），并返回这个新字符串。
 *
 * <p>示例 1：
 * <p>输入："leetcodeisacommunityforcoders"
 * <p>输出："ltcdscmmntyfrcdrs"
 *
 * <p>示例 2：
 * <p>输入："aeiou"
 * <p>输出：""
 *
 * <p>提示：
 * <p>S 仅由小写英文字母组成。
 * <p>1 <= S.length <= 1000
 * <p>https://leetcode-cn.com/problems/remove-vowels-from-a-string/
 * <p>@author: wangrui
 * <p>@date: 2021/4/9
 */
public class Ch1119RemoveVowelsFromAString {

  public String removeVowels(String S) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < S.length(); i++) {
      if (S.charAt(i) != 'a' && S.charAt(i) != 'e' && S.charAt(i) != 'i' && S.charAt(i) != 'o' && S.charAt(i) != 'u') {
        sb.append(S.charAt(i));
      }
    }
    return sb.toString();

  }
}
