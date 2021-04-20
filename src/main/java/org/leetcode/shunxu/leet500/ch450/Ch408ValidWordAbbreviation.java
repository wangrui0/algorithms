package org.leetcode.shunxu.leet500.ch450;


/**
 * <p>有效单词缩写
 * <p>问题
 *
 * <p> 给定非空字符串s和缩写abbr，返回字符串是否与给定缩写匹配。
 *
 *
 *
 * <p> 字符串（如“word”）仅包含以下有效缩写：
 *
 *
 *
 * <p>[“word”，“1ord”，“w1rd”，“wo1d”，“wor1”，“2rd”，“w2d”，“wo2”，“1o1d”，“1or1”，“w1r1”，“1o2”，“2r1”，“3d”，“w3”，“4”]
 *
 * <p>请注意，只有上面的缩写是字符串“word”的有效缩写。任何其他字符串都不是“word”的有效缩写。
 *
 *
 *
 * <p>注：
 *
 * <p>假设s只包含小写字母，abbr只包含小写字母和数字。
 *
 *
 *
 * <p>例1：
 *
 * <p>给定s=“internationalization”，abbr=“i12iz4n”：
 *
 *
 *
 * <p> 返回true。
 *
 * <p>例2：
 *
 * <p>给定s=“apple”，abbr=“a2e”：
 *
 *
 *
 * <p>返回false。
 * <p>https://leetcode-cn.com/problems/valid-word-abbreviation/
 *
 * @author: wangrui
 * @date: 2021/3/3
 */
public class Ch408ValidWordAbbreviation {
  /**
   * <p>时间复杂度:O(n)
   * <p>空间复杂度:O(1)
   *
   * @param word
   * @param abbr
   * @return
   */
  public boolean validWordAbbreviation(String word, String abbr) {
    if (word == null || abbr == null) {
      return false;
    }
    int i = 0, j = 0;
    while (i < word.length() && j < abbr.length()) {
      char ch1 = word.charAt(i), ch2 = abbr.charAt(j);
      if (ch1 == ch2) {
        i++;
        j++;
      } else if (ch2 >= '1' && ch2 <= '9') {
        int start = j;
        while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
          j++;
        }
        int count = Integer.valueOf(abbr.substring(start, j));
        i += count;
      } else {
        return false;
      }
    }
    return i == word.length() && j == abbr.length();
  }
}
