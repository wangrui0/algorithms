package org.leetcode.shunxu.leet1500.ch1200;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>LeetCode 1165. 单行键盘（哈希）
 * <p>2020-07-13阅读 1100
 * <p>1. 题目
 *
 * <p>我们定制了一款特殊的力扣键盘，所有的键都排列在一行上。
 *
 * <p>我们可以按从左到右的顺序，用一个长度为 26 的字符串 keyboard （索引从 0 开始，到 25 结束）来表示该键盘的键位布局。
 *
 * <p>现在需要测试这个键盘是否能够有效工作，那么我们就需要个机械手来测试这个键盘。
 *
 * <p>最初的时候，机械手位于左边起第一个键（也就是索引为 0 的键）的上方。
 * <p> 当机械手移动到某一字符所在的键位时，就会在终端上输出该字符。
 *
 * <p>机械手从索引 i 移动到索引 j 所需要的时间是 |i - j|。
 *
 * <p>当前测试需要你使用机械手输出指定的单词 word，请你编写一个函数来计算机械手输出该单词所需的时间。
 *
 * <p>示例 1：
 * <p>输入：keyboard = "abcdefghijklmnopqrstuvwxyz", word = "cba"
 * <p>输出：4
 * <p>解释：
 * <p>机械手从 0 号键移动到 2 号键来输出 'c'，又移动到 1 号键来输出 'b'，
 * <p>接着移动到 0 号键来输出 'a'。
 * <p>总用时 = 2 + 1 + 1 = 4.
 *
 * <p>示例 2：
 * <p>输入：keyboard = "pqrstuvwxyzabcdefghijklmno", word = "leetcode"
 * <p>输出：73
 *
 * <p>提示：
 * <p>keyboard.length == 26
 * <p>keyboard 按某种特定顺序排列，并包含每个小写英文字母一次。
 * <p>1 <= word.length <= 10^4
 * <p>https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters/solution/pin-xie-dan-ci-by-leetcode-solution/
 * <p>word[i] 是一个小写英文字母
 * <p>@author: wangrui
 * <p>@date: 2021/4/9
 */
public class Ch1165SingleRowKeyboard {

  public static void main(String[] args) {
    System.out.println(calculateTime("pqrstuvwxyzabcdefghijklmno", "leetcode"));
  }

  /**
   * @param keyboard
   * @param word
   * @return
   */
  public static int calculateTime(String keyboard, String word) {
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < keyboard.length(); i++) {
      map.put(keyboard.charAt(i), i);
    }
    int preIndex = 0;
    int sum = 0;
    for (int i = 0; i < word.length(); i++) {
      Integer index = map.get(word.charAt(i));
      sum += (Math.abs(index - preIndex));
      preIndex = index;
    }
    return sum;
  }
}
