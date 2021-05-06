package org.company.meituan.algorithm;

import java.util.Arrays;

/**
 * <p>410. 分割数组的最大值
 *
 * <p>给定一个非负整数数组 nums 和一个整数 m ，你需要将这个数组分成 m 个非空的连续子数组。
 *
 * <p>设计一个算法使得这 m 个子数组各自和的最大值最小。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：nums = [7,2,5,10,8], m = 2
 * <p>输出：18
 * <p>解释：
 * <p>一共有四种方法将 nums 分割为 2 个子数组。 其中最好的方式是将其分为 [7,2,5] 和 [10,8] 。
 * <p>因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
 *
 * <p>示例 2：
 *
 * <p>输入：nums = [1,2,3,4,5], m = 2
 * <p>输出：9
 *
 * <p>示例 3：
 *
 * <p>输入：nums = [1,4,4], m = 3
 * <p>输出：4
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= nums.length <= 1000
 * <p>    0 <= nums[i] <= 106
 * <p>    1 <= m <= min(50, nums.length)
 *
 * <p>通过次数31,775
 * <p>提交次数57,712
 * <p>请问您在哪类招聘中遇到此题？
 * <p>|410. 分割数组的最大值|1|https://leetcode-cn.com/problems/split-array-largest-sum|
 * <p>@author: wangrui
 * <p>@date: 2021/5/6
 */
public class Ch010SplitArrayLargestSum分割数组的最大值 {

  /**
   * <p> 方法一：动态规划
   * <p> 复杂度分析
   *
   * <p>   时间复杂度：O(n^2×m)，其中 n 是数组的长度，m 是分成的非空的连续子数组的个数。总状态数为 O(n×m)，状态转移时间复杂度 O(n)，所以总时间复杂度为 O(n^2×m)。
   *
   * <p>  空间复杂度：O(n×m)，为动态规划数组的开销。
   *
   * @param nums
   * @param m
   * @return
   */
  public int splitArray(int[] nums, int m) {
    int n = nums.length;
    int[][] f = new int[n + 1][m + 1];
    for (int i = 0; i <= n; i++) {
      Arrays.fill(f[i], Integer.MAX_VALUE);
    }
    int[] sub = new int[n + 1];
    for (int i = 0; i < n; i++) {
      sub[i + 1] = sub[i] + nums[i];
    }
    f[0][0] = 0;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= Math.min(i, m); j++) {
        for (int k = 0; k < i; k++) {
          f[i][j] = Math.min(f[i][j], Math.max(f[k][j - 1], sub[i] - sub[k]));
        }
      }
    }
    return f[n][m];
  }

  /**
   * <p>复杂度分析
   *
   * <p>    时间复杂度：O(n×log(sum−maxn))，其中 sum 表示数组 nums 中所有元素的和，maxn 表示数组所有元素的最大值。每次二分查找时，需要对数组进行一次遍历，时间复杂度为
   * O(n)，因此总时间复杂度是 O(n×log(sum−maxn))。
   *
   * <p> 空间复杂度：O(1)。
   *
   * @param nums
   * @param m
   * @return
   */
  public int splitArray_2(int[] nums, int m) {
    int left = 0, right = 0;
    for (int i = 0; i < nums.length; i++) {
      right += nums[i];
      if (left < nums[i]) {
        left = nums[i];
      }
    }
    while (left < right) {
      int mid = (right - left) / 2 + left;
      if (check(nums, mid, m)) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }

  public boolean check(int[] nums, int x, int m) {
    int sum = 0;
    int cnt = 1;
    for (int i = 0; i < nums.length; i++) {
      if (sum + nums[i] > x) {
        cnt++;
        sum = nums[i];
      } else {
        sum += nums[i];
      }
    }
    return cnt <= m;
  }
}
