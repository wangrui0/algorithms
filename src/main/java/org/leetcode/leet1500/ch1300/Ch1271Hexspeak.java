package org.leetcode.leet1500.ch1300;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>LeetCode 1271. 十六进制魔术数字（进制转换）
 * <p>2020-07-13阅读 1330
 * <p>1. 题目
 * <p>你有一个十进制数字，请按照此规则将它变成「十六进制魔术数字」：首先将它变成字母大写的十六进制字符串，然后将所有的数字 0 变成字母 O ，将数字 1  变成字母 I 。
 *
 * <p>如果一个数字在转换后只包含 {“A”, “B”, “C”, “D”, “E”, “F”, “I”, “O”} ，那么我们就认为这个转换是有效的。
 *
 * <p>给你一个字符串 num ，它表示一个十进制数 N，如果它的十六进制魔术数字转换是有效的，请返回转换后的结果，否则返回 “ERROR” 。
 *
 * <p>示例 1：
 * <p>输入：num = "257"
 * <p>输出："IOI"
 * <p>解释：257 的十六进制表示是 101 。
 *
 * <p>示例 2：
 * <p>输入：num = "3"
 * <p>输出："ERROR"
 *
 * <p>提示：
 * <p>1 <= N <= 10^12
 * <p>给定字符串不会有前导 0 。
 * <p>结果中的所有字母都应该是大写字母。
 * <p>https://leetcode-cn.com/problems/hexspeak/
 * <p>@author: wangrui
 * <p>@date: 2021/4/12
 */
public class Ch1271Hexspeak {

  public String toHexspeak(String num) {
    String s = Long.toHexString(Long.parseLong(num)).   // 十进制字符串转十进制数字，然后转成十六进制字符串
        replace('1', 'I').  // 替换
        replace('0', 'O').  // 替换
        toUpperCase();  // 全部变为大写

    List<Character> list = Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'I', 'O');
    for (int i = 0; i < s.length(); i++) {
      if (!list.contains(s.charAt(i))) {
        return "ERROR";
      }
    }
    return s;
  }

  public static Map<Long, String> map = new HashMap<Long, String>() {
    {
      put(1L, "I");
      put(0L, "O");
      put(10L, "A");
      put(11L, "B");
      put(12L, "C");
      put(13L, "D");
      put(14L, "E");
      put(15L, "F");
    }
  };

  /**
   * self
   *
   * @param num
   * @return
   */
  public static String toHexspeak2(String num) {
    StringBuilder sb = new StringBuilder();
    Long numLong = Long.valueOf(num);
    while (numLong > 0) {
      long yushu = numLong % 16;
      if (!map.containsKey(yushu)) {
        return "ERROR";
      }
      sb.append(map.get(yushu));
      numLong /= 16;
    }
    return sb.toString();
  }
}
