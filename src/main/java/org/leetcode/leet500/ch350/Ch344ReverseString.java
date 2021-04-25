package org.leetcode.leet500.ch350;

/**
 * <p>  344. 反转字符串
 *
 * <p> 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 *
 * <p> 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 * <p> 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 *
 *
 *
 * <p> 示例 1：
 *
 * <p> 输入：["h","e","l","l","o"]
 * <p> 输出：["o","l","l","e","h"]
 *
 * <p> 示例 2：
 *
 * <p>  输入：["H","a","n","n","a","h"]
 * <p> 输出：["h","a","n","n","a","H"]
 *
 * <p> https://leetcode-cn.com/problems/reverse-string/
 *
 * @author: wangrui
 * @date: 2021/2/28
 */
public class Ch344ReverseString {

  /**
   * <p>  复杂度分析
   *
   * <p>      时间复杂度：O(N)，其中 N 为字符数组的长度。一共执行了 N/2 次的交换。
   * <p>      空间复杂度：O(1)。只使用了常数空间来存放若干变量。
   *
   * <p> 作者：LeetCode-Solution
   * <p>  链接：https://leetcode-cn.com/problems/reverse-string/solution/fan-zhuan-zi-fu-chuan-by-leetcode-solution/
   * <p>  来源：力扣（LeetCode）
   * <p>  著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param s
   */
  public void reverseString(char[] s) {
    int n = s.length;
    for (int left = 0, right = n - 1; left < right; ++left, --right) {
      char tmp = s[left];
      s[left] = s[right];
      s[right] = tmp;
    }
  }

  public void reverseString2(char[] s) {
    for (int left = 0, right = s.length - 1; left < right; left++, right--) {
      char temp = s[left];
      s[left] = s[right];
      s[right] = temp;
    }
  }
}
