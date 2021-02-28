package org.leetcode.shunxu.ch350;

/**
 * <p> 342. 4的幂
 *
 * <p> 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
 *
 * <p> 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x
 *
 *
 *
 * <p> 示例 1：
 *
 * <p> 输入：n = 16
 * <p> 输出：true
 *
 * <p> 示例 2：
 *
 * <p> 输入：n = 5
 * <p> 输出：false
 *
 * <p> 示例 3：
 *
 * <p> 输入：n = 1
 * <p> 输出：true
 *
 *
 *
 * <p> 提示：
 *
 * <p>     -231 <= n <= 231 - 1
 *
 *
 *
 * <p> 进阶：
 *
 * <p>     你能不使用循环或者递归来完成本题吗？
 *
 * <p> 通过次数39,884
 * <p> 提交次数79,789
 * <p> 在真实的面试中遇到过这道题？
 * <p> https://leetcode-cn.com/problems/power-of-four/
 *
 * @author: wangrui
 * @date: 2021/2/28
 */
public class Ch342PowerOfFour {

  public boolean isPowerOfFour(int n) {
    if (n <= 0) {
      return false;
    }
    while (n % 4 == 0) {
      n /= 4;
    }
    return n == 1;
  }

  //101010...10
  public boolean isPowerOfFour2(int num) {
    return (num > 0) && ((num & (num - 1)) == 0) && ((num & 0xaaaaaaaa) == 0);
  }

  //101010...10
  //4 16 64
  public boolean isPowerOfFour3(int num) {
    return (num > 0) && ((num & (num - 1)) == 0) && (num % 3 == 1);
  }
}
