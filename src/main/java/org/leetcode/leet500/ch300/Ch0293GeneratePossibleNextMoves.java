package org.leetcode.leet500.ch300;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>题目描述：
 * <p>你和朋友玩一个叫做「翻转游戏」的游戏，游戏规则：给定一个只有 + 和 - 的字符串。你和朋友轮流将 连续 的两个 “++” 反转成 “–”。 当一方无法进行有效的翻转时便意味着游戏结束，则另一方获胜。
 * <p>请你写出一个函数，来计算出第一次翻转后，字符串所有的可能状态。
 *
 * <p>示例：
 * <p>输入: s = “++++”
 * <p>输出:
 * <p>[
 * <p>  "--++",
 * <p>  "+--+",
 * <p>   "++--"
 * <p> ]
 * <p> 注意：如果不存在可能的有效操作，请返回一个空列表 []。
 * <p>————————————————
 * <p> 版权声明：本文为CSDN博主「王培琳」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * <p> 原文链接：https://blog.csdn.net/weixin_44171872/article/details/107905111
 *
 * @author: wangrui
 * @date: 2021/2/28
 */
public class Ch0293GeneratePossibleNextMoves {

  /**
   *   <p>其实本题的意思是：把字符串中连续的 “++” 翻转成 “–”，总共有多少种反转后的结果。
   * <p>
   *   <p>明白了题意，下面就好办了，直接遍历字符串 S，如果遍历到的当前字符和下一个字符都是 ‘+’ ，
   * <p>那么就把当前字符和下一个字符翻转后的结果存储起来。直到遍历到倒数第二个字符后遍历结束，最后一个字符不用遍历。
   *
   * @param s
   * @return
   */
  public List<String> generatePossibleNextMoves(String s) {
    List<String> list = new ArrayList<>();
    if (s == null || s.length() == 0) {
      return list;
    }
    for (int i = 0; i < s.length(); i++) {
      if (i != s.length() - 1 && s.charAt(i) == '+' && s.charAt(i) == s.charAt(i + 1)) {
        StringBuilder sb = new StringBuilder(s);
        sb.replace(i, i + 2, "--");
        list.add(sb.toString());
      }
    }
    return list;
  }

  public static List<String> generatePossibleNextMoves2(String s) {
    List<String> result = new ArrayList<>();
    if (s == null || s.length() == 0) {
      return result;
    }
    for (int i = 0; i < s.length(); i++) {
      if (i != s.length() - 1 && s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
        StringBuilder sb = new StringBuilder(s);
        sb.replace(i, i + 2, "--");
        result.add(sb.toString());
      }
    }
    return result;
  }

}
