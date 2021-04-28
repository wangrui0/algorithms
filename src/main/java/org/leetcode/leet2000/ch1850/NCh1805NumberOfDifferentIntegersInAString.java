package org.leetcode.leet2000.ch1850;

/**
 * <p>1805. 字符串中不同整数的数目
 *
 * <p>给你一个字符串 word ，该字符串由数字和小写英文字母组成。
 *
 * <p>请你用空格替换每个不是数字的字符。例如，"a123bc34d8ef34" 将会变成 " 123  34 8  34" 。注意，剩下的这些整数为（相邻彼此至少有一个空格隔开）："123"、"34"、"8" 和 "34" 。
 *
 * <p>返回对 word 完成替换后形成的 不同 整数的数目。
 *
 * <p>只有当两个整数的 不含前导零 的十进制表示不同， 才认为这两个整数也不同。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：word = "a123bc34d8ef34"
 * <p>输出：3
 * <p>解释：不同的整数有 "123"、"34" 和 "8" 。注意，"34" 只计数一次。
 *
 * <p>示例 2：
 *
 * <p>输入：word = "leet1234code234"
 * <p>输出：2
 *
 * <p>示例 3：
 *
 * <p>输入：word = "a1b01c001"
 * <p>输出：1
 * <p>解释："1"、"01" 和 "001" 视为同一个整数的十进制表示，因为在比较十进制值时会忽略前导零的存在。
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= word.length <= 1000
 * <p>    word 由数字和小写英文字母组成
 *
 * <p>通过次数9,427
 * <p>提交次数18,060
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/number-of-different-integers-in-a-string/
 * <p>@Author: shenpei
 * <p>@Date: 2021/4/25 10:17 下午
 */
public class NCh1805NumberOfDifferentIntegersInAString {

  public int numDifferentIntegers(String word) {
    return -1;
  }
}
