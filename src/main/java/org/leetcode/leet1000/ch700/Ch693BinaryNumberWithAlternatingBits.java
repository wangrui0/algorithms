package org.leetcode.leet1000.ch700;

/**
 * <p>693. 交替位二进制数
 * <p>给定一个正整数，检查它的二进制表示是否总是 0、1 交替出现：换句话说，就是二进制表示中相邻两位的数字永不相同。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：n = 5
 * <p>输出：true
 * <p>解释：5 的二进制表示是：101
 * <p>示例 2：
 *
 * <p>输入：n = 7
 * <p>输出：false
 * <p>解释：7 的二进制表示是：111.
 * <p>示例 3：
 *
 * <p>输入：n = 11
 * <p>输出：false
 * <p>解释：11 的二进制表示是：1011.
 * <p>示例 4：
 *
 * <p>输入：n = 10
 * <p>输出：true
 * <p>解释：10 的二进制表示是：1010.
 * <p>示例 5：
 *
 * <p>输入：n = 3
 * <p>输出：false
 * <p>https://leetcode-cn.com/problems/binary-number-with-alternating-bits/
 *
 * @Author: shenpei
 * @Date: 2021/3/18 11:33 下午
 */
public class Ch693BinaryNumberWithAlternatingBits {

  /**
   * <p>方法一：转换成字符串
   *
   * <p>    算法：
   * <p>   让我们把给定的数字转换成一个二进制数字串。然后，我们应该简单地检查两个相邻的数字是否相同。
   *
   * <p>  复杂度分析
   *
   * <p>   时间复杂度：O(1)。对于任意输入，我们执行 O(w) 工作，其中 w 是 n 中的二进制位数且 w≤32。
   * <p>   空间复杂度：O(1)，或者 O(w)。
   */
  public boolean hasAlternatingBits(int n) {
    StringBuilder sb = new StringBuilder();
    while (n > 0) {
      sb.append(n % 2);
      n /= 2;
    }
    for (int i = 0; i < sb.length() - 1; i++) {
      if (sb.charAt(i) == sb.charAt(i + 1)) {
        return false;
      }
    }
    return true;
  }

  /**
   * <p>方法二：除以2
   *
   * <p>   我们可以通过 n%2 和 n/2 操作获得最后一位和其余的位。如果最后一位等于剩余的最后一位，那么两个相邻的位具有相同的值，则答案是 False 的，反之，答案是 True 的。
   *
   * <p>   复杂度分析
   *
   * <p>   时间复杂度：O(1)。对于任意输入，我们执行 O(w) 工作，其中 w 是 n 中的二进制位数且 w≤32。
   * <p>   空间复杂度：O(1)。
   *
   * <p>  作者：LeetCode
   * <p>  链接：https://leetcode-cn.com/problems/binary-number-with-alternating-bits/solution/jiao-ti-wei-er-jin-zhi-shu-by-leetcode/
   * <p>  来源：力扣（LeetCode）
   * <p> 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  public boolean hasAlternatingBits2(int n) {
    int pre = -1;
    while (n > 0) {
      int num = n % 2;
      if (pre != -1 && num == pre) {
        return false;
      }
      pre = num;
      n /= 2;
    }
    return true;
  }
}
