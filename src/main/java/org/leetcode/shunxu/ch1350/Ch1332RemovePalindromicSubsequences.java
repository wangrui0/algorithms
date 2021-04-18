package org.leetcode.shunxu.ch1350;

/**
 * 1332. 删除回文子序列
 * <p>
 * 给你一个字符串 s，它仅由字母 'a' 和 'b' 组成。每一次删除操作都可以从 s 中删除一个回文 子序列。
 * <p>
 * 返回删除给定字符串中所有字符（字符串为空）的最小删除次数。
 * <p>
 * 「子序列」定义：如果一个字符串可以通过删除原字符串某些字符而不改变原字符顺序得到，那么这个字符串就是原字符串的一个子序列。
 * <p>
 * 「回文」定义：如果一个字符串向后和向前读是一致的，那么这个字符串就是一个回文。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ababa" 输出：1 解释：字符串本身就是回文序列，只需要删除一次。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "abb" 输出：2 解释："abb" -> "bb" -> "". 先删除回文子序列 "a"，然后再删除 "bb"。
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "baabb" 输出：2 解释："baabb" -> "b" -> "". 先删除回文子序列 "baab"，然后再删除 "b"。
 * <p>
 * 示例 4：
 * <p>
 * 输入：s = "" 输出：0
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 1000 s 仅包含字母 'a'  和 'b'
 * <p>
 * 通过次数7,837 提交次数11,640 请问您在哪类招聘中遇到此题？ https://leetcode-cn.com/problems/remove-palindromic-subsequences/
 *
 * @author: wangrui
 * @date: 2021/4/18
 */
public class Ch1332RemovePalindromicSubsequences {

  /**
   * <p>解题思路
   *
   * <p>回文子序列不是回文子字符串，比如"aababdaba"，"aaaaa"就是他的回文子序列。
   * <p>也就是顶多删两次，一次全删掉"a"，一次全删掉"b"。
   * <p>如果是回文字符串，就删一次。
   * <p>空字符串就0次。
   * <p>看代码吧，不想说了。
   *
   * @param s
   * @return
   */
  public int removePalindromeSub(String s) {
    if ("".equals(s)) {
      return 0;
    }
    if (s.equals(new StringBuilder(s).reverse().toString())) {
      return 1;
    }
    return 2;
  }

  /**
   * <p>解题思路
   *
   * <p>  判断字符串本身是否是回文字符
   * <p>  如果是，则只需一次，否则需要两次
   *
   * @param s
   * @return
   */
  public int removePalindromeSub_2(String s) {
    if (s.length() == 0) {
      return 0;
    }
    char[] chars = s.toCharArray();
    boolean isPalindrome = true;
    for (int i = 0; i < chars.length / 2; i++) {
      if (chars[i] != chars[chars.length - 1 - i]) {
        isPalindrome = false;
        break;
      }
    }
    return isPalindrome ? 1 : 2;
  }


}
