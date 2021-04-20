package org.leetcode.shunxu.leet500.ch300;

/**
 * <p> 编写一个程序判断给定的数是否为丑数。
 *
 * <p> 丑数就是只包含质因数 2, 3, 5 的正整数。
 *
 * <p> 示例 1:
 *
 * <p> 输入: 6
 * <p> 输出: true
 * <p> 解释: 6 = 2 × 3
 *
 * <p> 示例 2:
 *
 * <p> 输入: 8
 * <p> 输出: true
 * <p> 解释: 8 = 2 × 2 × 2
 *
 * <p> 示例 3:
 *
 * <p> 输入: 14
 * <p> 输出: false
 * <p> 解释: 14 不是丑数，因为它包含了另外一个质因数 7。
 *
 * <p> 说明：
 *
 * <p>     1 是丑数。
 * <p>     输入不会超过 32 位有符号整数的范围: [−231,  231 − 1]。
 *
 * <p> 来源：力扣（LeetCode）
 * <p> 链接：https://leetcode-cn.com/problems/ugly-number
 * <p> 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: wangrui
 * @date: 2021/2/4
 */
public class Ch0263UglyNumber {

  public static void main(String[] args) {
    boolean ugly = isUgly(6);
    System.out.println(ugly);
  }

  public static boolean isUgly(int num) {
    if (num == 0) {
      return false;
    }
    while (num % 2 == 0) {
      num /= 2;
    }
    while (num % 3 == 0) {
      num /= 3;
    }
    while (num % 5 == 0) {
      num /= 5;
    }
    return num == 1;
  }
}
