package org.leetcode.shunxu.ch1200;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * <p>1189. “气球” 的最大数量
 *
 * <p>给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。
 *
 * <p>字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：text = "nlaebolko"
 * <p>输出：1
 *
 * <p>示例 2：
 *
 * <p>输入：text = "loonbalxballpoon"
 * <p>输出：2
 *
 * <p>示例 3：
 *
 * <p>输入：text = "leetcode"
 * <p>输出：0
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= text.length <= 10^4
 * <p>    text 全部由小写英文字母组成
 *
 * <p>通过次数18,057
 * <p>提交次数28,157
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/maximum-number-of-balloons/
 * <p>@author: wangrui
 * <p>@date: 2021/4/10
 */
public class Ch1189MaximumNumberOfBalloons {

  public int maxNumberOfBalloons(String text) {
    int[] letters = new int[26];
    for (char c : text.toCharArray()) {
      letters[c - 'a']++;
    }
    letters['l' - 'a'] /= 2;
    letters['o' - 'a'] /= 2;
    int min = Integer.MAX_VALUE;
    for (char c : "balon".toCharArray()) {
      min = Math.min(letters[c - 'a'], min);
    }
    return min;
  }
}
