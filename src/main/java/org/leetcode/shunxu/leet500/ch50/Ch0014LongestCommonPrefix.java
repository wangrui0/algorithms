package org.leetcode.shunxu.leet500.ch50;

/**
 * @author: wangrui
 * @date: 2020/10/27
 * <p>
 * 最长公共前缀
 * <p>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * <p>
 * 输出: "fl"
 * <p>
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * <p>
 * 输出: ""
 * <p>
 * 解释: 输入不存在公共前缀。
 * <p>
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 * <p>
 * 来源：力扣（LeetCode）
 * <p>
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * <p>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Ch0014LongestCommonPrefix {

  public static void main(String[] args) {
//    String[] strs = {"flower", "flow", "fay"};
//    String[] strs = {"flower", "flow", "flight"};
//    String[] strs = {"dog", "racecar", "car"};
//    String[] strs = {"dog", "dog", "dog"};
//    String[] strs = {"dog"};
    String[] strs = {};
    System.out.println(longestCommonPrefix3(strs));
  }

  /**
   * self
   *
   * @param strs
   * @return
   */
  public static String longestCommonPrefix(String[] strs) {
    String longestCommonPrefix = "";
    if (strs == null || strs.length == 0) {
      return "";
    }
    if (strs.length == 1) {
      return strs[0];
    }
    String firstStr = strs[0];
    for (int i = 1; i < strs.length; i++) {
      String currentStr = longestCommonPrefix(firstStr, strs[i]);
      if (currentStr == "") {
        longestCommonPrefix = currentStr;
        break;
      } else if (currentStr.length() < longestCommonPrefix.length() || longestCommonPrefix == "") {
        longestCommonPrefix = currentStr;
      }

    }
    return longestCommonPrefix;
  }

  public static String longestCommonPrefix(String str1, String str2) {
    int min = str1.length() > str2.length() ? str2.length() : str1.length();
    for (int i = 0; i < min; i++) {
      if (str1.charAt(i) != str2.charAt(i)) {
        return str1.substring(0, i);
      }
    }
    return str1.substring(0, min);
  }

  /**
   * 官方： 横向法
   * <p>
   * 复杂度分析
   * <p>
   * 时间复杂度：O(mn)，其中 m 是字符串数组中的字符串的平均长度，n 是字符串的数量。最坏情况下，字符串数组中的每个字符串的每个字符都会被比较一次。
   * <p>
   * 空间复杂度：O(1)。使用的额外空间复杂度为常数。
   *
   * @param strs
   * @return
   */
  public String longestCommonPrefix2(String[] strs) {
    if (strs == null || strs.length == 0) {
      return "";
    }
    String prefix = strs[0];
    int count = strs.length;
    for (int i = 1; i < count; i++) {
      prefix = longestCommonPrefix2(prefix, strs[i]);
      if (prefix.length() == 0) {
        break;
      }
    }
    return prefix;
  }

  public String longestCommonPrefix2(String str1, String str2) {
    int length = Math.min(str1.length(), str2.length());
    int index = 0;
    while (index < length && str1.charAt(index) == str2.charAt(index)) {
      index++;
    }
    return str1.substring(0, index);
  }

  /**
   * 纵向法:
   * <p>
   * 是横向扫描，依次遍历每个字符串，更新最长公共前缀。另一种方法是纵向扫描。纵向扫描时，从前往后遍历所有字符串的每一列，
   * <p>
   * 比较相同列上的字符是否相同，如果相同则继续对下一列进行比较，如果不相同则当前列不再属于公共前缀，当前列之前的部分为最长公共前缀。 ==============================================
   * <p>
   * 复杂度分析
   * <p>
   * 时间复杂度：O(mn)，其中 m 是字符串数组中的字符串的平均长度，n 是字符串的数量。最坏情况下，字符串数组中的每个字符串的每个字符都会被比较一次。
   * <p>
   * 空间复杂度：O(1)。使用的额外空间复杂度为常数。
   * <p>
   *
   * @param strs
   * @return
   */
  public static String longestCommonPrefix3(String[] strs) {
    if (strs == null || strs.length == 0) {
      return "";
    }
    String str0 = strs[0];
    int count = str0.length();
    for (int i = 0; i < count; i++) {
      for (int j = 1; j < strs.length; j++) {
        String currentStr = strs[j];
        if (i == currentStr.length() || currentStr.charAt(i) != str0.charAt(i)) {
          return str0.substring(0, i);
        }

      }
    }
    return str0;
  }

}
