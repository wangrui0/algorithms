package org.leetcode.shunxu.ch350;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>345. 反转字符串中的元音字母
 *
 * <p>编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入："hello"
 * <p>输出："holle"
 *
 * <p>示例 2：
 *
 * <p>输入："leetcode"
 * <p>输出："leotcede"
 * a、e、i、o、u
 *
 *
 * <p>提示：
 *
 * <p>    元音字母不包含字母 "y" 。
 * <p>    https://leetcode-cn.com/problems/reverse-vowels-of-a-string/
 *
 * @author: wangrui
 * @date: 2021/2/28
 */
public class Ch345ReverseVowelsOfAString {

  private final static HashSet<Character> vowels = new HashSet<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A',
      'E', 'I', 'O', 'U'));

  /**
   * <p>使用双指针，一个指针从头向尾遍历，一个指针从尾到头遍历，当两个指针都遍历到元音字符时，交换这两个元音字符。
   * <p>为了快速判断一个字符是不是元音字符，我们将全部元音字符添加到集合 HashSet 中，从而以 O(1) 的时间复杂度进行该操作。
   * <p>时间复杂度为 O(N)：只需要遍历所有元素一次
   * <p>空间复杂度 O(1)：只需要使用两个额外变量
   *
   * <p>作者：simple-zd
   * <p>链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string/solution/shuang-zhi-zhen-jie-ti-by-simple-zd-kn6k/
   * <p>来源：力扣（LeetCode）
   * <p>著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param s
   * @return
   */
  public static String reverseVowels(String s) {
    char[] chars = s.toCharArray();
    for (int left = 0, right = chars.length - 1; left <= right; left++, right--) {
      while (!vowels.contains(chars[left]) && left < right) {
        left++;
      }
      while (!vowels.contains(chars[right]) && left < right) {
        right--;
      }
      char temp = chars[left];
      chars[left] = chars[right];
      chars[right] = temp;

    }
    return new String(chars);
  }


  public String reverseVowels2(String s) {
    if (s == null) {
      return null;
    }
    int low = 0, high = s.length() - 1;
    char[] c = new char[s.length()];
    while (low <= high) {
      char cl = s.charAt(low);
      char ch = s.charAt(high);
      if (!vowels.contains(cl)) {
        c[low++] = cl;
      } else if (!vowels.contains(ch)) {
        c[high--] = ch;
      } else {
        c[low++] = ch;
        c[high--] = cl;
      }
    }
    return new String(c);
  }
}
