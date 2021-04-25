package org.leetcode.leet500.ch150;

/**
 * <p>验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * <p>
 * 输出: true
 * <p>
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * <p>
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * <p>
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * <p>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: wangrui
 * @date: 2020/11/28
 */
public class Ch0125ValidPalindrome {

  public static void main(String[] args) {
    String str = "A man, a plan, a canal: Panama";
    System.err.println(isPalindrome(str));
  }

  public static boolean isPalindrome(String s) {
    char[] chars = s.toCharArray();
    int n = chars.length - 1;
    for (int i = 0, j = n; i < j; ) {
      while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
        i++;
      }
      if (i > j) {
        return true;
      }
      while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
        j--;
      }
      if (i >= j) {
        return true;
      }

      if (Character.toLowerCase(chars[i]) != Character.toLowerCase(chars[j])) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }

  public boolean isPalindrome2(String s) {
    int n = s.length();
    int left = 0, right = n - 1;
    while (left < right) {
      while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
        ++left;
      }
      while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
        --right;
      }
      if (left < right) {
        if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
          return false;
        }
        ++left;
        --right;
      }
    }
    return true;
  }
}
