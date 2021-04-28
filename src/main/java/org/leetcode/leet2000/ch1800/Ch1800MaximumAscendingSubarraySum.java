package org.leetcode.leet2000.ch1800;

/**
 * <p>1800. 最大升序子数组和
 *
 * <p>给你一个正整数组成的数组 nums ，返回 nums 中一个 升序 子数组的最大可能元素和。
 *
 * <p>子数组是数组中的一个连续数字序列。
 *
 * <p>已知子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，若对所有 i（l <= i < r），numsi < numsi+1 都成立，则称这一子数组为 升序 子数组。注意，大小为 1
 * 的子数组也视作 升序 子数组。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：nums = [10,20,30,5,10,50]
 * <p>输出：65
 * <p>解释：[5,10,50] 是元素和最大的升序子数组，最大元素和为 65 。
 *
 * <p>示例 2：
 *
 * <p>输入：nums = [10,20,30,40,50]
 * <p>输出：150
 * <p>解释：[10,20,30,40,50] 是元素和最大的升序子数组，最大元素和为 150 。
 *
 * <p>示例 3：
 *
 * <p>输入：nums = [12,17,15,13,10,11,12]
 * <p>输出：33
 * <p>解释：[10,11,12] 是元素和最大的升序子数组，最大元素和为 33 。
 *
 * <p>示例 4：
 *
 * <p>输入：nums = [100,10,1]
 * <p>输出：100
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= nums.length <= 100
 * <p>    1 <= nums[i] <= 100
 *
 * <p>通过次数7,355
 * <p>提交次数10,730
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/maximum-ascending-subarray-sum/
 * <p>@Author: shenpei
 * <p>@Date: 2021/4/25 10:16 下午
 */
public class Ch1800MaximumAscendingSubarraySum {


    public static int maxAscendingSum_self(int[] nums) {
        int ans = 0;
        int sum = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                sum += nums[i + 1];
            } else {
                ans = Math.max(ans, sum);
                sum = nums[i + 1];
            }
        }
        return Math.max(ans, sum);
    }

    public int maxAscendingSum(int[] nums) {

        // result用来存放返回结果，初始值设置为 -1
        int result = -1;
        int len = nums.length;
        // i是逐步增大的
        for (int i = 0; i < len; i++) {
            //从nums[i]开始寻找
            int k = nums[i];
            while (i + 1 < len && nums[i + 1] > nums[i]) {
                k += nums[i + 1];
                i++;
            }

            //如果k大于result 则更新result
            if (k > result) {
                result = k;
            }
        }
        return result;
    }

    public int maxAscendingSum_2(int[] nums) {

        int ans = nums[0]; // 先选取数组第一个值作为答案，可应对当数组仅有1个元素的情况
        int cur = nums[0]; // 用cur记录本次持续升序的所有元素的累积和

        for (int i = 1; i < nums.length; i++) { // 从索引1开始遍历
            if (nums[i] > nums[i - 1]) { // 当前元素比前一个大，说明当前是升序状态
                cur += nums[i]; // 升序状态就让cur累加当前的值
            } else {
                // 遇到降序之后，就让 刚才累加的cur的值 与 当前值nums[i] 做个大小比较，选取最大的作为当前位置的最大值
                // 然后再与总的结果ans进行判断，留下最大值
                ans = Math.max(ans, Math.max(cur, nums[i]));
                cur = nums[i]; // 把累积的cur的值清空，换成当前值，表示从头开始累积
            }
        }
        ans = Math.max(ans, cur); // 把数组最后一组升序元素累积的值拿出来进行判断
        return ans;
    }


}
