package org.leetcode.shunxu.ch850;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <p>819. 最常见的单词
 *
 * <p>给定一个段落 (paragraph) 和一个禁用单词列表 (banned)。返回出现次数最多，同时不在禁用列表中的单词。
 *
 * <p>题目保证至少有一个词不在禁用列表中，而且答案唯一。
 *
 * <p>禁用列表中的单词用小写字母表示，不含标点符号。段落中的单词不区分大小写。答案都是小写字母。
 *
 *
 *
 * <p>示例：
 *
 * <p>输入:
 * <p>paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * <p>banned = ["hit"]
 * <p>输出: "ball"
 * <p>解释:
 * <p>"hit" 出现了3次，但它是一个禁用的单词。
 * <p>"ball" 出现了2次 (同时没有其他单词出现2次)，所以它是段落里出现次数最多的，且不在禁用列表中的单词。
 * <p>注意，所有这些单词在段落里不区分大小写，标点符号需要忽略（即使是紧挨着单词也忽略， 比如 "ball,"），
 * <p>"hit"不是最终的答案，虽然它出现次数更多，但它在禁用单词列表中。
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= 段落长度 <= 1000
 * <p>    0 <= 禁用单词个数 <= 100
 * <p>    1 <= 禁用单词长度 <= 10
 * <p>    答案是唯一的, 且都是小写字母 (即使在 paragraph 里是大写的，即使是一些特定的名词，答案都是小写的。)
 * <p>    paragraph 只包含字母、空格和下列标点符号!?',;.
 * <p>    不存在没有连字符或者带有连字符的单词。
 * <p>    单词里只包含字母，不会出现省略号或者其他标点符号。
 *
 * <p>通过次数17,559
 * <p>提交次数42,179
 * <p>在真实的面试中遇到过这道题？
 * <p>https://leetcode-cn.com/problems/most-common-word/
 * <p>@author: wangrui
 * <p>@date: 2021/3/26
 */
public class Ch819MostCommonWord {

  /**
   * <p>复杂度分析
   *
   * <p>   时间复杂度：O(P+B)，其中 P 是段落 paragraph 的长度，B 是禁用列表 banned 的长度。
   *
   * <p>  空间复杂度：O(P+B)，用来进行计数以及存储禁用列表 banned。
   *
   * @param paragraph
   * @param banned
   * @return
   */
  public String mostCommonWord(String paragraph, String[] banned) {
    paragraph += ".";

    Set<String> banset = new HashSet();
    for (String word : banned) {
      banset.add(word);
    }
    Map<String, Integer> count = new HashMap();

    String ans = "";
    int ansfreq = 0;

    StringBuilder word = new StringBuilder();
    for (char c : paragraph.toCharArray()) {
      if (Character.isLetter(c)) {
        word.append(Character.toLowerCase(c));
      } else if (word.length() > 0) {
        String finalword = word.toString();
        if (!banset.contains(finalword)) {
          count.put(finalword, count.getOrDefault(finalword, 0) + 1);
          if (count.get(finalword) > ansfreq) {
            ans = finalword;
            ansfreq = count.get(finalword);
          }
        }
        word = new StringBuilder();
      }
    }

    return ans;
  }

  public static String mostCommonWord2(String paragraph, String[] banned) {
    Set<String> set = new HashSet<>();
    for (String banner : banned) {
      set.add(banner);
    }
    String ans = "";
    int ansCount = 0;
    StringBuilder sb = new StringBuilder();
    Map<String, Integer> map = new HashMap<>();
    char[] chars = paragraph.toCharArray();
    for (int i = 0; i <= chars.length; i++) {
      if (i < chars.length && Character.isLetter(chars[i])) {
        sb.append(Character.toLowerCase(chars[i]));
      } else if(sb.length()!=0){
        String s = sb.toString();
        if (!set.contains(s)) {
          int count = map.getOrDefault(s, 0) + 1;
          if (count > ansCount) {
            ans = s;
            ansCount = count;
          }
          map.put(s, count);
        }
        sb = new StringBuilder();
      }
    }
    return ans;
  }
}

