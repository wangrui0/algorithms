package org.leetcode.leet500.ch350;

/**
 * <p>326. 3的幂
 *
 * <p> 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
 *
 * <p>整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3的x 次方
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：n = 27
 * <p>输出：true
 *
 * <p>示例 2：
 *
 * <p>输入：n = 0
 * <p>输出：false
 *
 * <p>示例 3：
 *
 * <p>输入：n = 9
 * <p>输出：true
 *
 * <p>示例 4：
 *
 * <p>输入：n = 45
 * <p>输出：false
 *
 *
 *
 * <p>提示：
 * <p>
 * -231 <= n <= 231 - 1
 *
 *
 *
 * <p>进阶：
 *
 * <p>     你能不使用循环或者递归来完成本题吗？
 *
 * <p>通过次数71,456
 * <p>提交次数148,532
 * <p>在真实的面试中遇到过这道题？
 * <p>来源：力扣（LeetCode）
 * <p>链接: https://leetcode-cn.com/problems/power-of-three/
 *
 * @author: wangrui
 * @date: 2021/2/28
 */
public class Ch326PowerOfThree {

  public static void main(String[] args) {
    System.out.println(isPowerOfThree(27));
  }

  public static boolean isPowerOfThree(int n) {
    if (n <= 0) {
      return false;
    }
    while (n % 3 == 0) {
      n /= 3;
    }
    return n == 1;
  }

  /**
   * 3的19 次方=1162261467
   *
   * @param n
   * @return
   */
  public static boolean isPowerOfThree2(int n) {
//    int pow = new BigDecimal(Math.pow(3, 19)).intValue();
//    System.out.println(pow);
    return n > 0 && 1162261467 % n == 0;
  }
}
