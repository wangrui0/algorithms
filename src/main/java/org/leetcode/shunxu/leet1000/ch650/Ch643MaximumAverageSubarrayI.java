package org.leetcode.shunxu.leet1000.ch650;

/**
 * <p>643. 子数组最大平均数 I
 *
 * <p>给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 *
 *
 *
 * <p>示例：
 *
 * <p>输入：[1,12,-5,-6,50,3], k = 4
 * <p>输出：12.75
 * <p>解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= k <= n <= 30,000。
 * <p>    所给数据范围 [-10,000，10,000]。
 * <p>https://leetcode-cn.com/problems/maximum-average-subarray-i/
 * <p>通过次数54,014
 * <p>提交次数118,756
 * <p>@author: wangrui
 * <p>@date: 2021/3/18
 */
public class Ch643MaximumAverageSubarrayI {


    public double findMaxAverage(int[] nums, int k) {
        int maxSum = 0, sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        // 0 1 2 3 4
        maxSum = sum;
        for (int i = k; i < nums.length; i++) {
            sum = sum - nums[i - k] + nums[i];
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum * 1.0 / k;
    }

    /**
     * 复杂度分析
     *
     * 时间复杂度:O(n)，其中 nn 是数组 nums 的长度。遍历数组一次。
     *
     * 空间复杂度：O(1)。
     * @param nums
     * @param k
     * @return
     */
    public double findMaxAverage2(int[] nums, int k) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;
        for (int i = k; i < n; i++) {
            sum = sum - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        return 1.0 * maxSum / k;
    }
}
