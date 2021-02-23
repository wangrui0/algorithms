package org.leetcode.shunxu.ch100;

import java.util.Arrays;

/**
 * 加一；官方解法很棒。令人思索的解法
 * <p>
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1：
 * <p>
 * 输入：digits = [1,2,3]
 * <p>
 * 输出：[1,2,4]
 * <p>
 * 解释：输入数组表示数字 123。
 * <p>
 * 示例 2：
 * <p>
 * 输入：digits = [4,3,2,1]
 * <p>
 * 输出：[4,3,2,2]
 * <p>
 * 解释：输入数组表示数字 4321。
 * <p>
 * 示例 3：
 * <p>
 * 输入：digits = [0]
 * <p>
 * 输出：[1]  <p> 提示：
 * <p>
 * 1 <= digits.length <= 100
 * <p>
 * 0 <= digits[i] <= 9
 * <p>
 * 来源：力扣（LeetCode）
 * <p>
 * 链接：https://leetcode-cn.com/problems/plus-one
 * <p>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 *
 * @author: wangrui
 * @date: 2020/11/11
 */
public class Ch0066PlusOne {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(plusOne2(new int[]{1, 2, 3})));
    System.out.println(Arrays.toString(plusOne2(new int[]{4, 3, 2, 1})));
    System.out.println(Arrays.toString(plusOne2(new int[]{0})));
    System.out.println(Arrays.toString(plusOne2(new int[]{4, 3, 2, 9})));
    System.out.println(Arrays.toString(plusOne2(new int[]{9, 9, 9, 9})));
  }


  public static int[] plusOne(int[] digits) {
    int n = digits.length - 1;
    int plus = 0;
    for (int i = n; i >= 0; i--) {
      int result;
      if (i != n) {
        result = plus + digits[i];
      } else {
        result = plus + digits[i] + 1;
      }
      plus = result / 10;
      digits[i] = result % 10;
      if (i == 0 && plus > 0) {
        int[] newDigits = new int[n + 2];
        for (int j = 1; j < newDigits.length; j++) {
          newDigits[j] = digits[j - 1];
        }
        newDigits[0] = plus;
        digits = newDigits;
      }
    }
    return digits;
  }

  /**
   * 官方:
   * <p>
   * 标签：数组遍历
   * <p>
   * 这道题需要整理出来有哪几种情况，在进行处理会更舒服
   * <p>
   * 末位无进位，则末位加一即可，因为末位无进位，前面也不可能产生进位，比如 45 => 46
   * <p>
   * 末位有进位，在中间位置进位停止，则需要找到进位的典型标志，即为当前位 %10后为 0，则前一位加 1，直到不为 0 为止，比如 499 => 500
   * <p>
   * 末位有进位，并且一直进位到最前方导致结果多出一位，对于这种情况，需要在第 2 种情况遍历结束的基础上，进行单独处理，比如 999 => 1000
   * <p>
   * 对于第三种情况，对其他位进行了赋值 0 处理，直接 new 数组即可
   * <p>
   * 时间复杂度：O(n)
   * <p>
   * 作者：guanpengchn
   * <p>
   * 链接：https://leetcode-cn.com/problems/plus-one/solution/hua-jie-suan-fa-66-jia-yi-by-guanpengchn/
   * <p>
   * 来源：力扣（LeetCode）
   * <p>
   * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   * <p>
   *
   * @param digits
   * @return
   */
  public static int[] plusOne2(int[] digits) {
    for (int i = digits.length - 1; i >= 0; i--) {
      digits[i]++;
      digits[i] = digits[i] % 10;
      if (digits[i] != 0) {
        return digits;
      }
    }
    digits = new int[digits.length + 1];
    digits[0] = 1;
    return digits;
  }
}
