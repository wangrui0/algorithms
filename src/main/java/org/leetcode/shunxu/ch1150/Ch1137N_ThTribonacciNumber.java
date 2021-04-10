package org.leetcode.shunxu.ch1150;

/**
 * <p>1137. 第 N 个泰波那契数
 *
 * <p>泰波那契序列 Tn 定义如下：
 *
 * <p>T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 *
 * <p>给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：n = 4
 * <p>输出：4
 * <p>解释：
 * <p>T_3 = 0 + 1 + 1 = 2
 * <p>T_4 = 1 + 1 + 2 = 4
 *
 * <p>示例 2：
 *
 * <p>输入：n = 25
 * <p>输出：1389537
 *
 *
 *
 * <p>提示：
 *
 * <p>    0 <= n <= 37
 * <p>    答案保证是一个 32 位整数，即 answer <= 2^31 - 1。
 *
 * <p>通过次数26,385
 * <p>提交次数48,658
 * <p>在真实的面试中遇到过这道题？
 * <p>https://leetcode-cn.com/problems/n-th-tribonacci-number/
 * <p>@author: wangrui
 * <p>@date: 2021/4/9
 */
public class Ch1137N_ThTribonacciNumber {

  /**
   * <p>方法一：空间优化：动态计算
   * <p>复杂度分析
   *
   * <p>  时间复杂度：O(N)。
   *
   * <p>空间复杂度：O(1)，保存最后 3 个斐波那契数。
   *
   * @param n
   * @return
   */
  public int tribonacci(int n) {
    if (n < 3) {
      return n == 0 ? 0 : 1;
    }

    int tmp, x = 0, y = 1, z = 1;
    for (int i = 3; i <= n; ++i) {
      tmp = x + y + z;
      x = y;
      y = z;
      z = tmp;
    }
    return z;
  }

  class Tri {

    private int n = 38;
    public int[] nums = new int[n];

    int helper(int k) {
      if (k == 0) {
        return 0;
      }
      if (nums[k] != 0) {
        return nums[k];
      }

      nums[k] = helper(k - 1) + helper(k - 2) + helper(k - 3);
      return nums[k];
    }

    Tri() {
      nums[1] = 1;
      nums[2] = 1;
      helper(n - 1);
    }
  }


  public Tri t = new Tri();

  /**
   * <p>方法二：性能优化：带记忆的递归
   * <p>复杂度分析
   *
   * <p>    时间复杂度：O(1)，预计算 38 个斐波那契数字，并在数组中检索。
   *
   * <p> 空间复杂度：O(1)，存储 38 个斐波那契数字的数组。
   *
   * @param n
   * @return
   */
  public int tribonacci_2(int n) {
    return t.nums[n];
  }

  class Tri2 {

    private int n = 38;
    public int[] nums = new int[n];

    Tri2() {
      nums[1] = 1;
      nums[2] = 1;
      for (int i = 3; i < n; ++i) {
        nums[i] = nums[i - 1] + nums[i - 2] + nums[i - 3];
      }
    }
  }

  public Tri2 t2 = new Tri2();

  public int tribonacci_3(int n) {
    return t2.nums[n];
  }


}
