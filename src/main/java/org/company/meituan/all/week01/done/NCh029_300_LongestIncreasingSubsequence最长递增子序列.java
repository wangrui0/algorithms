package org.company.meituan.all.week01.done;

/**
 * <p>300. 最长递增子序列
 *
 * <p>给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * <p>子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 *
 * <p>示例 1：
 *
 * <p>输入：nums = [10,9,2,5,3,7,101,18]
 * <p>输出：4
 * <p>解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 *
 * <p>示例 2：
 *
 * <p>输入：nums = [0,1,0,3,2,3]
 * <p>输出：4
 *
 * <p>示例 3：
 *
 * <p>输入：nums = [7,7,7,7,7,7,7]
 * <p>输出：1
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= nums.length <= 2500
 * <p>    -104 <= nums[i] <= 104
 *
 *
 *
 * <p>进阶：
 *
 * <p>    你可以设计时间复杂度为 O(n^2) 的解决方案吗？
 * <p>    你能将算法的时间复杂度降低到 O(n log(n)) 吗?
 *
 * <p>通过次数263,814
 * <p>提交次数533,884
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * <p>@author: wangrui
 * <p>@date: 2021/5/10
 */
public class NCh029_300_LongestIncreasingSubsequence最长递增子序列 {
    /**
     * <p>方法一：动态规划
     * <p>复杂度分析
     * <p>
     * <p>时间复杂度：O(n^2)，其中 n 为数组 nums 的长度。动态规划的状态数为 n，计算状态 dp[i] 时，需要 O(n) 的时间遍历 dp[0…i−1] 的所有状态，所以总时间复杂度为 O(n^2)
     * <p>
     * <p>空间复杂度：O(n)，要额外使用长度为 n 的 dp 数组。
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }

    /**
     * <p>方法二：贪心 + 二分查找
     * <p>复杂度分析
     *
     * <p>时间复杂度：O(nlogn)。数组 nums 的长度为 n，我们依次用数组中的元素去更新 d 数组，而更新 d 数组时需要进行 O(logn) 的二分搜索，所以总时间复杂度为 O(nlogn)。
     *
     * <p>空间复杂度：O(n)，需要额外使用长度为 n 的 d 数组。
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS_2(int[] nums) {
        int len = 1, n = nums.length;
        if (n == 0) {
            return 0;
        }
        //我们维护一个数组 d[i] ，表示长度为 i 的最长上升子序列的末尾元素的最小值，用 len 记录目前最长上升子序列的长度，
        // 起始时 len 为 1，d[1] =nums[0]。
        int[] d = new int[n + 1];
        d[len] = nums[0];
        for (int i = 1; i < n; ++i) {
            if (nums[i] > d[len]) {
                d[++len] = nums[i];
            } else {
                int l = 1, r = len, pos = 0; // 如果找不到说明所有的数都比 nums[i] 大，此时要更新 d[1]，所以这里将 pos 设为 0
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (d[mid] < nums[i]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                d[pos + 1] = nums[i];
            }
        }
        return len;
    }


}
