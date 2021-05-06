package org.company.meituan;

/**
 * <p>7. 整数反转
 *
 * <p>给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * <p>如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * <p>假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：x = 123
 * <p>输出：321
 *
 * <p>示例 2：
 *
 * <p>输入：x = -123
 * <p>输出：-321
 *
 * <p>示例 3：
 *
 * <p>输入：x = 120
 * <p>输出：21
 *
 * <p>示例 4：
 *
 * <p>输入：x = 0
 * <p>输出：0
 *
 *
 *
 * <p>提示：
 *
 * <p>   -231 <= x <= 231 - 1
 *
 * <p>通过次数693,125
 * <p>提交次数1,958,008
 * <p>请问您在哪类招聘中遇到此题？
 * <p>|7. 整数反转|1|https://leetcode-cn.com/problems/reverse-integer|
 * <p>@author: wangrui
 * <p>@date: 2021/5/6
 */
public class Ch009ReverseInteger整数反转 {

  /**
   * <p> 复杂度分析
   *
   * <p>    时间复杂度：O(log∣x∣)。翻转的次数即 x 十进制的位数。
   *
   * <p>   空间复杂度：O(1)。
   *
   * @param x
   * @return
   */
  public int reverse(int x) {
    int rev = 0;
    while (x != 0) {
      if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
        return 0;
      }
      int digit = x % 10;
      x /= 10;
      rev = rev * 10 + digit;
    }
    return rev;
  }

  public int reverse_2(int x) {
    int rev = 0;
    while (x != 0) {
      if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
        return 0;
      }
      int digit = x % 10;
      x /= 10;
      rev = rev * 10 + digit;
    }
    return rev;
  }

}
