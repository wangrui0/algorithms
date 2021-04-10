package org.leetcode.shunxu.ch1150;

/**
 * <p> 1134. 阿姆斯特朗数
 * <p>1. 题目
 * <p>假设存在一个 k 位数 N，其每一位上的数字的 k 次幂的总和也是 N，那么这个数是阿姆斯特朗数。
 *
 * <p>给你一个正整数 N，让你来判定他是否是阿姆斯特朗数，是则返回 true，不是则返回 false。
 *
 * <p>示例 1：
 * <p>输入：153
 * <p>输出：true
 * <p>示例：
 * <p>153 是一个 3 位数，且 153 = 1^3 + 5^3 + 3^3。
 *
 * <p>示例 2：
 * <p>输入：123
 * <p>输出：false
 * <p>解释：
 * <p>123 是一个 3 位数，且 123 != 1^3 + 2^3 + 3^3 = 36。
 *
 * <p>提示：
 * <p>1 <= N <= 10^8
 * <p> 来源：力扣（LeetCode）
 * <p> 链接：https://leetcode-cn.com/problems/armstrong-number
 * <p> 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>@author: wangrui
 * <p>@date: 2021/4/9
 */
public class Ch1134ArmstrongNumber {

  public static void main(String[] args) {
    System.out.println(isArmstrong(123));
  }

  public static Boolean isArmstrong(int N) {
    int k = 0;
    int temp = N;
    while (temp > 0) {
      k++;
      temp /= 10;
    }
    temp=N;
    int sum = 0;
    while (temp > 0) {
      sum += Math.pow(temp % 10, k);
      temp /= 10;
    }
    return sum == N;
  }
}
