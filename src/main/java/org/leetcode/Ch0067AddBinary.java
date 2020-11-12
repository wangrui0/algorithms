package org.leetcode;

/**
 * <p>
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * <p>
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * <p>
 * 输出: "100"
 * <p>
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * <p>
 * 输出: "10101"  <p> 提示：
 * <p>
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * <p>
 * 1 <= a.length, b.length <= 10^4
 * <p>
 * 字符串如果不是 "0" ，就都不含前导零。
 * <p>
 * 来源：力扣（LeetCode）
 * <p>
 * 链接：https://leetcode-cn.com/problems/add-binary
 * <p>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 *
 * @author: wangrui
 * @date: 2020/11/11
 */
public class Ch0067AddBinary {

  public static void main(String[] args) {
    System.out.println(addBinary3("11", "1"));//100
    System.out.println(addBinary3("1010", "1011"));//10101
  }

  /**
   * a = "1010", b = "1011"
   *
   * @param a
   * @param b
   * @return
   */
  public static String addBinary(String a, String b) {
    int aLength = a.length();
    int bLength = b.length();
    if (a.length() == 0) {
      return b;
    }
    if (b.length() == 0) {
      return a;
    }
    int min = Math.min(aLength, bLength);
    StringBuilder sb = new StringBuilder();
    int carry = 0;
    for (int i = 0; i < min; i++) {
      int num1 = b.charAt(bLength - 1 - i) - 48;
      int num2 = a.charAt(aLength - 1 - i) - 48;
      int sum = num1 + num2 + carry;
      carry = sum / 2;
      sb.append(sum % 2);
    }
    if (aLength > bLength) {
      for (int j = min; aLength - 1 - j >= 0; j++) {
        int num = a.charAt(aLength - 1 - j) - 48;
        int sum = num + carry;
        sb.append(sum % 2);
        carry = sum / 2;
      }
    } else {
      for (int i = min; bLength - 1 - i >= 0; i++) {
        int num = b.charAt(bLength - 1 - i) - 48;
        int sum = num + carry;
        carry = sum / 2;
        sb.append(sum % 2);
      }
    }
    if (carry != 0) {
      sb.append(1);
    }
    return sb.reverse().toString();
  }

  /**
   * 方法一：模拟
   * <p>
   * 思路和算法
   * <p>
   * 我们可以借鉴「列竖式」的方法，末尾对齐，逐位相加。在十进制的计算中「逢十进一」，二进制中我们需要「逢二进一」。
   * <p>
   * 具体的，我们可以取 n = max{∣a∣,∣b∣}，循环 n 次，从最低位开始遍历。我们使用一个变量 carry 表示上一个位置的进位，初始值为 0。记当前位置对其的两个位为 a_i ​ 和 b_i ​
   * <p>
   * ，则每一位的答案为 (carry+a_i+b_i)mod2，下一位的进位为 (carry+a_i+b_i)/2
   * <p>
   * ​。重复上述步骤，直到数字 a 和 b 的每一位计算完毕。最后如果 carry 的最高位不为 0，则将最高位添加到计算结果的末尾。
   * <p>
   * 注意，为了让各个位置对齐，你可以先反转这个代表二进制数字的字符串，然后低下标对应低位，高下标对应高位。当然你也可以直接把 a 和 bb 中短的那一个补 0
   * <p>
   * 直到和长的那个一样长，然后从高位向低位遍历，对应位置的答案按照顺序存入答案字符串内，最终将答案串反转。这里的代码给出第一种的实现。
   * <p>
   * 复杂度分析
   * <p>
   * 假设 n=max{∣a∣,∣b∣}。
   * <p>
   * 时间复杂度：O(n)，这里的时间复杂度来源于顺序遍历 a 和 b。
   * <p>
   * 空间复杂度：O(1)，除去答案所占用的空间，这里使用了常数个临时变量。
   * <p>
   *
   * @param a
   * @param b
   * @return
   */
  public static String addBinary2(String a, String b) {
    StringBuffer ans = new StringBuffer();

    int n = Math.max(a.length(), b.length()), carry = 0;
    for (int i = 0; i < n; ++i) {
      carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
      carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
      ans.append((char) (carry % 2 + '0'));
      carry /= 2;
    }

    if (carry > 0) {
      ans.append('1');
    }
    ans.reverse();

    return ans.toString();
  }

  /**
   * 1010 10111
   *
   * @param a
   * @param b
   * @return
   */
  public static String addBinary3(String a, String b) {
    if (a.length() == 0) {
      return b;
    }
    if (b.length() == 0) {
      return a;
    }
    int maxLength = Math.max(a.length(), b.length());
    int carry = 0;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < maxLength; i++) {
      carry += i < a.length() ? a.charAt(a.length() - 1 - i) - '0' : 0;
      carry += i < b.length() ? b.charAt(b.length() - 1 - i) - '0' : 0;
      sb.append(carry % 2);
      carry /= 2;
    }
    if (carry != 0) {
      sb.append(1);
    }
    return sb.reverse().toString();
  }

}
