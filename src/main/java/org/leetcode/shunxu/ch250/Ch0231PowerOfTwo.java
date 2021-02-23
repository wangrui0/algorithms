package org.leetcode.shunxu.ch250;

/**
 * <p> 231. 2的幂
 *
 * <p> 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 *
 * <p> 示例 1:
 *
 * <p> 输入: 1
 * <p> 输出: true
 * <p> 解释: 2^0 = 1
 *
 * <p> 示例 2:
 *
 * <p> 输入: 16
 * <p> 输出: true
 * <p> 解释: 2^4 = 16
 *
 * <p> 示例 3:
 *
 * <p> 输入: 218
 * <p> 输出: false
 *
 * <p> 通过次数94,909
 * <p> 提交次数193,619
 * <p> 在真实的面试中遇到过这道题？https://leetcode-cn.com/problems/power-of-two/
 *
 * @author: wangrui
 * @date: 2021/1/25
 */
public class Ch0231PowerOfTwo {


  public static void main(String[] args) {
    System.out.println(2 & 1);
  }


  /**
   * <p> 按位与 1000000
   * <p>        0111111
   * <p> 与（&）、非（~）、或（|）、异或（^）
   *
   * @param n
   * @return
   */
  public boolean isPowerOfTwo(int n) {
    if (n == 0) {
      return false;
    }
    long x = (long) n;
    return (x & (x - 1)) == 0;
  }

  /**
   * <p> 我们通过 x & (-x) 保留了最右边的 1，并将其他位设置为 0 若 x 为 2 的幂，则它的二进制表示中只包含一个 1，则有 x & (-x) = x。
   *
   * <p> 若 x 不是 2 的幂，则在二进制表示中存在其他 1，因此 x & (-x) != x。
   *
   * <p> 因此判断是否为 2 的幂的关键是：判断 x & (-x) == x。
   *
   * <p> 作者：LeetCode
   * <p> 链接：https://leetcode-cn.com/problems/power-of-two/solution/2de-mi-by-leetcode/
   * <p>来源：力扣（LeetCode）
   * <p> 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param n
   * @return
   */
  public boolean isPowerOfTwo2(int n) {
    if (n == 0) {
      return false;
    }
    long x = (long) n;
    return (x & (-x)) == x;
  }

  /**
   * 1、正数补码
   * 正数的就比较简单了   反码=补码=原码
   *
   * 2、负数补码
   * 负数就复杂一点了
   *
   * 例如-4
   *
   * 首先4的二进制为0000 0100
   *
   * 反码（取反）：符号位变为1，紧跟着后面的每一位取反，得1111 1011
   *
   * 补码：用反码加1，二进制相加，逢2进1。得1111 1100
   */


}
