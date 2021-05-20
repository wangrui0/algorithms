package org.company.meituan.all.week01.done;

/**
 * <p>14. 最长公共前缀
 *
 * <p>编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * <p>如果不存在公共前缀，返回空字符串 ""。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：strs = ["flower","flow","flight"]
 * <p>输出："fl"
 *
 * <p>示例 2：
 *
 * <p>输入：strs = ["dog","racecar","car"]
 * <p>输出：""
 * <p>解释：输入不存在公共前缀。
 *
 *
 *
 * <p>提示：
 *
 * <p>    0 <= strs.length <= 200
 * <p>    0 <= strs[i].length <= 200
 * <p>    strs[i] 仅由小写英文字母组成
 *
 * <p>通过次数522,133
 * <p>提交次数1,315,701
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/longest-common-prefix/
 * <p>@author: wangrui
 * <p>@date: 2021/5/14
 */
public class NCh050_14_LongestCommonPrefix最长公共前缀 {

  /**
   * <p>方法一：横向扫描
   * <p>复杂度分析
   *
   * <p>   时间复杂度：O(mn)，其中 m 是字符串数组中的字符串的平均长度，n 是字符串的数量。最坏情况下，字符串数组中的每个字符串的每个字符都会被比较一次。
   *
   * <p>   空间复杂度：O(1)。使用的额外空间复杂度为常数。
   *
   * @param strs
   * @return
   */
  public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) {
      return "";
    }
    String prefix = strs[0];
    int count = strs.length;
    for (int i = 1; i < count; i++) {
      prefix = longestCommonPrefix(prefix, strs[i]);
      if (prefix.length() == 0) {
        break;
      }
    }
    return prefix;
  }

  public String longestCommonPrefix(String str1, String str2) {
    int length = Math.min(str1.length(), str2.length());
    int index = 0;
    while (index < length && str1.charAt(index) == str2.charAt(index)) {
      index++;
    }
    return str1.substring(0, index);
  }

  /**
   * <p>方法一：纵向扫描
   * <p>复杂度分析
   *
   * <p>   时间复杂度：O(mn)，其中 m 是字符串数组中的字符串的平均长度，n 是字符串的数量。最坏情况下，字符串数组中的每个字符串的每个字符都会被比较一次。
   *
   * <p>   空间复杂度：O(1)。使用的额外空间复杂度为常数。
   *
   * @param strs
   * @return
   */
  public String longestCommonPrefix_2(String[] strs) {
    if (strs == null || strs.length == 0) {
      return "";
    }
    int length = strs[0].length();
    int count = strs.length;
    for (int i = 0; i < length; i++) {
      char c = strs[0].charAt(i);
      for (int j = 1; j < count; j++) {
        if (i == strs[j].length() || strs[j].charAt(i) != c) {
          return strs[0].substring(0, i);
        }
      }
    }
    return strs[0];
  }


}
