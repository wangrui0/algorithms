package org.leetcode.shunxu.leet1500.ch1500;

/**
 * <p>1486. 数组异或操作
 *
 * <p>给你两个整数，n 和 start 。
 *
 * <p>数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length 。
 *
 * <p>请返回 nums 中所有元素按位异或（XOR）后得到的结果。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：n = 5, start = 0
 * <p>输出：8
 * <p>解释：数组 nums 为 [0, 2, 4, 6, 8]，其中 (0 ^ 2 ^ 4 ^ 6 ^ 8) = 8 。
 * <p>     "^" 为按位异或 XOR 运算符。
 *
 * <p>示例 2：
 *
 * <p>输入：n = 4, start = 3
 * <p>输出：8
 * <p>解释：数组 nums 为 [3, 5, 7, 9]，其中 (3 ^ 5 ^ 7 ^ 9) = 8.
 *
 * <p>示例 3：
 *
 * <p>输入：n = 1, start = 7
 * <p>输出：7
 *
 * <p>示例 4：
 *
 * <p>输入：n = 10, start = 5
 * <p>输出：2
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= n <= 1000
 * <p>    0 <= start <= 1000
 * <p>    n == nums.length
 *
 * <p>通过次数32,281
 * <p>提交次数38,431
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/xor-operation-in-an-array/
 * <p>@author: wangrui
 * <p>@date: 2021/4/22
 */
public class Ch1486XorOperationInAnArray {

  /**
   * <p> 复杂度分析
   *
   * <p>   时间复杂度：O(n)。这里用一重循环对 n 个数字进行异或。
   *
   * <p>  空间复杂度：O(1)。这里只是用了常量级别的辅助空间。
   *
   * @param n
   * @param start
   * @return
   */
  public int xorOperation(int n, int start) {
    int ans = 0;
    for (int i = 0; i < n; i++) {
      ans ^= (start + 2 * i);
    }
    return ans;
  }
}
