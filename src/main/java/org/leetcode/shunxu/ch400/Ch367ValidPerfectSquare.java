package org.leetcode.shunxu.ch400;

/**
 * <p> 367. 有效的完全平方数
 *
 * <p> 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 *
 * <p> 说明：不要使用任何内置的库函数，如  sqrt。
 *
 * <p> 示例 1：
 *
 * <p> 输入：16
 * <p> 输出：True
 *
 * <p> 示例 2：
 *
 * <p>输入：14
 * <p> 输出：False
 * <p>https://leetcode-cn.com/problems/valid-perfect-square/
 *
 * @author: wangrui
 * @date: 2021/3/3
 */
public class Ch367ValidPerfectSquare {

  /**
   * 注意:如果可能出现溢出的情况，一定要用long 类型。第一次就弄错了。
   *
   * @param num
   * @return
   */
  public static boolean isPerfectSquare(int num) {
    if (num == 1) {
      return true;
    }
    long left = 1, right = num / 2;
    while (left <= right) {
      long mid = left + (right - left) / 2;
      long guessSquared = mid * mid;
      if (guessSquared == num) {
        return true;
      } else if (guessSquared < num) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return false;
  }

  /**
   * <p>官方
   * <p>复杂度分析
   *
   * <p>   时间复杂度：O(logN)。
   * <p>   空间复杂度：O(1)。
   *
   * <p>作者：LeetCode
   * <p>链接：https://leetcode-cn.com/problems/valid-perfect-square/solution/you-xiao-de-wan-quan-ping-fang-shu-by-leetcode/
   * <p>来源：力扣（LeetCode）
   * <p>著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param num
   * @return
   */
  public static boolean isPerfectSquare2(int num) {
    if (num < 2) {
      return true;
    }

    long left = 2, right = num / 2, x, guessSquared;
    while (left <= right) {
      x = left + (right - left) / 2;
      guessSquared = x * x;
      if (guessSquared == num) {
        return true;
      }
      if (guessSquared > num) {
        right = x - 1;
      } else {
        left = x + 1;
      }
    }
    return false;
  }
}
