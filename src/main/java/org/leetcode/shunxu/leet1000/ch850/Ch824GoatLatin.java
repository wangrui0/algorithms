package org.leetcode.shunxu.leet1000.ch850;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>824. 山羊拉丁文
 *
 * <p>给定一个由空格分割单词的句子 S。每个单词只包含大写或小写字母。
 *
 * <p>我们要将句子转换为 “Goat Latin”（一种类似于 猪拉丁文 - Pig Latin 的虚构语言）。
 *
 * <p>山羊拉丁文的规则如下：
 *
 * <p>    如果单词以元音开头（a, e, i, o, u），在单词后添加"ma"。
 * <p>    例如，单词"apple"变为"applema"。
 *
 * <p>    如果单词以辅音字母开头（即非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。
 * <p>    例如，单词"goat"变为"oatgma"。
 *
 * <p>    根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从1开始。
 * <p>    例如，在第一个单词后添加"a"，在第二个单词后添加"aa"，以此类推。
 *
 * <p>返回将 S 转换为山羊拉丁文后的句子。
 *
 * <p>示例 1:
 *
 * <p>输入: "I speak Goat Latin"
 * <p>输出: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
 *
 * <p>示例 2:
 *
 * <p>输入: "The quick brown fox jumped over the lazy dog"
 * <p>输出: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
 *
 * <p>说明:
 *
 * <p>    S 中仅包含大小写字母和空格。单词间有且仅有一个空格。
 * <p>    1 <= S.length <= 150。
 *
 * <p>通过次数14,477
 * <p>提交次数23,763
 * <p>@author: wangrui
 * <p>@date: 2021/3/30
 */
public class Ch824GoatLatin {

  public static String toGoatLatin(String S) {
    Set<Character> set = new HashSet<>();
    set.add('a');
    set.add('e');
    set.add('i');
    set.add('o');
    set.add('u');
    set.add('A');
    set.add('E');
    set.add('I');
    set.add('O');
    set.add('U');

    StringBuilder sb = new StringBuilder();

    String[] split = S.split("\\s+");
    int num = 0;
    for (String str : split) {
      for (int i = 0; i < str.length(); i++) {
        if (i == 0 && set.contains(str.charAt(0)) || i != 0) {
          sb.append(str.charAt(i));
        }
        if (i == str.length() - 1 && !set.contains(str.charAt(0))) {
          sb.append(str.charAt(0));
        }
        if (i == str.length() - 1) {
          sb.append("ma");
          for (int j = 0; j <= num; j++) {
            sb.append('a');
          }
        }
      }
      num++;
      sb.append(" ");
    }
    return sb.toString().trim();
  }

  /**
   * <p> 复杂度分析
   *
   * <p>   时间复杂度：O(N^2)，其中 N 是 S 的长度。这包含旋转单词的复杂度以及添加额外 "a" 字符。
   * <p>  空间复杂度：O(N^2)，空间需要考虑加入的额外字符 "a"
   *
   * @param S
   * @return
   */
  public String toGoatLatin_1(String S) {
    Set<Character> vowel = new HashSet();
    for (char c : new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'}) {
      vowel.add(c);
    }

    int t = 1;
    StringBuilder ans = new StringBuilder();
    for (String word : S.split(" ")) {
      char first = word.charAt(0);
      if (vowel.contains(first)) {
        ans.append(word);
      } else {
        ans.append(word.substring(1));
        ans.append(word.substring(0, 1));
      }
      ans.append("ma");
      for (int i = 0; i < t; i++) {
        ans.append("a");
      }
      t++;
      ans.append(" ");
    }

    ans.deleteCharAt(ans.length() - 1);
    return ans.toString();
  }
}
