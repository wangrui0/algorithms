package org.leetcode.shunxu.ch1350;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>1309. 解码字母到整数映射
 *
 * <p>给你一个字符串 s，它由数字（'0' - '9'）和 '#' 组成。我们希望按下述规则将 s 映射为一些小写英文字符：
 *
 * <p>    字符（'a' - 'i'）分别用（'1' - '9'）表示。
 * <p>    字符（'j' - 'z'）分别用（'10#' - '26#'）表示。
 *
 * <p>返回映射之后形成的新字符串。
 *
 * <p>题目数据保证映射始终唯一。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：s = "10#11#12"
 * <p>输出："jkab"
 * <p>解释："j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
 *
 * <p>示例 2：
 *
 * <p>输入：s = "1326#"
 * <p>输出："acz"
 *
 * <p>示例 3：
 *
 * <p>输入：s = "25#"
 * <p>输出："y"
 *
 * <p>示例 4：
 *
 * <p>输入：s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"
 * <p>输出："abcdefghijklmnopqrstuvwxyz"
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= s.length <= 1000
 * <p>    s[i] 只包含数字（'0'-'9'）和 '#' 字符。
 * <p>    s 是映射始终存在的有效字符串。
 *
 * <p>通过次数14,661
 * <p>提交次数19,423
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/decrypt-string-from-alphabet-to-integer-mapping/
 * <p>@author: wangrui
 * <p>@date: 2021/4/12
 */
public class Ch1309DecryptStringFromAlphabetToIntegerMapping {

  public static void main(String[] args) {
    System.out.println(freqAlphabets_self("10#11#12"));
  }

  /**
   * 倒序
   *
   * @param s
   * @return
   */
  public static String freqAlphabets_self(String s) {
    Map<String, String> map = new HashMap<>();
    map.put("1", "a");
    map.put("2", "b");
    map.put("3", "c");
    map.put("4", "d");
    map.put("5", "e");
    map.put("6", "f");
    map.put("7", "g");
    map.put("8", "h");
    map.put("9", "i");
    map.put("10#", "j");
    map.put("11#", "k");
    map.put("12#", "l");
    map.put("13#", "m");
    map.put("14#", "n");
    map.put("15#", "o");
    map.put("16#", "p");
    map.put("17#", "q");
    map.put("18#", "r");
    map.put("19#", "s");
    map.put("20#", "t");
    map.put("21#", "u");
    map.put("22#", "v");
    map.put("23#", "w");
    map.put("24#", "x");
    map.put("25#", "y");
    map.put("26#", "z");
    StringBuilder sb = new StringBuilder();
    for (int i = s.length() - 1; i >= 0; ) {
      if (s.charAt(i) == '#') {
        sb.append(map.get(s.substring(i - 2, i + 1)));
        i = i - 3;
      } else {
        sb.append(map.get(String.valueOf(s.charAt(i))));
        i--;
      }
    }
    return sb.reverse().toString();
  }

  /**
   * 顺序
   *
   * @param s
   * @return
   */
  public String freqAlphabets(String s) {
    // 1 - 9 只有一位数， 10 - 26 有 10# - 26# 三位数
    StringBuilder sb = new StringBuilder();
    char[] map = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    for (int i = 0; i < s.length(); ) {
      if (i + 2 < s.length() && s.charAt(i + 2) == '#') {
        sb.append(map[Integer.valueOf(s.substring(i, i + 2)) - 1]);
        i += 3;
      } else {
        sb.append((char) (map[s.charAt(i) - '0'] - 1));
        i++;
      }
    }
    return sb.toString();
  }
}
