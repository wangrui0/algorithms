package org.leetcode.shunxu.leet1000.ch700;

/**
 * <p>680. 验证回文字符串 Ⅱ
 * <p>给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 *
 * <p>示例 1:
 *
 * <p>输入: "aba"
 * <p>输出: True
 * <p>示例 2:
 *
 * <p>输入: "abca"
 * <p>输出: True
 * <p>解释: 你可以删除c字符。
 * <p>注意:
 *
 * <p>字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 * <p>通过次数66,371提交次数165,527
 * <p>https://leetcode-cn.com/problems/valid-palindrome-ii/
 *
 * @Author: shenpei
 * @Date: 2021/3/18 11:28 下午
 */
public class Ch680ValidPalindromeII {

  /**
   * <p> 复杂度分析
   *
   * <p>   时间复杂度：O(n)，其中 n 是字符串的长度。判断整个字符串是否是回文字符串的时间复杂度是 O(n)，
   * <p>    遇到不同字符时，判断两个子串是否是回文字符串的时间复杂度也都是 O(n)。
   *
   * <p>  空间复杂度：O(1)。只需要维护有限的常量空间
   *
   * <p>作者：LeetCode-Solution
   * <p>链接：https://leetcode-cn.com/problems/valid-palindrome-ii/solution/yan-zheng-hui-wen-zi-fu-chuan-ii-by-leetcode-solut/
   * <p>来源：力扣（LeetCode）
   * <p>著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param s
   * @return
   */
  public boolean validPalindrome(String s) {
    int low = 0, high = s.length() - 1;
    while (low < high) {
      char c1 = s.charAt(low), c2 = s.charAt(high);
      if (c1 == c2) {
        ++low;
        --high;
      } else {
        return validPalindrome(s, low, high - 1) || validPalindrome(s, low + 1, high);
      }
    }
    return true;
  }

  public boolean validPalindrome(String s, int low, int high) {
    for (int i = low, j = high; i < j; ++i, --j) {
      char c1 = s.charAt(i), c2 = s.charAt(j);
      if (c1 != c2) {
        return false;
      }
    }
    return true;
  }

  public boolean validPalindrome2(String s) {
    int low = 0, height = s.length() - 1;
    while (low < height) {
      char c1 = s.charAt(low), c2 = s.charAt(height);
      if (c1 == c2) {
        low++;
        height--;
      } else {
        return validPalindrome2(s, low + 1, height) || validPalindrome2(s, low, height - 1);
      }
    }
    return true;
  }

  public boolean validPalindrome2(String s, int low, int height) {
    while (low < height) {
      char c1 = s.charAt(low), c2 = s.charAt(height);
      if (c1 == c2) {
        low++;
        height--;
      } else {
        return false;
      }
    }
    return true;
  }


}
