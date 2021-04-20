package org.leetcode.shunxu.ch1400;

import java.util.Arrays;

/**
 * <p>1374. 生成每种字符都是奇数个的字符串
 *
 * <p>给你一个整数 n，请你返回一个含 n 个字符的字符串，其中每种字符在该字符串中都恰好出现 奇数次 。
 *
 * <p>返回的字符串必须只含小写英文字母。如果存在多个满足题目要求的字符串，则返回其中任意一个即可。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：n = 4
 * <p>输出："pppz"
 * <p>解释："pppz" 是一个满足题目要求的字符串，因为 'p' 出现 3 次，且 'z' 出现 1 次。当然，还有很多其他字符串也满足题目要求，比如："ohhh" 和 "love"。
 *
 * <p>示例 2：
 *
 * <p>输入：n = 2
 * <p>输出："xy"
 * <p>解释："xy" 是一个满足题目要求的字符串，因为 'x' 和 'y' 各出现 1 次。当然，还有很多其他字符串也满足题目要求，比如："ag" 和 "ur"。
 *
 * <p>示例 3：
 *
 * <p>输入：n = 7
 * <p>输出："holasss"
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= n <= 500
 *
 * <p>通过次数15,160
 * <p>提交次数20,596
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/generate-a-string-with-characters-that-have-odd-counts/
 * <p>@author: wangrui
 * <p>@date: 2021/4/18
 */
public class Ch1374GenerateAStringWithCharactersThatHaveOddCounts {

  public String generateTheString(int n) {
    char[] ans = new char[n];
    Arrays.fill(ans, 'a');
    if ((n & 1) == 0) {
      ans[0]='b';
    }
    return new String(ans);
  }

}
