package org.leetcode.lcp;

import java.util.Arrays;

/**
 * <p>LCP 28. 采购方案
 * <p>小力将 N 个零件的报价存于数组 nums。小力预算为 target，假定小力仅购买两个零件，要求购买零件的花费不超过预算，请问他有多少种采购方案。
 *
 * <p>注意：答案需要以 1e9 + 7 (1000000007) 为底取模，如：计算初始结果为：1000000008，请返回 1
 *
 * <p>示例 1：
 *
 * <p>输入：nums = [2,5,3,5], target = 6
 *
 * <p>输出：1
 *
 * <p>解释：预算内仅能购买 nums[0] 与 nums[2]。
 *
 * <p>示例 2：
 *
 * <p>输入：nums = [2,2,1,9], target = 10
 *
 * <p>输出：4
 *
 * <p>解释：符合预算的采购方案如下：
 * <p>nums[0] + nums[1] = 4
 * <p>nums[0] + nums[2] = 3
 * <p>nums[1] + nums[2] = 3
 * <p>nums[2] + nums[3] = 10
 *
 * <p>提示：
 *
 * <p>2 <= nums.length <= 10^5
 * <p>1 <= nums[i], target <= 10^5
 * <p>通过次数5,910提交次数25,126
 * <p>https://leetcode-cn.com/problems/4xy4Wx/
 * <p>@Author: shenpei
 * <p>@Date: 2021/4/25 10:22 下午
 */
public class LCP028_4xy4Wx {
    public int purchasePlans(int[] nums, int target) {
        int mod = 1_000_000_007;
        int ans = 0;
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] > target) right--;
            else {
                ans += right - left;
                left++;
            }
            ans %= mod;
        }
        return ans % mod;
    }

    public int purchasePlans_2(int[] nums, int target) {
        int mod = 1_000_000_007;
        Arrays.sort(nums);
        int ans = 0;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] > target) {
                right--;
            } else {
                ans += (right - left);
                left++;
            }
            ans = ans % mod;
        }
        return ans % mod;
    }


}
