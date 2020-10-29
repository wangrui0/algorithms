package org.leetcode;

/**
 * @author: wangrui
 * @date: 2020/10/28
 * <p>
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * <p>
 * 输出: 321
 * <p>
 *  示例 2:
 * <p>
 * 输入: -123
 * <p>
 * 输出: -321
 * <p>
 * 示例 3:
 * <p>
 * 输入: 120
 * <p>
 * 输出: 21
 * <p>
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * <p>
 * 来源：力扣（LeetCode）
 * <p>
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * <p>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Ch0007Reverse {

  public static void main(String[] args) {
    System.out.println(reverse(12345));
    System.out.println(reverse(-12345));
    System.out.println(reverse(-1));
  }

  /**
   * 自己
   *
   * @param x
   * @return
   */
  public static int reverse(int x) {
    if (x >= 0) {
      return Integer.valueOf(reverseStr(x));
    } else {
      int absX = Math.abs(x);
      return 0 - Integer.valueOf(reverseStr(absX));
    }
  }

  /**
   * 自己
   *
   * @param absX
   * @return
   */
  public static String reverseStr(int absX) {
    StringBuilder sb = new StringBuilder();
    String absStr = String.valueOf(absX);
    for (int i = absStr.length() - 1; i >= 0; i--) {
      sb.append(absStr.charAt(i));
    }
    return sb.toString();
  }

  /**
   * 官方
   *
   * @param x
   * @return
   */
  public static int reverse2(int x) {

    return -1;
  }

}
