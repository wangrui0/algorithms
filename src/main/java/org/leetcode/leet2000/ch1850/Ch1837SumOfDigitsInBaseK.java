package org.leetcode.leet2000.ch1850;

/**
 * <p>1837. K 进制表示下的各位数字总和
 *
 * <p>给你一个整数 n（10 进制）和一个基数 k ，请你将 n 从 10 进制表示转换为 k 进制表示，计算并返回转换后各位数字的 总和 。
 *
 * <p>转换后，各位数字应当视作是 10 进制数字，且它们的总和也应当按 10 进制表示返回。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：n = 34, k = 6
 * <p>输出：9
 * <p>解释：34 (10 进制) 在 6 进制下表示为 54 。5 + 4 = 9 。
 *
 * <p>示例 2：
 *
 * <p>输入：n = 10, k = 10
 * <p>输出：1
 * <p>解释：n 本身就是 10 进制。 1 + 0 = 1 。
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= n <= 100
 * <p>    2 <= k <= 10
 *
 * <p>通过次数4,366
 * <p>提交次数5,494
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/sum-of-digits-in-base-k/
 * <p>@Author: shenpei
 * <p>@Date: 2021/4/25 10:21 下午
 */
public class Ch1837SumOfDigitsInBaseK {

  /**
   * <p>复杂度分析
   *
   * <p>    时间复杂度：O(logn)，循环的次数与 n 在 k 进制下的位数相同。
   *
   * <p>    空间复杂度：O(1)。
   *
   * @param n
   * @param k
   * @return
   */
  public int sumBase(int n, int k) {
    int ans = 0;
    while (n > 0) {
      ans += n % k;
      n /= k;
    }
    return ans;
  }

//  class Solution {
//    public:
//    int sumBase(int n, int k) {
//      int res = 0;
//      while (n){
//        res += n % k;
//        n /= k;
//      }
//      return res;
//    }
//  };
}
