package org.leetcode.shunxu.ch1050;

/**
 * <p>1009. 十进制整数的反码
 *
 * <p>每个非负整数 N 都有其二进制表示。例如， 5 可以被表示为二进制 "101"，11 可以用二进制 "1011" 表示，依此类推。注意，除 N = 0 外，任何二进制表示中都不含前导零。
 *
 * <p>二进制的反码表示是将每个 1 改为 0 且每个 0 变为 1。例如，二进制数 "101" 的二进制反码为 "010"。
 *
 * <p>给你一个十进制数 N，请你返回其二进制表示的反码所对应的十进制整数。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：5
 * <p>输出：2
 * <p>解释：5 的二进制表示为 "101"，其二进制反码为 "010"，也就是十进制中的 2 。
 *
 * <p>示例 2：
 *
 * <p>输入：7
 * <p>输出：0
 * <p>解释：7 的二进制表示为 "111"，其二进制反码为 "000"，也就是十进制中的 0 。
 *
 * <p>示例 3：
 *
 * <p>输入：10
 * <p>输出：5
 * <p>解释：10 的二进制表示为 "1010"，其二进制反码为 "0101"，也就是十进制中的 5 。
 *
 *
 *
 * <p>提示：
 *
 * <p>    0 <= N < 10^9
 * <p>    本题与 476：https://leetcode-cn.com/problems/number-complement/ 相同
 * https://leetcode-cn.com/problems/complement-of-base-10-integer/
 * <p>通过次数13,220
 * <p>提交次数22,285
 * <p>在真实的面试中遇到过这道题？
 * <p>@author: wangrui
 * <p>@date: 2021/4/3
 */
public class Ch1009ComplementOfBase10Integer {

  /**
   * <p> 原理：原码+反码=(2^n)-1 n为原码二进制位数
   * <p> 循环条件num<=N 即可求出2^n
   *
   * @param N
   * @return
   */
  public int bitwiseComplement_1(int N) {
    if (N == 0) {
      return 1;
    }
    int num = 1;
    while (num <= N) {
      num <<= 1;
    }
    return num - 1 - N;
  }

  /**
   * <p>解2
   *
   * <p>根据反码的定义 等于原码取反
   *
   * <p>原码与对应二进制位数的全1异或就是反码
   *
   * @param N
   * @return
   */
  public int bitwiseComplement_2(int N) {
    int num = 1;
    while (num < N) {
      num = (num << 1) + 1;
    }
    return num ^ N;
  }

  public int bitwiseComplement_3(int N) {

    //对于0需要单独讨论，因为log(x) 的定义域不包括0
    if (N == 0) {
      return 1;
    }

    //java中没有log2(x)函数，默认log以e为底，log10以10为底
    //所以要用换底公式loga(x) / loga(y) = logy(x)
    //所以loge(N) / loge(2) = log2(N)
    int length = (int) (Math.log(N) / Math.log(2)) + 1;

    return (int) (Math.pow(2, length)) - 1 - N;
  }


}


