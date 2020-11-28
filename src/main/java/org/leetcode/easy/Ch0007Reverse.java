package org.leetcode.easy;

/**
 * @author: wangrui
 * @date: 2020/10/28
 * <p>
 * 整数反转
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
    System.out.println(reverse2(12345));
    System.out.println(reverse2(-12345));
    System.out.println(reverse2(-1));
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
   * <p>
   * 方法：弹出和推入数字 & 溢出前进行检查
   * <p>
   * 思路
   * <p>
   * 我们可以一次构建反转整数的一位数字。在这样做的时候，我们可以预先检查向原整数附加另一位数字是否会导致溢出。
   * <p>
   * 算法
   * <p>
   * 反转整数的方法可以与反转字符串进行类比。
   * <p>
   * 我们想重复“弹出” x 的最后一位数字，并将它“推入”到 rev 的后面。最后，rev 将与 x 相反。
   * <p>
   * 要在没有辅助堆栈 / 数组的帮助下 “弹出” 和 “推入” 数字，我们可以使用数学方法。
   * <p>
   * //pop operation:
   * <p>
   * pop = x % 10;
   * <p>
   * x /= 10;
   * <p>
   * //push operation:
   * <p>
   * temp = rev * 10 + pop;
   * <p>
   * rev = temp;
   * <p>
   * 但是，这种方法很危险，因为当 temp =rev*10 + pop 时会导致溢出。
   * <p>
   * 幸运的是，事先检查这个语句是否会导致溢出很容易。
   * <p>
   * 为了便于解释，我们假设 rev  rev 是正数。
   * <p>
   * 如果 temp = rev*10 + pop  导致溢出，那么一定有 rev  >= INTMAX/10
   * <p>
   * 如果 rev  > INTMAX/10  那么 temp = rev*10 + pop一定会溢出。
   * <p>
   * 如果 rev   == INTMAX/10  那么只要 pop   > 7，temp = rev*10 + pop  temp=rev⋅10+pop 就会溢出。
   * <p>
   * 当 rev  rev 为负时可以应用类似的逻辑。
   * <p>
   *
   * @param x
   * @return
   */
  public static int reverse2(int x) {
    int rev = 0;
    while (x != 0) {
      int pop = x % 10;
      x /= 10;
      if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
        return 0;
      }
      if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
        return 0;
      }
      rev = rev * 10 + pop;
    }
    return rev;
  }

}
    
  
