package org.leetcode.shunxu.ch500;

/**
 * <p>476. 数字的补数
 *
 * <p>给你一个 正 整数 num ，输出它的补数。补数是对该数的二进制表示取反。
 *
 *
 *
 * <p> 示例 1：
 *
 * <p>输入：num = 5
 * <p>输出：2
 * <p>解释：5 的二进制表示为 101（没有前导零位），其补数为 010。所以你需要输出 2 。
 *
 * <p>示例 2：
 *
 * <p>输入：num = 1
 * <p>输出：0
 * <p>解释：1 的二进制表示为 1（没有前导零位），其补数为 0。所以你需要输出 0 。
 *
 *
 *
 * <p>提示：
 *
 * <p>    给定的整数 num 保证在 32 位带符号整数的范围内。
 * <p>    num >= 1
 * <p>   你可以假定二进制数不包含前导零位。
 * <p>   本题与 1009 https://leetcode-cn.com/problems/complement-of-base-10-integer/ 相同
 *
 * @author: wangrui
 * @date: 2021/3/11
 */
public class Ch476NumberComplement {

  public static int findComplement(int num) {
    int valid = 0;  // 最高位为1的位数
    int tmp = num;
    while (tmp > 0) {
      tmp /= 2;
      valid++;
    }
    //1 左移valid 位置
    return ~num & ((1 << valid) - 1);
  }

  /**
   * PS：利用了异或的性质
   * <p>
   * A^1=-A。
   * <p>
   * 先用ans求出正整数的二进制位数，然后直接与项ans个1表示的二进制和其异或即可。
   *
   * @param num
   * @return
   */
  public int findComplement2(int num) {
    int cp = num;
    int ans = 0;
    while (cp != 0) {
      cp = cp / 2;
      ans++;
    }
    return num ^ (int) (Math.pow(2, ans) - 1);
  }

  /**
   * self
   *
   * @param num
   * @return
   */
  public static int findComplement4(int num) {
    int maxBitNum = 1;
    int temp = num;
    while (temp != 0) {
      temp >>= 1;
      maxBitNum <<= 1;
    }
    return num ^ (maxBitNum - 1);
  }

  public static int findComplement5(int num) {

    int maxBitNum = 0;
    int tmpNum = num;
    while (tmpNum > 0) {
      maxBitNum += 1;
      tmpNum >>= 1;
    }
    return num ^ ((1 << maxBitNum) - 1);
  }


  /**
   * 1000 0111
   *
   * @param args
   */
  public static void main(String[] args) {
    System.out.println(findComplement(5));
  }
}