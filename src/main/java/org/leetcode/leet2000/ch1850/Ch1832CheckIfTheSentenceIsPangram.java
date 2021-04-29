package org.leetcode.leet2000.ch1850;


/**
 * <p>1832. 判断句子是否为全字母句
 *
 * <p>全字母句 指包含英语字母表中每个字母至少一次的句子。
 *
 * <p>给你一个仅由小写英文字母组成的字符串 sentence ，请你判断 sentence 是否为 全字母句 。
 *
 * <p>如果是，返回 true ；否则，返回 false 。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：sentence = "thequickbrownfoxjumpsoverthelazydog"
 * <p>输出：true
 * <p>解释：sentence 包含英语字母表中每个字母至少一次。
 *
 * <p>示例 2：
 *
 * <p>输入：sentence = "leetcode"
 * <p>输出：false
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= sentence.length <= 1000
 * <p>    sentence 由小写英语字母组成
 *
 * <p>通过次数7,420
 * <p>提交次数8,853
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/check-if-the-sentence-is-pangram/
 * <p>@Author: shenpei
 * <p>@Date: 2021/4/25 10:20 下午
 */
public class Ch1832CheckIfTheSentenceIsPangram {

  public boolean checkIfPangram(String sentence) {
    int[] count = new int[26];
    for (int i = 0; i < sentence.length(); i++) {
      count[sentence.charAt(i) - 'a']++;
    }
    for (int i = 0; i < count.length; i++) {
      if (count[i] == 0) {
        return false;
      }
    }
    return true;
  }

  public boolean checkIfPangram_2(String sentence) {
    if (sentence.length() < 26) {
      return false;
    }
    boolean[] arr = new boolean[26];
    int count = 0;
    for (int i = 0; i < sentence.length(); i++) {
      int index = sentence.charAt(i) - 'a';
      if (!arr[index]) {
        count++;
        if (count == 26) {
          return true;
        }
        arr[index] = true;
      }
    }
    return false;
  }
}
